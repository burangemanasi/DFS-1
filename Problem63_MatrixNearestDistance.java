//BFS
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //declaring row and col
        int row = matrix.length;
        int col = matrix[0].length;
        //base case
        if(row == 0 || col == 0 || matrix == null)
            return matrix;
        //adding in queue for bfs
        Queue<int[]> queue = new LinkedList<>();
        //iterating over the matrix
        for(int i = 0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    //adding all elements to queue if equals 0
                    queue.add(new int[]{i,j});
                }
                else{
                    //else add INFINITY
                    matrix[i][j] = 9;
                }
            }
        }
        
        //directions array
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        //poll queue elements till is empty
        while(!queue.isEmpty()){
            
            int size = queue.size();
            for(int i=0; i<size; i++){
                
                int[] curr = queue.poll();
                for(int[] dir : directions){
                    //base cases
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x >= 0 && y>=0 && x<row && y<col && matrix[x][y] >= matrix[curr[0]][curr[1]]+1){
                                                
                        matrix[x][y] = Math.min(matrix[curr[0]][curr[1]]+1, matrix[x][y]);
                        queue.add(new int[]{x,y});
                    } 
                    
                }
                
            }
        } 
        return matrix;
    }
}