class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int[] vis = new int[numCourses];
        for(int i = 0 ; i < numCourses; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            int course = pre[0];
            int preCourse = pre[1];

            adj.get(preCourse).add(course);
        }

        for(int i = 0 ; i < numCourses; i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis)){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int i , Map<Integer,List<Integer>> adj, int[] vis){
        if(vis[i]==1){
            return true;
        }

        if(vis[i]==2){
            return false;
        }

        vis[i]=1;

        for(int idx : adj.get(i)){
            if(dfs(idx,adj,vis)){
                return true;
            }
        }

        vis[i]=2;
        return false;
    }
}
