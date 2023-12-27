
public class rat_maze {

    public static boolean solve(int[][] maze , int sol[][] , int x , int y){
        //base case
        if(x == maze.length-1 && y == maze.length-1 && maze[x][y] == 1){
            sol[x][y] = 1;
            return true;
        }

        //recursion
        if(isSafe(maze , x , y)){
            sol[x][y] = 1;

            if(solve(maze,sol,x+1,y)){
                return true;
            }
            if(solve(maze,sol,x,y+1)){
                return true;
            }
            sol[x][y] =0;
            return false;
        }


        return false;
    }

    public static boolean isSafe(int maze[][] , int x , int y){

        return (x>=0 && x<=maze.length-1 && y>=0 && y<=maze.length-1 && maze[x][y] == 1);
        
    }

    public static void main(String[] args) {
        int maze[][] = { {1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,1} };
        int sol[][] = { {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0},
                        {0,0,0,0} };

        solve(maze, sol, 0, 0);
        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<4 ; j++){
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }

    }
    
}