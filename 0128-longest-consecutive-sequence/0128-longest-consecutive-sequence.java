class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int ans = 0;
        for(int i =0; i<nums.length; i++){
            int x = nums[i];
            if(set.contains(x) && !set.contains(x-1)){
                int c = 0;
                while(set.contains(x)){
                    c++;
                    set.remove(x);
                    x++;
                }
            ans = Math.max(ans, c);
            }
        }
    return ans;
    }
}