public class patching_array {
    public int minPatches(int[] nums, int n) {
        int count=0;
        long missing=0;

        for(int i=0 ; i<nums.length ; i++){
            while(missing < nums[i]-1 && missing < n){
                missing = (2*missing) + 1;
                count++;
            }
            missing = missing + nums[i];
        }

        while(missing < n){
            missing = (2*missing) + 1;
            count++;
        }

        return count;
    }
}
