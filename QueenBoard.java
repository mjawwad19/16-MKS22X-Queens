public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
}

private void threaten(int r, int c) {
  for (int i = 0; i < r; i++) {
    for (int j = 0; j < c; j++) {
      board[i][j]
    }
  }
}
private boolean addQueen(int r, int c) {
  if (board[r][c] == 0) {
    board[r][c] = -1;
    return true;
  }
}
private boolean removeQueen(int r, int c)


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
    }
    out += "\n";
  }
  return out;
}
}
