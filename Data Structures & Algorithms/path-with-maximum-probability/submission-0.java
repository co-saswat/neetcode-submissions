class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> grid = new ArrayList<>();
    
        for(int i = 0; i < n; i++){
            grid.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            grid.get(u).add(new double[]{v,p});
            grid.get(v).add(new double[]{u,p});
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        double[] prob = new double[n];
        prob[start_node] = 1.0;

        pq.offer(new double[]{start_node,1.0});

        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double currProb = curr[1];

            if(node == end_node) return currProb;

            for(double[] ed : grid.get(node)){
                int nextNode = (int) ed[0];
                double exProb = ed[1];
                double nextProb = currProb * exProb;

                if(nextProb > prob[nextNode]){
                    prob[nextNode] = nextProb;
                    pq.offer(new double[]{nextNode,prob[nextNode]});
                }
            }
        }

        return 0.0;
    }
}