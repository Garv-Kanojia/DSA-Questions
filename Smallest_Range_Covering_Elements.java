import java.util.*;

public class Smallest_Range_Covering_Elements {
    public int[] smallestRange(List<List<Integer>> nums) {
        int len = 0;
        for(int i=0 ; i<nums.size() ; i++){
            len += nums.get(i).size();
        }
        Map<Integer,Integer> map = new HashMap<>();
        int no=1;
        int j=0;
        int[][] arr = new int[len][2];

        for(int i=0 ; i<nums.size() ; i++){
            for(int k=0 ; k<nums.get(i).size() ; k++){
                arr[j][0] = nums.get(i).get(k);
                arr[j][1] = no;
                j++;
            }
            no++;
        }
        --no;

        int lp=len-1 , rp=len-1;
        int[] ans = new int[2];
        ans[0] = -100000;
        ans[1] = 100000;

        Arrays.sort(arr,Comparator.comparingInt(o -> o[0]));

        while(lp >= 0 && lp <= rp){
            while(lp >= 0 && map.size() < no){
                map.put(arr[lp][1],map.getOrDefault(arr[lp][1],0)+1);
                --lp;
            }

            while(rp >= lp && map.size() == no){
                map.put(arr[rp][1],map.get(arr[rp][1])-1);
                if(map.get(arr[rp][1]) == 0){
                    map.remove(arr[rp][1]);
                }
                --rp;
            }

            if((ans[1] - ans[0]) >= (arr[rp+1][0] - arr[lp+1][0])){
                ans[0] = arr[lp+1][0];
                ans[1] = arr[rp+1][0];
            }
        }

        return ans;
    }
}
