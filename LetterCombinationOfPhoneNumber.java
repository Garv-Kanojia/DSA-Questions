public class LetterCombinationOfPhoneNumber {
    final static char[][] L = {{},{},{'a','b','c'},
    {'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
    {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}}; //234

    public static void solve(char[][] phone , int idx , String ans , String word){
        //base case
        if(ans.length() == word.length()){
            System.out.print(ans + " ");
            return;
        }


        //recursion
        for(int i=0 ; i < phone[word.charAt(idx)-48].length ; i++){
            char ch = phone[word.charAt(idx)-48][i];
            solve(phone, idx+1, ans+ch, word);
        }
    }

    public static void main(String[] args) {
        solve(L , 0 , "" , "234");
    }
}
