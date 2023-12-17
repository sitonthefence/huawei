package NK;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ63 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        int num = in.nextInt();
        Map<String,Integer>map=new LinkedHashMap<>();
        for(int i=0;i<source.length()-num+1;i++){
            String substring = source.substring(i, i + num);
            int total=0;
            for (int j=0;j<substring.length();j++){
                if(substring.charAt(j)=='G'||substring.charAt(j)=='C'){
                    total++;
                }
            }
            map.put(substring,total);
        }
        int max=Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            if(value>max){
                max=value;
            }
        }
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==max){
                System.out.println(entry.getKey());
                break;
            }

        }



    }
}
