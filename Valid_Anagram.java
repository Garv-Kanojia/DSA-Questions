public class Valid_Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] num = new int[26];
        for(char i : s.toCharArray()){
            num[i-'a']++;
        }

        for(char j : t.toCharArray()){
            if(--(num[j-'a']) < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("cat", "tac"));
        System.out.println(isAnagram("anagram", "tnagram"));
    }


}
