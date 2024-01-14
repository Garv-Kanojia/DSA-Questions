public class UniquePathsBT {
    class Solution {
        int res=0;
        public int uniquePathsIII(int[][] grid) {
            int count=0;
            int si=0;
            int sj=0;
            for(int i=0 ; i<grid.length ; i++){
                for(int j=0 ; j<grid[0].length ;j++){
                    if(grid[i][j] == -1){
                        count++;
                    }
                    if(grid[i][j] == 1){
                        si = i;
                        sj = j;
                        grid[i][j] = 0;
                    }
                }
            }
            backtrack(grid,si,sj,((grid.length * grid[0].length)-count),1);
            return res;
        }
    
        public void backtrack(int[][] grid,int m,int n, int count,int curr){
            if(m == grid.length || m == -1 || n == grid[0].length || n == -1){
                return;
            }
            if(grid[m][n] == 1 || grid[m][n] == -1){
                return;
            }
            if(grid[m][n] == 2 && count == curr){
                res++;
                return;
            } else if(grid[m][n] == 2){
                return;
            }
    
            grid[m][n] = -1;
    
            backtrack(grid,m+1,n,count,curr+1);        
            backtrack(grid,m,n+1,count,curr+1);
            backtrack(grid,m-1,n,count,curr+1);
            backtrack(grid,m,n-1,count,curr+1);  
    
            grid[m][n] = 0;      
        }
    }
    
}
