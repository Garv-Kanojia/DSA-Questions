import java.util.Arrays;
import java.util.Comparator;

public class ballon_arrows {
    public int findMinArrowShots(int[][] points) {
        int min = points.length+1;

        Arrays.sort(points,Comparator.comparingDouble(o -> o[0]));
        int lb=Integer.MIN_VALUE;
        int ub = Integer.MAX_VALUE;
        for(int i=0 ; i<points.length ; i++){
            lb = points[i][0];
            if(points[i][1] < ub){
                ub = points[i][1];
                
            }

            if(ub >= lb){
                min--;
            }
            else{
                lb = points[i][0];
                ub = points[i][1];
            }
        }

        return min;
    }
}
