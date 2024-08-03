class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+3];
        Arrays.fill(memo,-1);
        return func(0,n,memo);
    }
    public int func(int i, int n, int[] memo){
        if(i==n) return 1;
        if(i>n) return 0;
        if(memo[i+1]==-1) memo[i+1] = func(i+1,n,memo);
        int oneStep = memo[i+1];
        if(memo[i+2]==-1) memo[i+2] = func(i+2,n,memo);
        int twoStep = memo[i+2];
        return oneStep + twoStep;
    }
}
