import java.util.*;

public class maximum_water {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(4);
        list.add(7);
        list.add(7);
        list.add(3);

        System.out.println("Maximum Water that can be stored = " + area(list));
    }

    public static int area(ArrayList<Integer> list){  //2 POINTER METHOD
        int left = 0;
        int right = list.size()-1;
        int max_area = Integer.MIN_VALUE;

        while(left < right){
            int height = Math.min(list.get(left) , list.get(right));
            int breadth = right - left;

            int cur_area = height * breadth;
            max_area = Math.max(cur_area , max_area);

            if(list.get(left) < list.get(right)){
                ++left;
            }
            else{
                --right;
            }
        }

        return max_area;
    }

    public static int area2(ArrayList<Integer> list){   //BRUTE FORCE
        int area = Integer.MIN_VALUE;
        for(int i=0 ; i<list.size(); i++){
            for(int j=i+1 ; j<list.size() ; j++){
                int left = list.get(i);
                int right = list.get(j);
                
                int height = Math.min(left , right);
                int breadth = j-i;

                int cur_area = height * breadth;
                area = Math.max(cur_area , area);
            }          
        }
        return area;
    }
}
