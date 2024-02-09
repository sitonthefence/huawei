package huaweiC200;



import java.util.*;

public class HW63TWO {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int seatNum = in.nextInt();
        in.nextLine();
        String next = in.nextLine();
        int[] seatOrLeave= Arrays.stream(next.substring(1,next.length()-1).split(", ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> person=new ArrayList<>();
        int index=-1;
        for (int status : seatOrLeave) {
            if (status < 0) {
                person.remove(Integer.valueOf(-status));
                continue;
            }
            if (person.size() == seatNum) {
                index = -1;
                continue;
            }
            if (person.size() == 0) {
                index=0;
                person.add(0);

            } else if (person.size() == 1) {
                index=seatNum-1;
                person.add(seatNum - 1);
            } else {
                Collections.sort(person);
                int maxDistance = Integer.MIN_VALUE;
                for (int i = 0; i < person.size() - 1; i++) {
                    int curGap = person.get(i + 1) - person.get(i);
                    if (curGap > 1) {
                        int curDistance = curGap/2 -1;
                        if (curDistance > maxDistance) {
                            maxDistance = curDistance;
                            index = person.get(i) + curDistance + 1;
                        }
                    }
                    if (person.get(person.size() - 1) != seatNum - 1) {
                        int curDistance = seatNum - 1-person.get(person.size() - 1) - 1;
                        if (curDistance > maxDistance) {
                            maxDistance = curDistance;
                            index = seatNum - 1;
                        }
                    }

                }
                //重要
                person.add(index);
            }
        }
        System.out.println(index);

    }


}
