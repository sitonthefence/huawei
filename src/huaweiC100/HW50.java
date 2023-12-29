package huaweiC100;

import java.util.*;

public class HW50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int studentNumber = in.nextInt();
            int classNumber = in.nextInt();
       String[] classes =new String[classNumber];
            for (int i = 0; i < classNumber; i++) {
                classes[i]=in.next();
            }
            List<Student> studentList=new ArrayList<>();
            for (int i = 0; i < studentNumber; i++) {
                int sum=0;
                Student student = new Student();
                student.setName(in.next());
                List<Integer> scores=new ArrayList<>();
                for (int j = 0; j < classNumber; j++) {
                    int score = in.nextInt();
                    scores.add(score);
                    sum=sum+score;
                }
                student.setScores(scores);
                student.setSum(sum);
                studentList.add(student);
            }
        String target=in.next();
            int index=-1;
            for (int i = 0; i <classNumber ; i++) {
                if(classes[i].equals(target)){
                    index=i;
                }
            }
           int finalIndex=index;
            if(index==-1){
                Collections.sort(studentList,(o1,o2)->{
                    if(o1.getSum()== o2.getSum()){
                        return o1.getName().compareTo(o2.getName());
                    }
                    else {
                       return o2.getSum()-o1.getSum();
                    }
                });

            }else {
                Collections.sort(studentList,(o1,o2)->{
                    if(o1.getScores().get(finalIndex).equals(o2.getScores().get(finalIndex))){
                        return o1.getName().compareTo(o2.getName());
                    }
                    else {
                        return (o2.getScores().get(finalIndex).intValue())-o1.getScores().get(finalIndex).intValue();
                    }
                });
            }
            for (Student student : studentList) {
                System.out.print(student.getName()+" ");
            }

        }


    }

}
class Student{
    String name;
    List<Integer> scores;
    int sum;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
