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
	return solveH(startingRow,startingCol,1);
    }

    private boolean solveH(int row, int col, int level){
	if(level == board.length*board[row].length){
	    return true;
	}
	for(int i = 0; i<possibleMoves.length; i++){
	    if(!(row+possibleMoves[i][0]<0) && !(row+possibleMoves[i][0]>=board.length)
	       && !(col+possibleMoves[i][1]<0) && !(col+possibleMoves[i][1]>=board[row].length)){
		int r = row+possibleMoves[i][0];
		int c = col+possibleMoves[i][1];
		board[r][c]=level;
		solveH(r, c, level+1);
	    }
	       
	}
	return false;
    }
}
