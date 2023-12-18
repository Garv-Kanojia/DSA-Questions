import java.util.*;

public class N_queens {
    public static void main(String[] args) {
        int n=5;
        char[][] board = new char[n][n];
        List<List<String>> list = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                board[i][j] = '.';
            }
        }
        queens(board , 0 , list);
        System.out.println(list);
        System.out.println("Number Of Solutions = " + count);

    }
    public static int count;

    public static void queens(char[][] board , int row , List<List<String>> mains){
        if(row == board.length){
            List<String> l = new ArrayList<>();
            for(int i=0 ; i<board.length ; i++){
                String str = new String(board[i]);
                l.add(str);
            }
            mains.add(new ArrayList<>(l));
            count++;
            return;
        }

        for(int j=0 ; j<board.length ; j++){
            if(isSafe(board , row,j)){
                board[row][j] = 'Q';
                queens(board , row+1 , mains);
                board[row][j] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board , int row , int col){
        for(int i=row-1 ; i>=0 ; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; --i,--j){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row-1 , j=col+1 ; i>=0 && j<board.length ;--i,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }
}