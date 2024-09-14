class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length+3];
        Arrays.fill(memo,-1);
        return func(nums, 0, memo);
    }
    public int func(int[] nums, int i, int[] memo){

        if(i>= nums.length) return 0;

        int notTake;
        if(memo[i+1]==-1) memo[i+1] = func(nums, i+1, memo);
        notTake = memo[i+1];

        int skip1;
        if(memo[i+2]==-1) memo[i+2] = func(nums, i+2, memo);
        skip1 = memo[i+2];

        int skip2;
        if(memo[i+3]==-1) memo[i+3] = func(nums, i+3, memo);
        skip2 = memo[i+3];

        int take = nums[i] + Math.max(skip1,skip2);

        memo[i] = Math.max(notTake,take);

        return memo[i];

    }
}
