class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visted = new boolean[n][n];

        pq.offer(new int[]{grid[0][0],0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int time = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(visted[r][c]) continue;
            visted[r][c] = true;

            if(r == n-1 && c == n -1) {
                return time;
            }

            for(int[] d: dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visted[nr][nc]){
                    int newTime = Math.max(time,grid[nr][nc]);
                    pq.offer(new int[]{newTime,nr,nc});
                }
            }
        }

        return -1;
        
    }
}