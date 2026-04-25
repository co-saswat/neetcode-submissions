class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mapVal = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            int diff = target - nums[i];
            if(mapVal.containsKey(diff)){
                return new int[]{mapVal.get(diff),i};
            } else {
                mapVal.put(nums[i],i);
            }
        }

        return new int[]{};
    }
}
