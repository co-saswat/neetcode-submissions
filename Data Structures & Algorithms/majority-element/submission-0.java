class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> valMap = new HashMap<>();

        for(int num : nums){
            valMap.put(num,valMap.getOrDefault(num,0)+1);
        }
        int maxItem = 0;
        int maxKey = 0;
        for(Map.Entry<Integer,Integer> entry : valMap.entrySet()){
            int item = entry.getValue();
            if(maxItem < item){
                maxItem = Math.max(maxItem,item);
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}