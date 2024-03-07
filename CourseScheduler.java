import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CourseScheduler {
    public static int scheduleCourse(int[][] arr) {
        Arrays.sort(arr, (o1, o2) -> (o1[1] == o2[1]) ? (o1[0]-o2[0]) : (o1[1]-o2[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int[] i : arr){
            System.out.println(i[0] + " " + i[1]);
        }

        int time=0;
        int res=0;

        for(int[] i : arr){
            if(time + i[0] <= i[1]){
                pq.offer(i[0]);
                time += i[0];
                res++;
            } 
            else if(!pq.isEmpty() && i[0] < pq.peek()){
                time =- pq.poll();
                time += i[0];
                pq.offer(i[0]);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{5,5},{2,6},{4,6}};
        System.out.println(scheduleCourse(arr));
    }
}
