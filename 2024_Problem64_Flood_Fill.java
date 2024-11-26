//733. Flood Fill - https://leetcode.com/problems/flood-fill/description/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

//BFS
class Solution {
    int[][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        this.m = image.length;
        this.n = image[0].length;
        //save oldColor to find occurrences of the same
        int oldColor = image[sr][sc];
        //no change in the result matrix
        if(oldColor == color){
            return image;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(sr);
        q.add(sc);
        //MARK VISITED
        image[sr][sc] = color;

        while(!q.isEmpty()) {
            int r = q.poll();
            int c = q.poll();

            for(int[] dir:dirs){
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                //check bounds and if found oldColor, modify and put neighboring nodes to queue
                if(nr >= 0 && nc >=0 && nr <m && nc < n && image[nr][nc] == oldColor){
                    image[nr][nc] = color;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
        return image;
    }
}

//DFS
class Solution {
    int[][] dirs;
    int m,n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        this.m = image.length;
        this.n = image[0].length;
        //save oldColor to find occurrences of the same
        int oldColor = image[sr][sc];
        //no change in the result matrix
        if(oldColor == color){
            return image;
        }

        dfs(image, sr, sc, oldColor, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int oldColor, int newColor){
        //base case
        if(i<0 || j<0 || i==m || j == n ||image[i][j] != oldColor){
            return;
        }
        image[i][j] = newColor;
        //logic
        for(int[] dir : dirs){
            int nr = dir[0] + i;
            int nc = dir[1] + j;

            dfs(image, nr, nc, oldColor, newColor);
        }
    }
}