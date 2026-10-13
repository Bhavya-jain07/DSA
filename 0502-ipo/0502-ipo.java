class Solution {
    public class pair{
        int profit;
        int weight;
        public pair(int profit, int weight){
            this.profit = profit;
            this.weight = weight;

        }

    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] weight) {
        List<pair> ll = new ArrayList<>();
        for(int i = 0; i< profits.length; i++){
            ll.add(new pair(profits[i], weight[i]));
        }
        Collections.sort(ll, (a,b)-> a.weight-b.weight);
        PriorityQueue<Integer> hp = new PriorityQueue<>((a, b) -> b - a);
        int j = 0;
        for(int i = 0; i<k; i++){
            while(j<profits.length && ll.get(j).weight<=w){
                hp.add(ll.get(j).profit);
                j++;
            }
            if(hp.isEmpty()){
                break;
            }
            
        w+=hp.poll();
        }
        return w;
    }
}