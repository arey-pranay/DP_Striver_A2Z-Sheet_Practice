class Solution {
    public int minimizeCost(int arr[], int k) {
        int N = arr.length;
        int[] memo = new int[N];
        Arrays.fill(memo, -1);
        return func(0, arr, N, memo, k);
    }

    private int func(int i, int arr[], int n, int[] memo, int limit) {
        // Base case: if we reach the end, no more energy needed
        if (i == n - 1) return 0;

        // If already computed, return the memoized result
        if (memo[i] != -1) return memo[i];

        // Initialize the minimum cost to a large value
        int minCost = Integer.MAX_VALUE;

        // Try all possible jumps from 1 to limit
        for (int k = 1; k <= limit; k++) {
            if (i + k < n) {
                int cost = Math.abs(arr[i + k] - arr[i]) + func(i + k, arr, n, memo, limit);
                minCost = Math.min(minCost, cost);
            }
        }

        // Store the result in memo array and return it
        memo[i] = minCost;
        return minCost;
    }
}
