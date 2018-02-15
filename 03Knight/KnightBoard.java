import java

public class KnightBoard{
    int board[][];
    int possibleMoves[][] = {{2,1},{1,2},{-1,-2},{-2,-1},
			     {-1,2},{2,-1},{-2,1},{1,-2}}

    public KnightBoard(int startingRows, int startingCols){
	board = new board[startingRows][startingCols];
    }

    public String toString(){
	String s = "";
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		if(board.length*board.length <= 10){
		    if(board[i][j]==0){
			s+=" _ ";
		    }else{
			s+=" " + board[i][j];
		    }
		}else{
		    if(board[i][j]==0){
			s+= " _ ";
		    }else if(board[i][j]<=10){
			s+= "  " + board[i][j];
		    }
		    else{
			s+=" " + board[i][j];
		    }
		}
		
	    }
	}
	return s;
    }

    public boolean solve(int startingRow, int startingCol){
	if(startingRow<0 || startingRow>=board.length || startingCol<0 ||
	   startingCol>=board.length){
	    throw new IllegalArgumentException();
	}
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		if(board[i][j]!= 0){
		    throw new IllegalArgumentException();
		}
	    }
	}
	return solveH(0,0,1);
    }

    private boolean solveH(int row, int col, int level){
	if(level == board.length*board[row].length){
	    return true;
	}
	for(int 
    }
}
