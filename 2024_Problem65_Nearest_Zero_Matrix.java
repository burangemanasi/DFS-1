//541. 01 Matrix - https://leetcode.com/problems/01-matrix/description/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n)

class Solution {
    int[][] dirs ;
    public int[][] updateMatrix(int[][] mat) {
        this.dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        //base case
        if(m == 0 || n == 0 || mat == null)
            return mat;
        //add all 0's to queue
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0)
                    q.add(new int[]{i,j});
                else
                    mat[i][j] = -1;  //mark all as un-visited
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    //edge case
                    if(r >= 0 && c>=0 && r<m && c<n && mat[r][c] == -1){
                        mat[r][c] = mat[curr[0]][curr[1]]+1;
                        q.add(new int[]{r,c});
                    }
                }
            }
        }
        return mat;
    }
}