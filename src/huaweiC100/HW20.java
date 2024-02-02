package huaweiC100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        NodeHW20 root=new NodeHW20("/",null);
        NodeHW20 currentNode=root;
        String result="";
        while (in.hasNextLine()){
            String source = in.nextLine();
            String[] split = source.split(" ");
            if(split[0].equals("mkdir")){
                if(split.length==2&&check1(split[1])&&!currentNode.subdirectories.containsKey(split[1])){
                    currentNode.subdirectories.put(split[1],new NodeHW20(currentNode.path+split[1]+"/",currentNode));
                }
            }else if(split[0].equals("cd")){

                if(split.length==2&&check2(split[1])&&currentNode.subdirectories.containsKey(split[1])){
                    currentNode=currentNode.subdirectories.get(split[1]);
                }
                if(split.length==2&&split[1].equals("..")&&currentNode.parent!=null){
                    currentNode=currentNode.parent;
                }
            }else if(split[0].equals("pwd")){
                if(split.length==1){
                    result=currentNode.path;
                }
            }
        }
        System.out.println(result);
    }
    public static boolean check1(String str){
        if(str.matches("[a-z]+")){
            return true;
        }
        return false;
    }
    public static boolean check2(String str){
        if(str.equals("..")||str.matches("[a-z]+")){
            return true;
        }
        return false;

    }
}
class NodeHW20{
    String path;
    NodeHW20 parent;
    Map<String,NodeHW20> subdirectories;
    public NodeHW20() {
    }
    public NodeHW20(String path, NodeHW20 parent) {
        this.path = path;
        this.parent = parent;
        subdirectories=new HashMap<>();
    }


}
