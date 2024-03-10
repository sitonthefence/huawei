package jikao;

import java.util.*;

public class HW22 {
    public static int[] baoxiang;
    public static int changdu;
    public  static HashMap<Integer,Integer> zuihouyigeBianHao;
    public  static  HashSet<Integer> faxian;

    public static void main(String[] args) {
          duquchuzhi();
         zuihouyigeBianHao=new LinkedHashMap<>();
          faxian=new HashSet<>();
          zhuyaoluoji();




    }
    public static void duquchuzhi(){
        Scanner duquqi = new Scanner(System.in);
        baoxiang= Arrays.stream(duquqi.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        changdu=Integer.valueOf(duquqi.nextLine());
    }
    public static void zhuyaoluoji(){
        int daan=-1;
        for (int i = 0; i <baoxiang.length ; i++) {
            int shuzi=baoxiang[i];
            if(!faxian.contains(shuzi)&&zuihouyigeBianHao.containsKey(shuzi)&&i-zuihouyigeBianHao.get(shuzi)<=changdu){
                faxian.add(shuzi);

                Integer jieguo1 = zuihouyigeBianHao.get(shuzi);
                int jieguo2 = Math.min(daan, zuihouyigeBianHao.get(shuzi));

                daan=daan==-1?jieguo1:jieguo2;
            }else {
                zuihouyigeBianHao.put(shuzi,i);
            }
        }
        System.out.println(daan);

    }
}
