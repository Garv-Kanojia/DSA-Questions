
import java.util.*;

class sum3 {

    public static void main(String[] args) {
        int nums[] = {-1,0,1,-1,2,4};

        List<List<Integer>> list = Sumthree(nums);

        System.out.println(list);

    }

    public static List<List<Integer>> Sumthree(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> main_list = new ArrayList<>();
        
        for(int i=0 ; i<nums.length-2 ; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int left = i+1;
                int right = nums.length-1;
                while(left < right){
                    if(nums[left] + nums[right] + nums[i] == 0){
                        main_list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++; right--;
                    } else if((nums[left] + nums[right]) < (0-nums[i])){
                        left++;
                    } else{
                        right--;
                    }
                }
            }
        }
        return main_list;
    }
}
