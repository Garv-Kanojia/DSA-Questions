
public class incremovable {
    public long incremovableSubarrayCount(int[] nums){
        int lp = 0, rp = nums.length-1;
        
        while(lp+1 < nums.length && nums[lp] < nums[lp+1]){
            lp++;
        }
        if(lp+1 == nums.length){
            return nums.length*(nums.length+1)/2;
        }
        
        while(rp-1 > 0 && nums[rp] > nums[rp-1]){
            rp--;
        }
        
        long count = 0;
        for(int i = 0; i <= lp; i++){
            int curr = binary_search(nums, rp, nums.length-1, nums[i]);
            count = count + nums.length - curr + 1;
        }
        count = count + nums.length - rp + 1;
        return count;
    }
        
    public int binary_search(int[] nums, int left, int right, long x){
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] <= x){
                left = mid+1;
            }else{
                ans = mid;
                right = mid-1;
            }
        }
        if(ans == -1) return nums.length;
        return ans;
    }
    
}