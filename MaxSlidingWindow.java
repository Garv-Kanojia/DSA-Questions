import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dq = new LinkedList<>();
            int[] res = new int[nums.length-k+1];

            for(int i=0 ; i<k  ;i++){
                while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                    dq.removeLast();
                }
                dq.addLast(i);
            }
            res[0] = nums[dq.peekFirst()];
            int j=1;

            for(int i=k ; i<nums.length ; i++){
                if(!dq.isEmpty() && dq.peek() == i-k){
                    dq.removeFirst();
                }
                while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                    dq.removeLast();
                }
                dq.addLast(i);
                res[j] = nums[dq.peekFirst()];
                j++;
            }

            return res;
        }
    }
}
