public class KnightBoard{
    int board[][];
    int possibleMoves[][] = {{2,1},{1,2},{-1,-2},{-2,-1},
			     {-1,2},{2,-1},{-2,1},{1,-2}};

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
    }

    public String toString(){
	String s = "";
	/*if(!(this.solve())){
	    for(int i = 0; i<board.length; i++){
		for(int j = 0; j<board[i].length; j++){
		    board[i][j]=0;
		}
	    }
	    }*/
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		if(board.length*board.length < 10){
		    if(board[i][j]==0){
			s+=" _ ";
		    }else{
			s+=" " + board[i][j];
		    }
		}else{
		    if(board[i][j]==0){
			s+= " _ ";
		    }else if(board[i][j]<10){
			s+= "  " + board[i][j];
		    }
		    else{
			s+=" " + board[i][j];
		    }
		}
		
	    }
	    s+="\n";
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
	if(level > board.length*board[row].length){
	    return true;
	}
	for(int i = 0; i<possibleMoves.length; i++){
	    int r = row+possibleMoves[i][0];
	    int c = col+possibleMoves[i][1];
	    if(!(r<0) && !(r>=board.length) && !(c<0) && !(c>=board[row].length)){
		if(board[r][c]==0){
		    board[r][c]=level;
		    solveH(r, c, level+1);
		}
	    }
	       
	}
	return false;
    }

    public static void main(String[] args){
	KnightBoard test = new KnightBoard(8,8);
	System.out.println(test.toString());
	System.out.println(test.solve(3,3));
	System.out.println(test.toString());
    }
}
