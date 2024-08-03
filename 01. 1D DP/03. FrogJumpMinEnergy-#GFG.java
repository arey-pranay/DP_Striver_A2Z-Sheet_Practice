class Solution {
    public int minimumEnergy(int arr[], int N) {
        int[] memo = new int[N];
        Arrays.fill(memo,-1);
        return func(0, arr, N,memo);
    }
    
    public int func(int i, int arr[], int n, int[] memo) {
        // Base case: if we reach the end, no more energy needed
        if (i == n - 1) return 0;
        // If out of bounds
        if (i >= n) return Integer.MAX_VALUE;

        // Option 1: Move to the next step (i+1)
        int oneStep = Integer.MAX_VALUE;
        if (i < n - 1) {
            if(memo[i+1]==-1) memo[i+1] = func(i + 1, arr, n,memo);
            oneStep = Math.abs(arr[i + 1] - arr[i]) + memo[i+1];
        }

        // Option 2: Move two steps ahead (i+2)
        int twoStep = Integer.MAX_VALUE;
        if (i < n - 2) {
            if(memo[i+2]==-1) memo[i+2] = func(i+2,arr,n,memo);
            twoStep = Math.abs(arr[i + 2] - arr[i]) + memo[i+2];
        }

        return Math.min(oneStep, twoStep);
    }
}
