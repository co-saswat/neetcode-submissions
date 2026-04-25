class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String resultStr = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(resultStr)){
                resultStr = resultStr.substring(0,resultStr.length()-1);
            }
        }
        return resultStr;
    }
}