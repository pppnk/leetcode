//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water. 
//
// Example 1: 
//
// 
//Input:
//11110
//11010
//11000
//00000
//
//Output: 1
// 
//
// Example 2: 
//
// 
//Input:
//11000
//11000
//00100
//00011
//
//Output: 3
//

class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    islands++;
                    clearIsland(grid, i, j);
                }
            }
        }
        return islands;
    }

    public void clearIsland(char[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length ||grid[x][y] != '1'){
            return;
        }
        grid[x][y] = '0';
        clearIsland(grid, x-1, y);
        clearIsland(grid, x+1, y);
        clearIsland(grid, x, y-1);
        clearIsland(grid, x, y+1);
    }
}