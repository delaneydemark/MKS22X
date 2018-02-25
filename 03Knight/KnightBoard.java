public class KnightBoard{
    int board[][];
    int possibleMoves[][] = {{2,1},{1,2},{-1,-2},{-2,-1},
			     {-1,2},{2,-1},{-2,1},{1,-2}};
    int countSol;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	countSol=0;
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
	if(level > board.length*board[0].length){
	    return true;
	}
	if(row<0 || row>=board.length || col<0 || col>=board[0].length){
	    return false;
	}
	if(board[row][col]!=0){
	    return false;
	}
	board[row][col]=level;
	for(int i = 0; i<possibleMoves.length; i++){
	    if(solveH(row+possibleMoves[i][0], col+possibleMoves[i][1], level+1)){
		return true;
	    }
	       
	}
	board[row][col]=0;
	return false;
    }

    public int countSolutions(int startingRow, int startingCol){
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		if(board[i][j]!=0){
		    throw new IllegalArgumentException();
		}
	    }
	}
	if(startingRow<0 || startingRow>=board.length || startingCol<0 || startingCol>=board[0].length){
	    throw new IllegalArgumentException();
	}
	countSolutionsH(startingRow, startingCol, 1);
	return countSol;
    }

    public boolean countSolutionsH(int row, int col, int level){
	if(level> board.length*board[0].length){
	    countSol+=1;
	}
	if(row<0 || row>=board.length || col<0 || col>=board[0].length){
	    return false;
	}
	if(board[row][col]!=0){
	    return false;
	}
	board[row][col]=level;
	for(int i = 0; i<possibleMoves.length; i++){
	    return countSolutionsH(row+possibleMoves[i][0], col+possibleMoves[i][1], level+1);
	}
	board[row][col]=0;
	return true;
    }

    public static void main(String[] args){
	KnightBoard test = new KnightBoard(7,7);
	System.out.println(test.toString());
	//System.out.println(test.solve(2,2));
	//System.out.println(test.toString());
	System.out.println(test.countSolutions(2,2));
    }
}
