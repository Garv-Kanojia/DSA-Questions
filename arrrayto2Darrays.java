import java.util.ArrayList;
import java.util.List;

public class arrrayto2Darrays {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] num = new int[nums.length+1];
        List<List<Integer>> res = new ArrayList<>();

        for(int n : nums){
            ++num[n];

            if(num[n] > res.size()){
                res.add(new ArrayList<>());
            }

            res.get(num[n]-1).add(n);
        }

        return res;
    }
}
