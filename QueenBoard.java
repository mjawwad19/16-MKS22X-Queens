import java.util.*;
public class QueenBoard{
  private int[][] board;
  private int space;

  public QueenBoard(int size){
    board = new int[size][size];
    this.space = (int) Math.pow(size, 2);
  }

  private void clear() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = 0;
      }
    }
  }

  /*marks off threatened locations on the board by the given coords of a queen*/
  private void threaten(int r, int c) {
    for (int i = 1; i < board.length - c; i++) {
      board[r][c+i]++;
      if (i < board.length -r) board[r+i][c+i]++;
      if (i <= r) board[r-i][c+i]++;
    }
  }

  /*removes threatened locations on the board by the given coords of a queen*/
  private void unthreat(int r, int c) {
    for (int i = 1; i < board.length - c; i++) {
      board[r][c+i]--;
      if (i < board.length-r) board[r+i][c+i]--;
      if (i <= r) board[r-i][c+i]--;
    }
  }

  /*adds a queen in the given coords*/
  private boolean addQueen(int r, int c) {
    if (r < board.length && c < board.length) {
      if (board[r][c] != 0) return false;
    }
    board[r][c]--;
    threaten(r,c);
    return true;
  }

  /*removes a queen in the given coords*/
  private boolean removeQueen(int r, int c) {
    if (r < board.length && c < board.length) {
      if (board[r][c] != -1) return false;
    }
    board[r][c]++;
    unthreat(r,c);
    return true;
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _

  *_ _ _ Q

  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String out = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] >= 0) out += "_ ";
        if (board[i][j] == -1) out += "Q ";
        //if (board[i][j] > 0) out += "" + board[i][j] + " ";
      }
      out += "\n";
    }
    return out;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve() throws IllegalStateException{
    if (this.space == 0) return false;
    else if (board[0][0] != 0) throw new IllegalStateException("This board is not empty!");
    return solveH(0);
  }

  private boolean solveH(int col) throws IllegalArgumentException {
    if (col < 0) throw new IllegalArgumentException();
    if (col == board.length) return true;
    for (int i = 0; i < board.length; i++) {
      if (addQueen(i, col)) {
        if (solveH(col+1)) { //test to see if I can place the next queens...
          return true;
        }
      }
      removeQueen(i,col); //else remove and change position and retry.
    }
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions() throws IllegalStateException{
    if (this.space == 0) return 0;
    else if (board[0][0] != 0) throw new IllegalStateException();
    int ans = counter(0);
    clear();
    return ans;
  }

  private int counter(int col) {
    int count = 0;
    if (col >= board.length) return 1;
    for (int i = 0; i < board.length; i++) {
      if (addQueen(i, col)) {
        count += counter(col + 1);
      }
      removeQueen(i,col);
    }
    return count;
  }
  public static void runTest(int i){
    QueenBoard b;
    int[]tests =   {1,2,3,4,5,8};
    int[]answers = {1,0,0,2,10,92};
    if(i >= 0 && i < tests.length ){
      int size = tests[i];
      int correct = answers[i];
      b = new QueenBoard(size);
      int ans  = b.countSolutions();

      if(correct==ans){
        System.out.println("PASS board size: "+tests[i]+" "+ans);
      }else{
        System.out.println("FAIL board size: "+tests[i]+" "+ans+" vs "+correct);
      }
    }
  }
}
