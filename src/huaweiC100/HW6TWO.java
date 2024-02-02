package huaweiC100;

import java.util.*;

public class HW6TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            Integer target = Integer.valueOf(in.nextLine());
            String source = in.nextLine();
            List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
            List<Integer> aeiouList =new ArrayList<>();
            for (int i = 0; i < source.length(); i++) {
                if(list.contains(source.charAt(i))){
                    aeiouList.add(i);
                }

            }
            int left=0;
            int right=0;
            int currentFault=0;
            int maxLength=0;
            while (right<aeiouList.size()){
                currentFault=aeiouList.get(right)-aeiouList.get(left)-(right-left);
                while (currentFault>target){
                    currentFault=aeiouList.get(right)-aeiouList.get(left+1)-(right-left)+1;
                    left++;
                }
                if(currentFault==target){
//还原原数组
                    maxLength=Math.max(aeiouList.get(right)-aeiouList.get(left)+1,maxLength);
                }
                right++;

            }
            System.out.println(maxLength);




        }
    }
}
