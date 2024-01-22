package TEST;

import java.util.*;

public class Main {
    // 分块（即连续的相同组的小朋友）
    static class NumCount {
        int num;
        int count;

        public NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 初始小朋友（序号）排队顺序
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nums.length;

        // 序号->组号 映射关系
        int[] map = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map[num] = i / 3;
        }

        // 初始小朋友（组号）排队顺序
        nums = Arrays.stream(nums).map(num -> map[num]).toArray();

        // key是组号，val是对应组号的小朋友分块
        HashMap<Integer, ArrayList<NumCount>> blocks = new HashMap<>();

        // 相邻相同组号合并为块
        LinkedList<NumCount> queue = new LinkedList<>();
        for (int num : nums) {
            if (queue.isEmpty() || queue.getLast().num != num) {
                queue.addLast(new NumCount(num, 1));
                // 记录相同组号的各个分块
                blocks.putIfAbsent(num, new ArrayList<>());
                blocks.get(num).add(queue.getLast());
            } else {
                queue.getLast().count++;
            }
        }


        // 记录调整位置次数
        int moved_count = 0;

        while (queue.size() > 0) {
            NumCount first = queue.removeFirst();
            // 如果开头块是空的，或者开头块已经包含3个小朋友，那么不需要调整位置
            if (first.count == 0 || first.count == 3) continue;

            if (queue.size() == 0) break;

            // 第二块
            NumCount second = queue.getFirst();
            while (second.count == 0) {
                queue.removeFirst();
                second = queue.getFirst();
            }

            // 如果开头块和第二块组号相同，则合并（前面并入后面）
            if (first.num == second.num) {
                second.count += first.count;
                continue;
            }

            /* 如果开头块和第二块组号不同，则进入具体情况分析 */

            if (first.count == 2) {
                // 开头块有2个小朋友，则情况如下组号1例子，此时需要将后面的单独1，并入开头两个1中，即调整一次
                // 1 1 x 1
                moved_count += 1;
                // 后面单独1所在块的小朋友数量清空
                blocks.get(first.num).forEach(block -> block.count = 0);
                continue;
            }

            if (first.count == 1) {
                // 开头块只有1个小朋友，则有两种情况
                if (blocks.get(first.num).size() == 3) {
                    // 对于组号的分块有三个，即如下组号1例子
                    // 1 x 1 y 1 z
                    // 此时需要将后面两个单独1，并入到开头1中，即调整两次
                    moved_count += 2;
                    // 后面两个单独1所在块的小朋友数量清空
                    blocks.get(first.num).forEach(block -> block.count = 0);
                } else {
                    // 对于组号的分块有两个，则如下组号1例子
                    // 1 x 1 1
                    // 此时需要将开头单独1并入到后面两个1中，即调整一次
                    moved_count += 1;
                    // 后面两个1所在块的小朋友数量变为3个
                    blocks.get(first.num).forEach(block -> block.count = 3);
                }
            }
        }

        System.out.println(moved_count);
    }
}