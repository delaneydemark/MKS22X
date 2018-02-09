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
	    s+="\n";
	}
	return s;
    }


    
    private boolean addQueen(int r, int c){
	if(board[r][c]==0){
	    board[r][c]=-1;
	    return true;
	    for(int i = 0; i<board[r].length; i++){
		if(i!=c){
		    board[r][i]+=1;
		}
	    }
	    for(int i = 0; i<board.length; i++){
		if(i!=r){
		    board[i][c]+=1;
		}
	    }
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if(board[r][c]==-1){
 	    board[r][c]=0;
	    return true;
	}
	return false;
    }

    public static void main(String[] args){
	QueenBoard test = new QueenBoard(3);
	System.out.println(test.toString());
    }
}