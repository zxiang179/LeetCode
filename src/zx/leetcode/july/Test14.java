package zx.leetcode.july;
/**
 * 547. Friend Circles
 * @author Carl_Hugo
 * @date 2017年7月9日
 */
public class Test14 {
	
    /**
     * find friend circles(dfs)
     * @param M
     * @return
     */
	public int findCircleNum(int[][] M) {
		int[] visited = new int[M.length];
		int count = 0;
		for(int i=0;i<M.length;i++){
			if(visited[i]==0){
				dfs(M,visited,i);
				count++;
			}
		}
        return count;
    }
	
	public void dfs(int[][] M,int[] visited,int i){
		for(int j=0;j<M.length;j++){
        	if(M[i][j]==1&&visited[j]==0){
        		visited[j]=1;
        		dfs(M,visited,j);
        	}
        }
	}
	public static void main(String[] args) {
		new Test14().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}});
	}
}
