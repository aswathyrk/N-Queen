public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result= new ArrayList<List<String>>();
        if(n==0)return result;
        
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        solve(board,result,0,n);
        return result;
    }
    
    
    public void solve(char[][] board,List<List<String>> result,int currRow,int n){
        
        if(currRow>=n){
            ArrayList<String> list = new ArrayList<String>();
            for(char[] c:board){
                list.add(new String(c));
            }
            result.add(list);
            return;
        }
        
        for(int j=0;j<n;j++){
            if(isValid(board,currRow,j,n)){
                board[currRow][j]='Q';
                solve(board,result,currRow+1,n);
                board[currRow][j]='.';
            }
        }
    }
    
    public boolean isValid(char[][] board,int row,int col,int n){
        for(int k=row-1;k>=0;k--){ //no row in the same col should have a queen
            if(board[k][col]=='Q')return false;
        }
        
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){ //no upper left diagonal should have a queen
            if(board[i][j]=='Q')return false;
        }
        
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++){ //no upper right diagonal should have a queen
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
}