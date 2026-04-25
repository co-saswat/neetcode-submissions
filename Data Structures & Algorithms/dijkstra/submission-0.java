class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<List<int[]>> adjMat = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            adjMat.add(new ArrayList<>());
        }

        for(List<Integer> val : edges){
            int u = val.get(0);
            int v = val.get(1);
            int w = val.get(2);

            adjMat.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] dist = new int[n+1];

        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new int[]{src,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int ver = curr[0];
            int wei = curr[1];

            if(wei > dist[ver]) continue;

            for(int[] adj: adjMat.get(ver)){
                int newVer = adj[0];
                int nextWei = adj[1];

                if(wei+nextWei < dist[newVer]){
                    dist[newVer] = wei+nextWei;
                    pq.offer(new int[]{newVer,dist[newVer]});
                }
            }
        }

        Map<Integer,Integer> resultMap = new HashMap<>();

        for(int i = 0; i < n ;i++){
            if(dist[i]==Integer.MAX_VALUE){
                resultMap.put(i,-1);
            } else {
                resultMap.put(i,dist[i]);
            }
        }

        return resultMap;
    }  
}
