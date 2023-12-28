import java.util.*;

public class combinationSum3 {
    public static List<List<Integer>> combosum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result,new ArrayList<>(), k, 1, n);
        return result;
    }

    private static void combination(List<List<Integer>> result, List<Integer> comb, int k, int start, int n) {
        //base caes
        if (comb.size() == k) {
            if(n == 0){
                result.add(new ArrayList<>(comb));
            }
            return;
        }
        //recursion
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(result, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
