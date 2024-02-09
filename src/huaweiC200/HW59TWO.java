package huaweiC200;

import java.util.Scanner;
import java.util.StringJoiner;

public class HW59TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringJoiner source=new StringJoiner("\n");
        while (in.hasNextLine()){
            source.add(in.nextLine());
        }
        String str = source.toString();
        int context_length=0;
        int total=0;
        boolean danyinhao=false;
        boolean shuangyinhao=false;
        int i=0;
        while (i<str.length()){
            char c = str.charAt(i);
            if(c=='\\'){
                i++;

            }else if(c=='\"') {
                if (!danyinhao) {
                    shuangyinhao = !shuangyinhao;
                }
            }
            else if(c=='\''){
                    if(!shuangyinhao){
                        danyinhao=!danyinhao;
                    }
                }else if(c=='-'){
                    if(!shuangyinhao&&!danyinhao){
                        if(++i<str.length()&&str.charAt(i)=='-'){
                            while (++i<str.length()&&str.charAt(i)!='\n'){

                            }
                        }


                    }
                }else if(c==';'){
                    if(!shuangyinhao&&!danyinhao&&context_length>0){
                        total++;
                        context_length=0;
                    }
                }else {
                    if(!Character.isWhitespace(c)){
                        context_length++;
                    }

                }
            i++;
            }
        if(context_length>0){
            total++;
        }
        System.out.println(total);



    }



    }




