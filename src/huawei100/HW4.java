package huawei100;

import java.util.*;

public class HW4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String str1 = in.nextLine();
            String[] split1 = str1.split(";");
            List<Student> students=new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                String[] idAndScore = split1[i].split(",");
                Student student = new Student();
                student.setClassId(idAndScore[0].substring(0,5));
                student.setStudentId(idAndScore[0]);
                student.setProjectA(Integer.valueOf(idAndScore[1]));
                students.add(student);

            }

            String str2 = in.nextLine();
            String[] split2 = str2.split(";");
            for (int i = 0; i < split2.length; i++) {
                String[] idAndScore = split2[i].split(",");
                String studentId = idAndScore[0];
                for (int j = 0; j < students.size(); j++) {
                    if (studentId.equals(students.get(j).studentId)) {
                        students.get(j).setProjectB(Integer.valueOf(idAndScore[1]));
                        break;
                    }

                }
            }

            List<Student> studentAllProjects=new ArrayList<>();
                for (Student student : students) {
                    if(student.getProjectB()!=-1){
                        studentAllProjects.add(student);
                    }
                }
                studentAllProjects.sort(((o1, o2) -> {
                    if(!o1.getClassId().equals(o2.getClassId())){
                        return Integer.valueOf(o1.getClassId())-Integer.valueOf(o2.getClassId());
                    }else {
                        if((o1.ProjectA+o1.ProjectB)!=(o2.ProjectA+o2.ProjectB)){
                            return  (o2.ProjectA+o2.ProjectB)- (o1.ProjectA+o1.ProjectB);
                        }else {
                            return Integer.valueOf(o1.studentId)- Integer.valueOf(o2.studentId);
                        }
                    }

                }
                ));

             Set<String> set=new LinkedHashSet<>();
            for (Student studentAllProject : studentAllProjects) {
                set.add(studentAllProject.getClassId());
            }
            List<String> list=new ArrayList<>(set);
            if(list.size()==0){
                System.out.println("NULL");
            }else {
                for (String s : list) {
                    System.out.println(s);
                    StringBuilder stringBuilder=new StringBuilder();
                    for (Student studentAllProject : studentAllProjects) {
                        if (studentAllProject.getClassId().equals(s)){
                            stringBuilder.append(studentAllProject.getStudentId()).append(";");

                        }
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    System.out.println(stringBuilder);

                }

            }



            }


        }
    static class Student{
        String classId;
        String studentId;
        int  ProjectA=-1;
        int ProjectB=-1;

        public String getClassId() {
            return classId;
        }

        public void setClassId(String classId) {
            this.classId = classId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public int getProjectA() {
            return ProjectA;
        }

        public void setProjectA(int projectA) {
            ProjectA = projectA;
        }

        public int getProjectB() {
            return ProjectB;
        }

        public void setProjectB(int projectB) {
            ProjectB = projectB;
        }
    }




}
