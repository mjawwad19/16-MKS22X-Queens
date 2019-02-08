public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
}

  private void threaten(int r, int c) {
    for (int rII = r -1; rII >=0; rII--) {
      board[rII][c]++; //add up by 1 each threaten up the column
    }
    for (int rI = r + 1; rI < board.length; rI++) {
      board[rI][c]++;
      //add up by 1 each threaten down the column
    }
    for (int cII = c -1; cII >= 0; cII--) {
      board[r][cII]++;
    }
    for (int cI = c + 1; cI < board.length; cI++) {
      board[r][cI]++;
    }
    //mark off the row threatened. ^ //diagonals threatened below
    for (int rI = r +1, cI = c+1; rI < board.length && cI < board.length; rI++,cI++) {
      board[rI][cI]++;
    }
    for (int rII = r-1, cII = c-1; rII >= 0 && cII >= 0; rII--, cII--){
      board[rII][cII]++;
    }
    for (int rI = r +1, cII = c-1; rI < board.length && cII >= 0; rI++, cII--) {
      board[rI][cII]++;
    }
    for (int rII = r -1, cI = c+1; rII >= 0 && cI < board.length; rII--, cI++) {
      board[rII][cI]++;
    }
  }

  private void unthreat(int r, int c) {
    for (int rII = r -1; rII >=0; rII--) {
      board[rII][c]--; //subtract down by 1 each prev threatened.
    }
    for (int rI = r + 1; rI < board.length; rI++) {
      board[rI][c]--;
    }
    for (int cII = c -1; cII >= 0; cII--) {
      board[r][cII]--;
    }
    for (int cI = c + 1; cI < board.length; cI++) {
      board[r][cI]--;
    }
    //unmark off the row threatened. ^ //diagonals threatened below
    for (int rI = r +1, cI = c+1; rI < board.length && cI < board.length; rI++,cI++) {
      board[rI][cI]--;
    }
    for (int rII = r-1, cII = c-1; rII >= 0 && cII >= 0; rII--, cII--){
      board[rII][cII]--;
    }
    for (int rI = r +1, cII = c-1; rI < board.length && cII >= 0; rI++, cII--) {
      board[rI][cII]--;
    }
    for (int rII = r -1, cI = c+1; rII >= 0 && cI < board.length; rII--, cI++) {
      board[rII][cI]--;
    }
  }

  public boolean addQueen(int r, int c) {
    if (r < board.length && c < board.length) {
      if (board[r][c] == 0) {
        board[r][c]--;
        threaten(r,c);
        return true;
      }else{
        return false;
      }
    } return false;
  }
  public boolean removeQueen(int r, int c) {
    if (r < board.length && c < board.length) {
      if (board[r][c] == -1) {
        board[r][c]++; //remove the queen
        unthreat(r,c); //remove the threatened.
        return true;
      }else {
        return false;
      }
    } return false;
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
        if (board[i][j] == 0) out += "_ ";
        if (board[i][j] == -1) out += "Q ";
        //z
        if (board[i][j] > 0) out += "" + board[i][j] + " ";
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
  public boolean solve(){
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j] != 0) throw IllegalStateException("This board is not empty!");
      }
    }
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  //public int countSolutions(){}
  }
