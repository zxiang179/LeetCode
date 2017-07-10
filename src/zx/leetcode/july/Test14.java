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
        		//访问初始结点v，并标记结点v为已访问
        		visited[j]=1;
        		//查找结点v的第一个邻接结点w,若w存在，则继续执行DFS，否则算法结束
        		dfs(M,visited,j);
        	}
        }
	}
	public static void main(String[] args) {
		new Test14().findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}});
	}
}
