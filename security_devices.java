
public class security_devices {

    static class Solution {
        public int numberOfBeams(String[] bank) {
            int beams=0;
            int hold=0;
            for(int i=0 ; i<bank.length ; i++){
                String str = bank[i];
                int count=0;
                for(int j=0 ; j<str.length() ; j++){
                    if(str.charAt(j) == '1'){
                        beams += hold;
                        count++;
                    }
                }
                hold = (count == 0) ? hold : count;
            }
            return beams;
        }
    }
}