package huaweiAB100;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HW24 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int N= in.nextInt();
            int E=in.nextInt();
            List<Integer> listX=new LinkedList<>();
            listX.add(0);
            List<Integer> OffsetY=new LinkedList<>();
            OffsetY.add(0);
            for (int i = 0; i < N; i++) {
                 listX.add(in.nextInt());
                 OffsetY.add(in.nextInt());
            }
            int currentX=0;
            int currentY=0;
            int square=0;
            for (int i = 0; i <N ; i++) {
                square=square+(listX.get(i))*Math.abs(OffsetY.get(i)+currentY);
                currentX=listX.get(i)+currentX;
                currentY=OffsetY.get(i)-currentY;
            }
            square=square+(E-currentX)*Math.abs(currentY);
            System.out.println(square);

        }
    }
}
