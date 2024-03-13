package LC;

import java.util.concurrent.BrokenBarrierException;

public class LC79单词搜索 {

    public  boolean exist(char[][] board, String word) {
        boolean[][] used=new boolean[board.length][board[0].length];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                    if(dfs(board,word,0, i,j,used)){
                        return true;
                    }
            }
        }
        return false;
    }
    public  boolean dfs(char[][] board,String word,int level,int i,int j,boolean[][] used){
         if(level==word.length()){
             return true;
         }
         if(i<0||i>=board.length||j<0||j>=board[0].length||used[i][j]||word.charAt(level)!=board[i][j]){
             return false;
         }
         used[i][j]=true;
           boolean result= dfs(board,word,level+1,i+1,j,used)
                          ||dfs(board,word,level+1,i-1,j,used)
                 ||dfs(board,word,level+1,i,j+1,used)
                 ||dfs(board,word,level+1,i,j-1,used);
            used[i][j]=false;
           return result;
    }
}
