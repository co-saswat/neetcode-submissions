class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character , Integer> mapVal = new HashMap<>();

        for(char c :  s.toCharArray()){
            mapVal.put(c, mapVal.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray()){
            if(!mapVal.containsKey(c)||mapVal.get(c)==0){
                return false;
            }
            mapVal.put(c,mapVal.get(c)-1);
        }
        return true;
    }
}
