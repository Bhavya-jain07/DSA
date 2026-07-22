class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<int[]> ll = new ArrayList<>();
        int [] prev = intervals[0];
        for(int i =0; i<intervals.length; i++){
            if(intervals[i][0]<=prev[1]){
                prev[1] = Math.max(prev[1],intervals[i][1]);
            }
            else{
                ll.add(prev);
                prev = intervals[i];
            }
        }
        ll.add(prev);
        return ll.toArray(new int [ll.size()][]);
    }
}