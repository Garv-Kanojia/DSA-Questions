import java.util.*;

public class sub_sets {
    

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        List<List<Integer>> list = new ArrayList<>();

        power_set(nums , list , new ArrayList<>() , 0);
        System.out.println(list);
        
    }

    private static void power_set(int[] num , List<List<Integer>> ans , List<Integer> list , int i){
        if(i == num.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(num[i]);
        power_set(num , ans , list , i+1);
        list.remove(list.size()-1);

        power_set(num , ans , list , i+1);

    }
}