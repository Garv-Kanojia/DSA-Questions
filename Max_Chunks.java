import java.util.*;

public class Max_Chunks {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{5,4,3,2,1}));
    }
    public static int maxChunksToSorted(int[] arr) {
        int[] arr1 = arr.clone();
        Arrays.sort(arr);

        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map1 = new HashMap<>();

        int res=0;
        int rp=0;

        while(rp < arr.length){
            map.put(arr[rp],map.getOrDefault(arr[rp],0)+1);
            map1.put(arr1[rp],map1.getOrDefault(arr1[rp],0)+1);

            if(map.equals(map1)){
                res++;
                map.clear();
                map1.clear();
            }
            rp++;
        }

        return res;
    }
}
