class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer,Integer> mapVal = new HashMap<>();

        for(int num : nums){
            mapVal.put(num,mapVal.getOrDefault(num,0)+1);
        }

        for(int num : mapVal.values()){
            if(num > 1){
                return true;
            }
        }

        return false;
    }
}