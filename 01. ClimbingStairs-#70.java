class Solution {
    int[] memo = new int[46];
    public int climbStairs(int n) {
        if(n==1){
            memo[1] = 1;
            return 1;
        } 
        if(n==2){
            memo[2] = 2;
            return 2;
        } 
        if(memo[n-1]==0){
            memo[n-1] = climbStairs(n-1);
        }
        if(memo[n-2]==0){
            memo[n-2] = climbStairs(n-2);
        }
        return memo[n-1] + memo[n-2];
    }
}
