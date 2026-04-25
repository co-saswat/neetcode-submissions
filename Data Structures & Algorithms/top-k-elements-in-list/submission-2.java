class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k >= nums.length) return nums;
        Map<Integer,Integer> valMap = new HashMap<>();
        int[] result = new int[k];
        int idx = 0;
        for(int num :  nums){
            valMap.put(num,valMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> newSet = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());

        newSet.addAll(valMap.entrySet());

        for(int i = 0; i<k;i++){
            result[i]=newSet.poll().getKey();
        }
        
        return result;
    }
}
