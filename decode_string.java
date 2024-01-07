import java.util.Stack;

public class decode_string {
    static class Solution {
        public String decodeString(String s) {
            Stack<Integer> counts = new Stack<>();
            Stack<StringBuilder> result = new Stack<>();
            result.push(new StringBuilder());
            int res=0;

            for(char ch : s.toCharArray()){
                if(Character.isDigit(ch)){
                    res = (res*10) + (ch-48);
                }
                else if(ch == '['){
                    counts.push(res);
                    result.push(new StringBuilder());
                    res=0;
                }
                else if(ch == ']'){
                    int op1 = counts.pop();
                    StringBuilder temp = result.pop();
                    for(int i=0 ; i<op1 ; i++){
                        result.peek().append(temp);
                    }
                }
                else{
                    result.peek().append(ch);
                }
            }

            return result.pop().toString();
        }
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.decodeString("3[a]2[bc]"));
    }
}
