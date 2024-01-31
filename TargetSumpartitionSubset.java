public class TargetSumpartitionSubset {
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum=0;
    
            for(int i : nums){
                sum += i;
            }
    
            if(sum%2 != 0){
                return false;
            }
    
            int target = sum/2;
            boolean[][] dp = new boolean[nums.length+1][target+1];
            for(int i=0 ; i<nums.length+1 ; i++){
                dp[i][0] = true;
            }
    
            for(int i=1 ; i<=nums.length ; i++){
                for(int j=1 ; j<=target ; j++){
                    if(nums[i-1] == j){
                        dp[i][j] = true;
                    } else if(nums[i-1] > j){
                        dp[i][j] = dp[i-1][j];
                    } else{
                        if(dp[i-1][j] || dp[i-1][j-(nums[i-1])]){
                            dp[i][j] = true;
                        }
                    }
                }
            }
    
            return dp[nums.length][target];
        }
    }
}
