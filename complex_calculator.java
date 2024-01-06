import java.util.Stack;

public class complex_calculator {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.calculate("(1+(5+6-7)+4)"));
    }
    static class Solution {
        public int calculate(String s) {
            s = s.replaceAll("\\s","");
            Stack<String> s1 = new Stack<>();

            for(int i=0 ; i<s.length() ; i++){
                char ch = s.charAt(i);

                if(ch >= '0' && ch <= '9'){
                    int res=0;
                    String str = "";
                    int j=i;
                    while(j != s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'){
                        res = (res*10) + (s.charAt(j) - 48);
                        j++;
                    }
                    if(i != 0 && s.charAt(i-1) == '-'){
                        res = 0 - res;
                    }
                    str += res;
                    s1.push(str);
                    i = j-1;
                }

                else if(ch == '('){
                    if(i != 0 && s.charAt(i-1) == '-'){
                        s1.push("-");
                    }
                    s1.push("(");
                }

                else if(ch == ')'){
                    String ans = s1.pop();
                    while(s1.peek() != "("){
                        int val = Integer.valueOf(ans) + Integer.valueOf(s1.peek());
                        s1.pop();
                        ans = "";
                        ans += val;
                    }
                    s1.pop();
                    if(!s1.isEmpty() && s1.peek() == "-"){
                        int val = Integer.valueOf(ans);
                        val = 0-val;
                        s1.pop();
                        ans = "";
                        ans += val;
                    }
                    s1.push(ans);
                }
            }

            while(s1.size() != 1){
                String ans = s1.pop();
                int val = Integer.valueOf(ans) + Integer.valueOf(s1.peek());
                ans = "";
                ans += val;
                s1.pop();
                s1.push(ans);
            }

            int val = Integer.valueOf(s1.pop());
            return val;
        }
    }
}
