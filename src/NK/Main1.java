package NK;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 每张手牌的数字
        String[] numArr = sc.nextLine().split(" ");
        // 每张手牌的颜色
        String[] colorArr = sc.nextLine().split(" ");

        // 将数字和颜色配对，组成joker
        List<String> jokerList = new ArrayList<>();
        for (int i = 0; i < numArr.length; i++) {
            jokerList.add(numArr[i] + colorArr[i]);
        }

        int maxStep = 0;
        for (int i = 0; i < jokerList.size(); i++) {
            String joker = jokerList.get(i);
            List<String> tempList = new ArrayList<>(jokerList);
            StringBuilder builder = new StringBuilder();
            builder.append(joker).append(" ");
            tempList.remove(joker);
            // 通过深度优先搜索dfs算法获取最优的出牌策略，使打出的手牌最多
            int step = def(joker, tempList, 0, 1, builder);

            System.out.println(builder + " ---> 连续打出的手牌数量=" + step);

            builder = new StringBuilder();

            // 获取可以打出的最多手牌
            if (step > maxStep) {
                maxStep = step;
            }
        }
        System.out.println(maxStep);
    }

    /**
     * 通过深度优先搜索dfs算法获取最优的出牌策略，使打出的手牌最多
     *
     * @param joker     当前的扑克牌
     * @param jokerList 剩下的扑克牌
     * @param i         下一张扑克牌坐标
     * @param step      连续打出的手牌数量
     * @param builder   为了便于分析，将连续打出的扑克牌拼接到一起
     * @return
     */
    public static int def(String joker, List<String> jokerList, int i, int step, StringBuilder builder) {
        // 当没有牌或者剩余的牌都已经搜索完毕时，退出搜索
        if (jokerList.size() == 0 || i == jokerList.size()) {
            return step;
        }

        String next = "";
        // 获取下一张扑克牌
        next = jokerList.get(i);
        i++;
        // 是否可以打出
        if (isSame(joker, next)) {
            builder.append(next).append(" ");
            jokerList.remove(next);
            // 重置当前的扑克牌
            joker = next;
            // 连续打出的手牌+1
            step++;
            // 下一张扑克牌坐标归零
            i = 0;
        }
        return def(joker, jokerList, i, step, builder);
    }

    /**
     * 是否可以打出（玩家手中有和他上一次打出的手牌颜色或者数字相同的手牌）
     * @param joker
     * @param next
     * @return
     */
    private static boolean isSame(String joker, String next) {
        for (int i = 0; i < joker.length(); i++) {
            String numOrColor = joker.charAt(i) + "";
            if (next.contains(numOrColor)) {
                return true;
            }
        }
        return false;
    }
}
