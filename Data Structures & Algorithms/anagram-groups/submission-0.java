class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> valMap = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String strVal = new String(ch);
            if(!valMap.containsKey(strVal)){
                List<String> listVal = new ArrayList<>();
                listVal.add(str);
                valMap.put(strVal,listVal);
            } else {
                valMap.get(strVal).add(str);
            }
        }
        return new ArrayList<>(valMap.values());
    }
}
