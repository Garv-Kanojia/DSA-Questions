import java.util.*;


public class group_anagram {

    static List<List<String>> group(String[] nums){
        List<List<String>> main_list = new ArrayList<>();
        
        HashMap<String , List<String>> map = new HashMap<>();

        for(String str : nums){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String word = new String(ch);

            if(!map.containsKey(word)){
                map.put(word , new ArrayList<>());
            }

            map.get(word).add(str);
        }

        main_list.addAll(map.values());
        return main_list;

    } 

    public static void main(String[] args) {
        String [] nums = {"cat", "dog", "tac", "god", "act" , "eat"};
        System.out.println(group(nums));
    }
}