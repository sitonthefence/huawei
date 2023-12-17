package NK;

public class NC68 {

    public static void main(String[] args) {
        System.out.println(jumpFloor(7));
    }

    public static int jumpFloor (int number) {
        // write code here

        if(number==1){
            return 1;
        }else if (number==2){
            return 2;
        }else {
            return jumpFloor(number-1)+jumpFloor(number-2);
        }

    }

}
