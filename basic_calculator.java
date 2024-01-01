import java.util.Stack;

public class basic_calculator {

    public static void main(String[] args) {
        System.out.println(calculate("42+500"));
    }
    public static int calculate(String s) {
        Stack<Integer> opn = new Stack<>();
        Stack<Character> opr = new Stack<>();
        s = s.replaceAll("\\s" , "");

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(ch == '*' || ch == '/' || ch == '+' || ch == '-'){
                opr.push(ch);
            }
            else{
                int res=0;
                while(i != s.length() && Character.isDigit(s.charAt(i))){
                    res = (res * 10) + (s.charAt(i)-48);
                    i++;
                }
                --i;
                if(!opr.isEmpty()){

                    if(opr.peek() == '-'){
                        res = 0 - res;
                        opr.pop();
                        opr.push('+');
                    }
                    else if(opr.peek() == '*'){
                        int op = opn.pop();
                        opr.pop();
                        res = res * op;
                    }
                    else if(opr.peek() == '/'){
                        int op = opn.pop();
                        opr.pop();
                        res = op / res;
                    } 
                }
                opn.push(res);
            }
        }                                                                        

        while(opn.size() != 1){
            int op1 = opn.pop();
            int op2 = opn.pop();

            opn.push(op1+op2);
        }

        return opn.pop();
    }
    

}
