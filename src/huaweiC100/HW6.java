package huaweiC100;

import java.util.*;

public class HW6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            Integer target = Integer.valueOf(in.nextLine());
            String source = in.nextLine();
            List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u','A','E','I','O','U');
            List<Integer> aeiouList=new ArrayList<>();
            for (int i = 0; i < source.length(); i++) {
                if(list.contains(source.charAt(i))){
                    aeiouList.add(i);
                }
            }
            int left=0;
            int right=0;
            int currentFlaw=0;
            int maxLength=0;
            while (right<aeiouList.size()){
                currentFlaw=(aeiouList.get(right)-aeiouList.get(left))-(right-left);
                while (currentFlaw>target){
                    currentFlaw=(aeiouList.get(right)-aeiouList.get(left+1))-(right-left-1);
                   left++;
                }
                if(currentFlaw==target){
                    maxLength=Math.max(maxLength,aeiouList.get(right)-aeiouList.get(left)+1);
                }
                right++;
            }
            System.out.println(maxLength);
        }
    }
}
