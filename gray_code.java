import java.util.*;

public class gray_code {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        result.add(0);
        set.add(0);
        solve(n, result, set);
        return result;
    }

    private void solve(int n, List<Integer> list, Set<Integer> set) {
        int current = list.get(list.size() - 1);
        for (int i = 0; i < n; i++) {
            int next = current ^ (1 << i);
            if (!set.contains(next)) {
                list.add(next);
                set.add(next);
                solve(n, list, set);
                if (list.size() == (int)Math.pow(2, n)) {
                    return;
                }
                list.remove(list.size() - 1);
                set.remove(next);
            }
        }
    }
}
