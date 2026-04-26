class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        1. Create the Graph 
        2. Map the values in the Grap
        3. Create pointer to keep the weight values
        4. Create a Priority Queue and store the data
        5. use Dijistra Algorithm to kind the min values 
        6. get the min values to reach all nodes
        */

        List<List<int[]>> adjMat = new ArrayList<>();

        for(int i = 0; i <= n ; i++){
            adjMat.add(new ArrayList<>());
        }

        for(int[] t : times){
            int u = t[0];
            int v = t[1];
            int w = t[2];

            adjMat.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            if(weight > dist[node]) continue;

            for(int[] adj : adjMat.get(node)){
                int newNode = adj[0];
                int innerWeight = adj[1];
                int newWeight = weight + innerWeight;

                if(newWeight < dist[newNode]){
                    dist[newNode] = newWeight;
                    pq.offer(new int[]{newNode,dist[newNode]});
                }
            }
        }

        int maxTime = 0;

        for(int i = 1; i <= n ; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }else {
                maxTime = Math.max(maxTime,dist[i]);
            }
        }

        return maxTime;
    }
}
