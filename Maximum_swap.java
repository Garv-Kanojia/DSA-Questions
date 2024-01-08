public class Maximum_swap {
    static class Solution {
        public int maximumSwap(int num) {
            int[] arr = new int[10];
            StringBuilder s = new StringBuilder(Integer.toString(num));
            for(int i=0 ; i<s.length() ; i++){
                arr[s.charAt(i) - 48] = i;
            }
    
            int lp=0;
            while(lp < s.length()){
                int index=9;
                int left = s.charAt(lp) - 48;
    
                while(index > left){
                    if(arr[index] > lp){
                        s.setCharAt(lp, (char)(index + '0'));
                        s.setCharAt(arr[index], (char)(left + '0'));
                        return Integer.valueOf((s.toString()));
                    }
                    --index;
                }
                lp++;
            }
    
            return num;
        }
    }
}
