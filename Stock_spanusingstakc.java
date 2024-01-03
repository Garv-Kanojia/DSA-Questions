import java.util.*;

public class Stock_spanusingstakc {

    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int [stocks. length];
        span[0] = 1;
        
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i=1 ; i<stocks.length  ;i++){
            while(!s.isEmpty() && stocks[i] >= stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            } else{
                span[i] = i - s.peek();
            }
            s.push(i);
        }

        for(int n : span){
            System.out.print(n + " ");
        }
    }
}

