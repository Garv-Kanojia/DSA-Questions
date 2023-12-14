


import java.util.*;


public class sum4{


    public static void main(String[] args) {
        int nums[] = {-1,0,1,-1,2,4};

        List<List<Integer>> list = Sumfour(nums , 0);

        System.out.println(list);
    }

    public static List<List<Integer>> Sumfour(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> main_list = new ArrayList<List<Integer>>();
        for(int j=0 ; j<nums.length-3 ; j++){
            if(j == 0 || (j > 0 && nums[j] != nums[j-1])){
                for(int i=j+1 ; i<nums.length-2 ; i++){
                    if(i == j+1 || (i > j+1 && nums[i] != nums[i-1])){
                        int lp = i+1;
                        int rp = nums.length-1;

                        while(lp < rp){
                            if((nums[lp] + nums[rp] + nums[i] +  nums[j])== target){
                                main_list.add(Arrays.asList(nums[j],nums[i],nums[lp],nums[rp]));
                                while(lp < rp && nums[lp] == nums[lp+1]){
                                    lp++;
                                }
                                while(lp < rp && nums[rp] == nums[rp-1]){
                                    rp--;
                                }
                                ++lp;
                                --rp;
                            }
                            else if((nums[lp] + nums[rp] + nums[i] +  nums[j]) < target){
                                ++lp;
                            }
                            else{
                                --rp;
                            }
                        }
                    }
                }
            }
        }
        return main_list;
    }
}
