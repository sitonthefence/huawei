package huaweiC200;


import java.util.*;

public class HW42TWO {
   static Map<String,Node> keyMap=new TreeMap<>();
   static Map<Integer,LinkedList<Node>> freqMap=new HashMap<>();
   static int currentCapacity;
   static int m;
   static int minFreq;
    static class Node{
        String file_name;
        int fileSize;
        int freq=1;
        public Node(String file_name, int fileSize) {
            this.file_name = file_name;
            this.fileSize = fileSize;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         m = in.nextInt();
        currentCapacity=m;
        int total = in.nextInt();
        in.nextLine();
        for (int i = 0; i < total; i++) {
            String source = in.nextLine();
            String[] split = source.split(" ");
            if(split[0].equals("put")){
                put(split[1],Integer.valueOf(split[2]));
            }else {
                get(split[1]);
            }
        }
        if(m==currentCapacity){
            System.out.println("NONE");
        }else {
               StringJoiner stringJoiner=new StringJoiner(",");
            for (String str : keyMap.keySet()) {
                stringJoiner.add(str);
            }
            System.out.println(stringJoiner);
        }
    }
    public static void  get(String file_name){
       if(!keyMap.containsKey(file_name)){
           return;
       }
        Node node = keyMap.get(file_name);
        freqMap.get(node.freq).remove(node);
        if( freqMap.get(node.freq).isEmpty()){
            freqMap.remove(node.freq);
            if(node.freq==minFreq){
                minFreq++;
            }
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq,new LinkedList<>());
        freqMap.get(node.freq).add(node);


    }

    public static void put (String file_name,int fileSize){
        if(keyMap.containsKey(file_name)){
            return;
        }
        if(fileSize>m){
            return;
        }
        while (currentCapacity<fileSize){
            Node node = freqMap.get(minFreq).pollFirst();
            keyMap.remove(node.file_name);
            currentCapacity+= node.fileSize;
            if( freqMap.get(minFreq).size()==0){
                freqMap.remove(minFreq);
                if (freqMap.size()==0){
                    minFreq=0;
                }else {
                    int min=Integer.MAX_VALUE;
                    for (Integer integer : freqMap.keySet()) {
                        min=Math.min(integer,min);
                    }
                    minFreq=min;
                }
            }

        }
        Node node = new Node(file_name, fileSize);
        keyMap.put(file_name,node);
        currentCapacity-=fileSize;
        freqMap.putIfAbsent(1,new LinkedList<>());
        freqMap.get(1).add(node);
        minFreq=1;





    }

}
