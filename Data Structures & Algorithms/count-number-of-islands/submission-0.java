class Solution {
    int row , col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        boolean[][] visted = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j]=='1' && !visted[i][j]){
                    dfs(grid,visted,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visted, int i , int j){
        if(i < 0 || i >= row || j < 0 || j >= col) return;

        if(grid[i][j] == '0'){
            return;
        }

        if(visted[i][j]) return;

        visted[i][j] = true;

        dfs(grid,visted,i+1,j);
        dfs(grid,visted,i-1,j);
        dfs(grid,visted,i,j+1);
        dfs(grid,visted,i,j-1);
    }
}
