package huaweiC100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW78 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int appNums = in.nextInt();
            List<App> appList=new ArrayList<>();
            for (int i = 0; i < appNums; i++) {
                App app = new App();
                app.setApp(in.next());
                app.setPriority(in.nextInt());
                app.setStartTime(getTimeNumber(in.next()));
                app.setEndTime(getTimeNumber(in.next()));
                //很重要
                if(app.startTime>app.endTime){
                    continue;
                }
                appList.add(app);
            }
            List<App> appResult=new ArrayList<>();
            for (int i = 0; i < appList.size(); i++) {
                List<App> appHasOverLapList=new ArrayList<>();
                for (int j = 0; j < appResult.size(); j++) {
                    if(appResult.get(j).hasOverlap(appList.get(i))){
                        appHasOverLapList.add(appResult.get(j));
                    }
                }
                int maxPriority=-1;
                for (int j = 0; j < appHasOverLapList.size(); j++) {
                    maxPriority=Math.max(maxPriority,appHasOverLapList.get(j).getPriority());
                }
                if(maxPriority<appList.get(i).getPriority()){
                    for (int j = 0; j <  appHasOverLapList.size(); j++) {
                         appResult.remove(appHasOverLapList.get(j));
                    }
                    appResult.add(appList.get(i));
                }
            }
                int target = getTimeNumber(in.next());
            String answer="NA";
            for (int i = 0; i < appResult.size(); i++) {
                if(appResult.get(i).startTime<=target&&target<appResult.get(i).endTime){
                    answer=appResult.get(i).getApp();
                    break;
                }

            }
            System.out.println(answer);
        }
    }
        public static int getTimeNumber (String time){
            String[] split = time.split(":");
            return Integer.parseInt(split[0])*60+Integer.parseInt(split[1]);
        }
}

class App{

    String app;
    int priority;

    int startTime;
    int endTime;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean hasOverlap(App other){
        return startTime<= other.endTime&&other.startTime<=endTime;
    }


}
