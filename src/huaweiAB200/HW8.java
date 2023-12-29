package huaweiAB200;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HW8 {
    static ArrayDeque<Integer> numStack=new ArrayDeque<>();
    static ArrayDeque<String> operatorStack=new ArrayDeque<>();
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String source = in.nextLine();
            int numIndex=0;
            for (int i = 0; i < source.length(); i++) {
                if(source.charAt(i)=='('){
                    String substring = source.substring(i + 1, i + 4);
                    operatorStack.offerLast(substring);
                    i=i+4;
                    numIndex=i+1;
                }else if(source.charAt(i)==' '){
                    if(numIndex<i){
                        String substring = source.substring(numIndex, i);
                       numStack.offerLast(Integer.valueOf(substring));
                       numIndex=i+1;
                    }
                }else if (source.charAt(i)==')'){
                    if(numIndex<i){
                        String substring = source.substring(numIndex, i);
                        numStack.offerLast(Integer.valueOf(substring));
                        numIndex=i+1;
                    }
                    Calculate();
                }
            }
            while (!operatorStack.isEmpty()){
                Calculate();
            }
            System.out.println(numStack.peekFirst());
        }
    }
    public static void  Calculate(){
        int num1=numStack.pollLast();
        int num2 = numStack.pollLast();
        String operatorString = operatorStack.pollLast();
        if(operatorString.equals("mul")){
            numStack.offerLast(num1*num2);
        }else if(operatorString.equals("add")){
            numStack.offerLast(num1+num2);
        }else if(operatorString.equals("sub")){
            numStack.offerLast(num2-num1);
        }else {
            if(num1==0){
                System.out.println("error");
                System.exit(0);
            }else {
                numStack.offerLast(num2/num1);
            }
        }
    }
}
