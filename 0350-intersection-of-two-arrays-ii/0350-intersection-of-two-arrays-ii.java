class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x:nums1){
           map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> ll = new ArrayList<>();
        for(int x:nums2){
            // map.put(x,map.getOrDefault(x, 0)-1);
            if(map.containsKey(x) && map.get(x)>0){
                ll.add(x);
                map.put(x, map.get(x)-1);
            }
        }
        int [] ans = new int [ll.size()];
        for(int i =0; i<ans.length; i++){
            ans[i] = ll.get(i);
        }
    return ans;

    }
}