package LC;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LC797 {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
         path.add(0);
         traversal(graph,0);
         return result;


    }
    public void traversal(int[][] graph,int index){
        if(index== graph.length-1) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i <graph[index].length ; i++) {
             path.add(graph[index][i]);
            traversal(graph, graph[index][i]);
            path.remove(path.size()-1);
        }

    }

}
