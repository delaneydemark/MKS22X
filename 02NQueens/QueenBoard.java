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
	    for(int i = 1; r+i<board.length && c+i<board[r+i].length; i++){
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
	    for(int i = 1; c-i>=0 && r+i<board.length; i++){
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
	    for(int i = 1; r+i<board.length && c+i<board[r+i].length; i++){
		board[r+i][c+i]-=1;
	    }
	    for(int i = 1; c+i<board.length && r-i>=0; i++){
		board[r-i][c+i]-=1;
	    }
	    for(int i = 1; c-i>=0 && r-i>=0; i++){
		board[r-i][c-i]-=1;
	    }
	    for(int i = 1; c-i>=0 && r+i<board.length; i++){
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
	return solveHelper(0);
    }

    public boolean solveHelper(int c){
	if(c == board.length){
	    return true;
	}
	for(int i = 0; i<board.length; i++){
	    if(addQueen(i,c)){
		if(solveHelper(c+1)){
		    return true;
		}
		removeQueen(i,c);
	    }
	}
	return false;
    }

    public int countSolutions(){
	for(int i = 0; i<board.length; i++){
	    for(int j = 0; j<board[i].length; j++){
		if(board[i][j]!=0){
		    throw new IllegalStateException();
		}
	    }
	}	
	return countHelper(0);
    }

    public int countHelper(int c){
	int count = 0;
	if(c >= board.length){
	    return 1;
	}
	   for(int i = 0; i<board.length; i++){
	       if(addQueen(i,c)){
		   count+=countHelper(c+1);
		   removeQueen(i,c);
	       }
	   }
	return count;
    }

    /*public static void main(String[] args){
	QueenBoard a = new QueenBoard(4);
	System.out.println(a.toString());
	System.out.println(a.solve());
	System.out.println(a.boardNums());
	System.out.println(a.toString());
	for(int i = 0; i<10; i++){
	    QueenBoard test = new QueenBoard(i);
	    System.out.println(test.countSolutions());
	    //System.out.println(test.toString());
	}
	String s = "0x0:1 1x1:1 2x2:0 \n 3x3:0 4x4:2 5x5:10 \n 6x6:4 7x7:40 8x8:92 \n 9x9:352";
	System.out.println(s);
	}*/
}
