public class sudoku_solver {

    public void solveSudoku(char[][] board) {
        solver(board,0,0);
    }

    private static boolean solver(char[][] num , int row , int col){
        //base case
        if(row == 9){
            return true;
        }

        //recursion
        int nextRow=row , nextCol=col+1;
        if(nextCol == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if(num[row][col] != '.'){
            return solver(num,nextRow,nextCol);
        }

        for(int dig=49 ; dig<58 ; dig++){
            if(isSafe(num , row , col , dig)){
                num[row][col] = (char)dig;
                if(solver(num,nextRow,nextCol)){
                    return true;
                }
                num[row][col] = '.'; 
            }
        }
        return false;
    }

    private static boolean isSafe(char[][] num , int row, int col , int digit){
        for(int j=0 ; j<9 ;j++){
            if(num[row][j] == digit){
                return false;
            }
        }

        for(int i=0 ; i<9 ; i++){
            if(num[i][col] == digit){
                return false;
            }
        }

        int r = (row/3)*3;
        int c = (col/3)*3;

        for(int i=r ; i<r+3 ; i++){
            for(int j=c ; j<c+3 ; j++){
                if(num[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }

}
