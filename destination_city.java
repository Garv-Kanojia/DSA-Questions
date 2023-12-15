import java.util.*;

public class destination_city {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();
        l1.add("London");
        l1.add("New York");
        List<String> l2 = new ArrayList<>();
        l2.add("Tokyo");
        l2.add("London");
        List<String> l3 = new ArrayList<>();
        l3.add("New York");
        l3.add("Sydney");

        List<List<String>> list = Arrays.asList(l1,l2,l3);
        System.out.println(destCity(list));
    }
    
    public static String destCity(List<List<String>> paths) {
        HashMap<String,String> map = new HashMap<>();
        for(List<String> city : paths){
            map.put(city.get(0),city.get(1));
        }
        String end="";
        Set<String> keys = map.keySet();
        for(String str : keys){
            end = map.get(str);
            if(!map.containsKey(end)){
                break;
            }
        }

        return end;
    }

}
