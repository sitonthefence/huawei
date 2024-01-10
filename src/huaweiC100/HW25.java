package huaweiC100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HW25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            in.nextLine();
            String sourceHeight = in.nextLine();
            String[] splitHeight = sourceHeight.split(" ");
            String sourceWeight = in.nextLine();
            String[] splitWeight = sourceWeight.split(" ");
            List<StudentHW25> list=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                 StudentHW25 stu=new StudentHW25();
                 stu.setId(i+1);
                 stu.setHeight(Integer.valueOf(splitHeight[i]));
                 stu.setWeight(Integer.valueOf(splitWeight[i]));
                 list.add(stu);
            }
            Collections.sort(list,(o1, o2) -> {
                if(o1.getHeight()== o2.getHeight()){
                    return o1.weight-o2.weight;
                }else {
                    return o1.getHeight()-o2.getHeight();
                }
            });
            for (StudentHW25 studentHW25 : list) {
                System.out.print(studentHW25.getId()+" ");
            }

        }


    }
}
class StudentHW25{
    int id;
    int height;
    int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
