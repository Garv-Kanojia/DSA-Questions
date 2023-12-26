public class remove_duplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1 || nums.length == 2){
            return nums.length;
        }
        int count=1;
        int lp=0;
        int rp=nums.length-1;

        while(lp != rp){
            if(nums[lp] == nums[lp+1]){
                count++;
                if(count == 3){
                    count=2;
                    for(int i=lp+1 ; i<rp ; i++){
                        nums[i] = nums[i+1];
                    }
                    --rp;
                    --lp;
                }
            }
            else{
                count=1;
            }
            lp++;
        }
        return rp+1;
    }

}
