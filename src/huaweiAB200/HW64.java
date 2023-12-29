package huaweiAB200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW64 {
    static List<Student> studentList;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int studentNums = in.nextInt();
        int troubleMakeNums = in.nextInt();
        int dissatisfaction=in.nextInt();
        List<Integer> troublePersonList=new ArrayList<>();
        for (int i = 0; i < troubleMakeNums; i++) {
            troublePersonList.add(in.nextInt());
        }
         studentList=new ArrayList<>();
        for (int i = 0; i < studentNums; i++) {
            Student student=new Student();
            student.setId(i);
            student.setBody(in.nextInt());
            studentList.add(student);
        }
        for (int i = 0; i < troubleMakeNums; i++) {
            studentList.get(troublePersonList.get(i)).setTroubleMake(true);
        }

        int totalDissatisfaction=0;
        for (int i = 0; i <  studentList.size(); i++) {
               if(!studentList.get(i).isTroubleMake){
                   totalDissatisfaction=totalDissatisfaction+getCount(i);
               }

        }
        if(totalDissatisfaction>dissatisfaction){
            System.out.println(1);
        }else {
            System.out.println(0);
        }






    }
    public static int getCount(int index){
        int count =0;
        for (int i = 0; i < index; i++) {
            if(studentList.get(index).body<studentList.get(i).body){
                count++;
            }
        }
        return count;


    }

}
class Student{
    int id;
    int body;
    boolean isTroubleMake;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public boolean isTroubleMake() {
        return isTroubleMake;
    }

    public void setTroubleMake(boolean troubleMake) {
        isTroubleMake = troubleMake;
    }

}
