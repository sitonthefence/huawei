package huaweiC200;

import java.util.Arrays;
import java.util.Scanner;

public class HW13TWO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.next();
        int target = in.nextInt();

        String[] split = source.substring(1, source.length() - 1).split(",");
       IndexAndValue[] num=new IndexAndValue[split.length];
        for (int i = 0; i <num.length ; i++) {
            IndexAndValue temp=new IndexAndValue(i,Integer.valueOf(split[i]));
            num[i]=temp;
        }
        Arrays.sort(num,(o1,o2)-> o1.value- o2.value);
        IndexAndValue[] result=new IndexAndValue[3];
        //不能定义在里面
        int minIndexSum=Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
             if(num[i].value>target&&num[i].value>0&&target>0) break;
             if(i>0&&num[i].value==num[i-1].value) continue;
            int l=i+1;
            int r= num.length-1;


            while (l<r){
                int mid=(target-num[i].value)/2;
                if(num[l].value>mid||num[r].value<mid) break;
                int addSum=num[i].value+num[l].value+num[r].value;
                if(addSum<target){
                    l++;
                }else if(addSum>target){
                    r--;
                }else {
                    while (l<r-1&&num[r].value==num[r-1].value){
                        r--;
                    }
                    //关键
                    int currentIndexSum=num[i].index+num[l].index+num[r].index;
                    if(currentIndexSum<minIndexSum){
                        minIndexSum=currentIndexSum;
                        result[0]=num[i];
                        result[1]=num[l];
                        result[2]=num[r];
                    }
                    while (l+1<r&&num[l].value==num[l+1].value){
                        l++;
                    }
                    l++;
                    r--;
                }


            }
        }
        Arrays.sort(result,(o1, o2) -> o1.index- o2.index);
        System.out.println("["+result[0].value+","+result[1].value+","+result[2].value+"]");
    }
    static class IndexAndValue{

        int index;
        int value;

        public IndexAndValue(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
