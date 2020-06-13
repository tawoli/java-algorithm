package leetcode._200;

public class Solution {
    private void dfs(char[][] grid, int row, int col) {
        int gridRow = grid.length;
        int gridCol = grid[0].length;

        if (row < 0 || col < 0 || row >= gridRow || col >= gridCol || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int gridRow = grid.length;
        int gridCol = grid[0].length;
        int islandsNum = 0;
        for (int row = 0; row < gridRow; row++) {
            for (int col = 0; col < gridCol; col++) {
                if (grid[row][col] == '1') {
                    islandsNum++;
                    dfs(grid, row, col);
                }
            }
        }

        return islandsNum;
    }
}