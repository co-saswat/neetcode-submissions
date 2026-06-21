class Solution {
    Integer[][] dp;

    boolean count(int idx , int[] nums, int target){
        if(target == 0) return true;

        if(idx == 0) return nums[0] == target;

        if(dp[idx][target] != null){
            return dp[idx][target] == 1;
        }

        boolean notTake = count(idx-1,nums,target);
        boolean take = false;
        if(nums[idx] <= target) take = count(idx-1,nums,target-nums[idx]);

        dp[idx][target] = (notTake || take) ? 1 : 0;

        return (notTake || take);
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum %2 != 0){
            return false;
        }
        int target = totalSum / 2;
        dp = new Integer[n][target+1];
        
        return count(n-1,nums,target);
    }
}
