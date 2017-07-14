package zx.leetcode.july;
/**
 * 529. Minesweeper
 * @author Carl_Hugo
 *
 */
public class Test19 {
	
	/**
	 * 'M' 表示有未发现的雷 ;
	 * 'E' 表示未点击的空白区域
	 * 'B' 表示周围没有雷，递归判断
	 * 'X' 表示被发现的雷
	 * @param board
	 * @param click
	 * @return
	 */
    public char[][] updateBoard(char[][] board, int[] click) {
    	if(board==null||board.length==0){
    		return board;
    	}
    	//如果当前为雷，结束点击
    	if(board[click[0]][click[1]]=='M'){
    		board[click[0]][click[1]]='X';
    		return board;
    	}
    	dfs(board,click[0],click[1]);
        return board;
    }
    //针对原来点的偏移位置（周围一圈）
    int[] dx = {-1,0,1,-1,1,-1, 0, 1};
    int[] dy = { 1,1,1, 0,0,-1,-1,-1};
    
    private void dfs(char[][] board,int x,int y){
    	//当前位置不为空或越界，结束循环
    	if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]!='E'){
    		return;
    	}
    	//获取周围雷的数量
    	int num = getNumsOfBombs(board,x,y);
    	if(num==0){
    		//说明周围没有雷,dfs递归判断
    		board[x][y]='B';
    		for(int i=0;i<8;i++){
    			int nx = x+dx[i],ny = y+dy[i];
    			dfs(board,nx,ny);
    		}
    	}else{
    		board[x][y] = (char)('0'+num);
    	}
    	
    }
    
    private int getNumsOfBombs(char[][] board,int x,int y){
    	int num = 0;
    	for(int i=-1;i<=1;i++){
    		for(int j=-1;j<=1;j++){
    			int nx = x+i,ny=y+j;
    			if(nx<0||nx>=board.length||ny<0||ny>=board[0].length){
    				continue;
    			}
    			if(board[nx][ny]=='M'||board[nx][ny]=='X'){
    				num++;
    			}
    		}
    	}
    	return num;
    }
 
}
