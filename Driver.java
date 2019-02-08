public class Driver{
  public static void main(String[] args) {
    QueenBoard m = new QueenBoard(9);
    System.out.println(m);
    m.addQueen(4,4);
    System.out.println(m);
    m.addQueen(1,8);
    System.out.println(m);
    //m.removeQueen(4,4); // should also remove threatened by the queen @ 4,4
    System.out.println(m);
  }
}
