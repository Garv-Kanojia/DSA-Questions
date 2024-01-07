import java.util.*;

public class Trapping_rainwater {

public class trapping_rainwaterwithstack {
    public static void main(String[] args) {
        int height[] = {7,0,4,2,5,0,6,4,0,5};
        int[] left = new int[height.length];
        int[] right = new int[left.length];

        Stack<Integer> s = new Stack<>();

        left[0] = height[0];
        s.push(0);
        for(int i=1 ; i<height.length ; i++){
            while(!s.isEmpty() && height[i] > height[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                left[i] = height[i];
                s.push(i);
            } else{
                left[i] = height[s.peek()];
            }
        }
        s.clear();

        right[right.length-1] = height[height.length-1];
        s.push(left.length-1);
        for(int i=height.length-2 ; i>=0 ; i--){
            while(!s.isEmpty() && height[i] > height[s.peek()]){              
                s.pop();
            }
            if(s.isEmpty()){
                right[i] = height[i];
                s.push(i);
            } else{
                right[i] = height[s.peek()];
            }
        }
        
        int sum=0;
        for(int i=0 ; i<height.length ; i++){
            int water = Math.min(left[i],right[i]);

            sum += (water - height[i]);
        }

        System.out.println("Total water taht will be trapped = " + sum);
    }
}

}
