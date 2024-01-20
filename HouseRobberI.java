/**
 * HouseRobberI
 */
public class HouseRobberI {
    public static void main(String[] args) {
        int[] arr = {2,7,9,3,1};
        System.out.println(Solution.rob(arr));
    }
    static class Solution {
        public static int rob(int[] nums) {
            if(nums.length == 2){
                return (nums[0] > nums[1]) ? nums[0] : nums[1];
            } else if(nums.length == 1){
                return nums[0];
            }
    
            int amount = (nums[0] > nums[1]) ? nums[0] : nums[1];
            
            for(int i=2 ; i<nums.length ; i++){
                if(i == 2){
                    nums[i] = nums[i] + nums[0];
                }else{
                    nums[i] = (Math.max(nums[i-2],nums[i-3]) + nums[i]);
                }
    
                if(amount < nums[i]){
                    amount = nums[i];
                }
            }
    
            return amount;
        }
    }
}