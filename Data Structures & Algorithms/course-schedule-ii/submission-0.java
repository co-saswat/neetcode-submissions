class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];

            adj.get(b).add(a);
        }

        Stack<Integer> st = new Stack<>();
        int[] vis = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0){
                if(dfs(i,adj,st,vis)){
                    return new int[0];
                }
            }
        }

        int[] res = new int[numCourses];
        int idx = 0;

        while(!st.isEmpty()){
            res[idx++] = st.pop();
        }

        return res;
    }

    private boolean dfs(int node , List<List<Integer>> adj, Stack<Integer> st, int[] vis){
        vis[node] = 1;

        for(int ed : adj.get(node)){
            if(vis[ed]==1){
                return true;
            }
            if(vis[ed]==0){
                if(dfs(ed,adj,st,vis)){
                    return true;
                }
            }
        }

        vis[node] = 2;
        st.push(node);

        return false;
    }
}
