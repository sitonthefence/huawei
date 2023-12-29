package huaweiAB100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int length = in.nextInt();
            List<Student> list=new ArrayList<>();
            List<Integer> height=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                height.add(in.nextInt());
            }
            List<Integer> weight=new ArrayList<>();
            for (int i = 0; i < length; i++) {
                weight.add(in.nextInt());
            }
            for (int i = 0; i <length; i++) {
                Student student = new Student();
                student.setId(i);
                student.setHeight(height.get(i));
                student.setWeight(weight.get(i));
            list.add(student);
            }
            list.sort(((o1, o2) -> {
                if(o1.height==o2.height){
                    return o1.weight-o2.weight;
                }else {
                    return o1.height-o2.height;
                }
            }));
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if(i==list.get(j).getId()){
                        System.out.print(j+1+" ");
                    }
                }
            }
        }


    }
}
class Student{
    int id=-1;

    int height=0;
    int weight=0;

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
