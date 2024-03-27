public class subset_product {
    public static int numSubarrayProductLessThanK(int[] nums, int j) {
        int count = 0;

        for(int i=0 ; i<nums.length-1 ; i++){
            int prod = nums[i];
            for(int k=i+1 ; k<nums.length ; k++){
                prod *= nums[k];
                if(prod >= j){
                    break;
                }
                count++;
            }
        }

        for(int i : nums){
            if(i <= j){
                count++;
            }
        }

        

        return count;
    }

    public static void main(String[] args) {
        int[] num = {10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(num, 100));
    }
}
