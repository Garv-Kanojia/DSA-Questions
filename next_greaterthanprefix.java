import java.util.Arrays;

public class next_greaterthanprefix {

    class Solution {
        public int missingInteger(int[] nums) {
            int sum=nums[0];
            for(int i=1 ; i<nums.length ;i++){
                if(nums[i] - nums[i-1] != 1){
                    break;
                }
                sum += i + nums[0];
            }
            Arrays.sort(nums);  
            
            if(nums[nums.length-1] < sum){
                return sum;
            } else if(nums[nums.length-1] == sum){
                return sum+1;
            }
            
            for(int i=0 ; i<nums.length ; i++){
                if(nums[i] == sum){
                    while(i != nums.length-1){
                        if(nums[i+1] != nums[i] && nums[i+1] != nums[i] + 1){
                            return nums[i]+1;
                        }
                        i++;
                    }
                    break;
                }
                else if(nums[i] > sum){
                    return sum;
                }
                
            }
            return nums[nums.length-1]+1;
        }
    }
}
