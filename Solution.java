class Solution {
    static int shotestPath(int[][] mat, int n, int m, int k) {
    if (n == 1 && m == 1 && (mat[0][0] == 0 || k >= 1))
    return 0; 
    boolean[][][] visited = new boolean [n][m][k+1];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            for(int q=0;q<k+1;q++)
            {
                visited[i][j][q]=false;
            }
        }
    }
     
    int steps = 0;
 
    ArrayList<ArrayList<Integer> > q = new ArrayList<ArrayList<Integer> >();
     
    q.add(new ArrayList<Integer>(Arrays.asList(0, 0, k)));
    int[] ar1 = { 1, -1, 0, 0 };
    int[] ar2 = { 0, 0, -1, 1 };
 
    // Loop to run a BFS
    while (q.size()!=0) {
        int size = q.size();
 
        steps++;
        while (size>0) {
            ArrayList<Integer> curr = q.get(0);
            int i = curr.get(0), j = curr.get(1), w = curr.get(2);
            q.remove(0);
            visited[i][j][w] = true;
            for (int dir = 0; dir < 4; dir++) {
                int new_x = i + ar1[dir];
                int new_y = j + ar2[dir];
                int new_k = w;
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                    if (mat[new_x][new_y] == 0 && !visited[new_x][new_y][new_k]) {
                        if (new_x == n - 1 && new_y == m - 1)
                            return steps;
                        q.add(new ArrayList<Integer>(Arrays.asList(new_x,new_y,new_k)));
                        visited[new_x][new_y][new_k] = true;
                    }
                    else if (mat[new_x][new_y] == 1 && new_k >= 1 && !visited[new_x][new_y][new_k - 1]) {
                        if (new_x == n - 1 && new_y == m - 1)
                            return steps;
                        q.add(new ArrayList<Integer>(Arrays.asList(new_x,new_y,new_k-1)));
                        visited[new_x][new_y][new_k - 1] = true;
                    }
                }
            }
            size--;
        }
    }
    return -1;
        // code here
    }
}