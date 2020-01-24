//DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //consider starting sr,sc to be old
        int oldColor = image[sr][sc];
        //if new and old colors are equal, no change needed
        //return the image
        //else call the changecolor function
        if(oldColor != newColor){
            changeColor(image, sr, sc, oldColor, newColor);
        }
        return image;
    }
    
    private void changeColor(int[][] image, int sr, int sc, int oldColor, int newColor){
        
        //base case
        //image[sr][sc] != oldColor -> time limit exceeded
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor)
            return;
        
        image[sr][sc] = newColor;
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        for(int[] dir : directions){
            int row = sr + dir[0];
            int col = sc + dir[1];
            changeColor(image, row, col, oldColor, newColor);
        }
    }
}


/************************************************************************* */

//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //queue for BFS 
        Queue<int[]> pixels = new LinkedList<int[]>();
        
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
        int row = image.length;
        int col = image[0].length;
        //oldColor is the starting pixel
        int oldColor = image[sr][sc];
        
        //add first occured pixel to queue
        pixels.add(new int[]{sr,sc});
        image[sr][sc] = newColor;

        //if no pixel in queue
        if(pixels.isEmpty())
            return image;


        while(!pixels.isEmpty()){
            int[] currPixel = pixels.remove();
            for(int[] directions : dir){
                int x = currPixel[0] + directions[0];
                int y = currPixel[1] + directions[1];

                if(x<0 || y<0 || x>=row || y>=col || image[x][y]==newColor || image[x][y]!=oldColor)
                    continue;

                image[x][y] = newColor;
                pixels.add(new int[]{x,y});
            }
        }
        return image;
        
    }
}