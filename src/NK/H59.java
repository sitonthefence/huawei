package NK;

import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;

import java.util.*;

public class H59 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String source = in.next();
            LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
            for (int i = 0; i < source.length(); i++) {
                map.put(source.charAt(i),map.getOrDefault(source.charAt(i),0)+1);
            }
            String result="-1";
            for (Map.Entry<Character,Integer> entry:
            map.entrySet()) {
                if ( entry.getValue()==1){
                    Character key = entry.getKey();
                    result=""+key;
                    break;
                }
            }
            System.out.println(result);

        }






    }



}
