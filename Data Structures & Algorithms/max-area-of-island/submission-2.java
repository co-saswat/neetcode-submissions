class Solution {
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int row, col;
    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0 ; j < col; j++){
                if(grid[i][j]==1){
                   int area = dfs(grid,i,j);
                    maxArea = Math.max(maxArea , area);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int i , int j){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j] = 0;
        int area = 1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc]==1){
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }

        return area;
    }

    private int dfs(int[][] grid, int i , int j){
        if(i < 0 || i >= row) return 0;
        if(j < 0 || j >= col) return 0;

        if(grid[i][j]==0) return 0;

        grid[i][j] = 0;
        int area = 1;

        area = area + dfs(grid,i+1,j);
        area = area + dfs(grid,i-1,j);
        area = area + dfs(grid,i,j+1);
        area = area + dfs(grid,i,j-1);

        return area;
    }
}
