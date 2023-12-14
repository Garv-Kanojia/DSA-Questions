
import java.util.*;

public class pair_sum_rotated {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(8);

        sum(list,7);

        
    }

    public static void sum(ArrayList<Integer> list , int target){
        int lp=0,rp=0;
        for(int i=0 ;i<list.size()-1 ; i++){
            if(list.get(i) > list.get(i+1)){
                lp = i+1;
                rp = i;
            }
        }

        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target){
                System.out.print("In the given list " + list.get(lp) + " + " + list.get(rp) + " = " + target);
                return;
            }

            if(list.get(lp) + list.get(rp) < target){
                lp = (lp + 1) % list.size();
            }
            else{
                rp = (rp + list.size() - 1) % list.size();
            }

        }
        System.out.println("No such Element found");
        
        
    }
}
