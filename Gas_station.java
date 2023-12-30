public class Gas_station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        int[] gas =  {5,8,2,8};
        int[] cost = {6,5,6,6};
        
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
