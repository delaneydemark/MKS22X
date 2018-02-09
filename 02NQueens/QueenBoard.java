public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public String toString(){
	String s = "";
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[0].length; j++){
		if(board[i][j]==-1){
		    s+="Q";
		}else{
		    s+="_";
		}
	    }
	}
	return s;
    }
}
