package jikao;

import java.util.*;

public class HW23 {


    static LinkedList<ArrayList<Integer>> juzhentu;
    public  static int[][] fangxiang={{1,0},{-1,0},{0,-1},{0,1}};
    public static  Scanner yuanshishuru;
    public static void main(String[] args) {
        duquhanshu();
        chulishuru();
    }
    private static void chulishuru() {
        while (yuanshishuru.hasNextLine()){
            int[] shuzu = Arrays.stream(yuanshishuru.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> lujing = new ArrayList<>();
            for (int i = 0; i < shuzu.length; i++) {
                lujing.add(shuzu[i]);
            }
            juzhentu.add(lujing);

        }
        System.out.println(jieguo());
    }

    public static void duquhanshu(){
        yuanshishuru=new Scanner(System.in);
        juzhentu=new LinkedList<>();

    }
    public static int jieguo(){
        int zuidakuangnanjiazhi=0;
        for (int juzheni = 0; juzheni <juzhentu.size() ; juzheni++) {
            for (int juzhenj = 0; juzhenj <juzhentu.get(0).size() ; juzhenj++) {
                if(juzhentu.get(juzheni).get(juzhenj)>0){
                    zuidakuangnanjiazhi=Math.max(zuidakuangnanjiazhi,chazhao(juzheni,juzhenj));
                }

            }
        }
        return zuidakuangnanjiazhi;

    }
    public static int chazhao(int i,int j){
        int zonghe=juzhentu.get(i).get(j);
        juzhentu.get(i).set(j,0);
        ArrayDeque<int[]> duilie=new ArrayDeque<>();
        duilie.add(new int[]{i,j});
        while (duilie.size()>0){
            int[] ints = duilie.pollFirst();
            int jiux=ints[0];
            int jiuy=ints[1];
            for (int k = 0; k <4 ; k++) {
                int xinX=jiux+fangxiang[k][0];
                int xinY=jiuy+fangxiang[k][1];
                if(xinX>=0&&xinX<juzhentu.size()&&xinY>=0&&xinY<juzhentu.get(0).size()&&juzhentu.get(xinX).get(xinY)>0){
                    zonghe+=juzhentu.get(xinX).get(xinY);
                    juzhentu.get(xinX).set(xinY,0);
                    duilie.add(new int[]{xinX,xinY});
                }
            }
        }
        return zonghe;
    }
}
