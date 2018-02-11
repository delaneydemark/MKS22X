import java.io.*;

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
	    for(int i = 0; i<board[r].length; i++){
		if(i!=c && board[r][i]==-1){
		    return false;
		}
		if(i!=c){
		    board[r][i]+=1;
		}
	    }
	    for(int i = 0; i<board.length; i++){
		if(i!=c && board[i][c]==-1){
		    return false;
		}
		if(i!=r){
		    board[i][c]+=1;
		}
	    }
	    for(int i = 1; r+i<board.length; i++){
		board[r+i][c+i]+=1;
	    }
	    for(int i = 1; c+i<board.length && r-i>=0; i++){
		board[r-i][c+i]+=1;
	    }
	    for(int i = 1; c-i>=0 && r-i>=0; i++){
		if(board[r-i][c-i]==-1){
		    return false;
		}
		board[r-i][c-i]+=1;
	    }
	    for(int i = 1; c-i>=0 && i<board.length; i++){
		if(board[r+i][c-i]==-1){
		    return false;
		}
		board[r+i][c-i]+=1;
	    }
	    board[r][c]=-1;
	    return true;
	    
	}
	return false;
    }

    private boolean removeQueen(int r, int c){
	if(board[r][c]==-1){
	    for(int i = 0; i<board[r].length; i++){
		if(i!=c){
		    board[r][i]-=1;
		}
	    }
	    for(int i = 0; i<board.length; i++){
		if(i!=r){
		    board[i][c]-=1;
		}
	    }
	    for(int i = 1; r+i<board.length; i++){
		board[r+i][c+i]-=1;
	    }
	    for(int i = 1; c+i<board.length && r-i>=0; i++){
		board[r-i][c+i]-=1;
	    }
	    for(int i = 1; c-i>=0 && r-i>=0; i++){
		board[r-i][c-i]-=1;
	    }
	    for(int i = 1; c-i>=0 && i<board.length; i++){
		board[r+i][c-i]-=1;
	    }
 	    board[r][c]=0;
	    return true;
	}
	return false;
    }

    public String boardNums(){
	String s = "";
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		s+=" " + board[i][j] + " ";
	    }
	    s+="\n";
	}
	return s;
    }

    public boolean solve(){
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		if(board[i][j]!=0){
		    throw new IllegalStateException();
		}
	    }
	}
    }

    public static void main(String[] args){
	QueenBoard test = new QueenBoard(3);
	System.out.println(test.toString());
	/*test.addQueen(1,1);
	System.out.println(test.boardNums());
	System.out.println(test.toString());
	test.removeQueen(1,1);
	System.out.println(test.boardNums());
	System.out.println(test.toString());
	*/
    }
}
