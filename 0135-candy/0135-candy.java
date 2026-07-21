class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        int[] candi = new int[n];
        Arrays.fill(candi, 1);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (rating[i] > rating[i - 1]) {
                candi[i] = candi[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (rating[i] > rating[i + 1]) {
                candi[i] = Math.max(candi[i + 1] + 1, candi[i]);
            }
            ans += candi[i];
        }
        return ans + candi[n - 1];
    }
}