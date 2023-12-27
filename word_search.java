public class word_search {
    public boolean exist(char[][] board, String word) {
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board[0].length ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrack(board,i,j,0,word)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board , int i ,int j , int idx , String word){
        //base case
        if(word.length() == idx){
            return true;
        }


        //recursion
        if(0 <= i && i < board.length && 0 <= j && j < board[0].length && word.charAt(idx) == board[i][j]){
            char temp = board[i][j];
            board[i][j] = '!';
            
            if(backtrack(board , i+1 , j , idx+1 , word)){
                return true;
            }
            if(backtrack(board , i , j+1 , idx+1 , word)){
                return true;
            }
            if(backtrack(board , i-1 , j , idx+1 , word)){
                return true;
            }
            if(backtrack(board , i , j-1 , idx+1 , word)){
                return true;
            }

            board[i][j] = temp;
        }

        return false;
    }
}
