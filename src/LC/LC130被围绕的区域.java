package LC;

public class LC130被围绕的区域 {

    static int m;
    static int n;
    static boolean[][] used;

    public static void main(String[] args) {
        char[][] temp={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        m=temp.length;
        n=temp[0].length;
        used=new boolean[m][n];
        solve(temp);
    }
    public static void solve(char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!used[i][j]&&(i==0||j==0||i==m-1||j==n-1)&&board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!used[i][j]&&board[i][j]=='O'){
                    board[i][j]='X';
                }

            }
        }




    }
    public  static void dfs(char[][] board,int i,int j) {
       if(i<0||j<0||i>=m||j>=n||board[i][j]=='X'||used[i][j]){
           return;
       }

        used[i][j]=true;
        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
