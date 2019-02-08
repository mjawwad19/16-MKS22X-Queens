public class Driver{
  public static void main(String[] args) {
    QueenBoard m = new QueenBoard(9);
    //System.out.println(m);
    /*m.addQueen(4,4);
    System.out.println(m);
    m.addQueen(1,8);
    System.out.println(m);
    //m.removeQueen(4,4); // should also remove threatened by the queen @ 4,4
    System.out.println(m);*/
    m.solve();
    System.out.println(m);
    System.out.println(m.countSolutions()); //46 F 352 all
    QueenBoard a = new QueenBoard(0);
    System.out.println(a.countSolutions()); //0 0
    QueenBoard b = new QueenBoard(1);
    System.out.println(b.countSolutions());//1 1
    QueenBoard c = new QueenBoard(2);
    System.out.println(c.countSolutions());//0 0
    QueenBoard d = new QueenBoard(3);
    System.out.println(d.countSolutions());//0 0
    QueenBoard e = new QueenBoard(4);
    System.out.println(e.countSolutions());//1 2
    QueenBoard f = new QueenBoard(5);
    System.out.println(f.countSolutions());//2 10
    QueenBoard g = new QueenBoard(6);
    System.out.println(g.countSolutions());//1 4

  }
}
