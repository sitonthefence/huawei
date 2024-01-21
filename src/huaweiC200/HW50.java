package huaweiC200;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class HW50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String citySource = in.next();
            List<Range> ranges=new ArrayList<>();
            String[] split = citySource.split(";");
            for (String s : split) {
                String[] range = s.split("[=,]");
                ranges.add(new Range(range[0],range[1],range[2]));
            }
            String targetSource = in.next();
            String[] target = targetSource.split(",");
            StringJoiner joiner=new StringJoiner(",");
            for (String s : target) {
                long targetCityIpDecimal = ipToDecimal(s);
                String city="";
                long minLength=Long.MAX_VALUE;
                for (Range range : ranges) {
                    if (targetCityIpDecimal>=range.ipStartDecimal&&targetCityIpDecimal<=range.ipEndDecimal
                    &&minLength>range.length){
                        city=range.city;
                        minLength=range.length;
                    }
                }
                joiner.add(city);
            }
            System.out.println(joiner);
        }
    }
    public static long ipToDecimal(String ip){
        long result=0;
        String[] split = ip.split("\\.");
        for (String block : split) {
            result=(result<<8)|Integer.valueOf(block);
        }
        return result;
    }
    static class Range{
        String city;
        long ipStartDecimal;
        long ipEndDecimal;
        long length;

        public Range(String city, String ipStart, String ipEnd) {
            this.city = city;
            ipStartDecimal = ipToDecimal(ipStart);
            ipEndDecimal = ipToDecimal(ipEnd);
            length=ipEndDecimal-ipStartDecimal+1;
        }
    }
}
