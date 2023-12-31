import java.util.*;

public class partition_labels {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0 ; i<s.length() ; i++){
            map.put(s.charAt(i),i);
        }
        int start=0;
        while(start != s.length()){
            int end = map.get(s.charAt(start));
            for(int j=start ; j<end ; j++){
                char ch = s.charAt(j);
                if(map.get(ch) > end){
                    end = map.get(ch);
                }
                if(end == s.length()-1){
                    list.add(end-start+1);
                    return list;
                }
            }
            list.add(end-start+1);
            start = end+1;
        }

        return list;

    }
}
