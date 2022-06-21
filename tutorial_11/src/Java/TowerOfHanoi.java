import java.util.Scanner;
import java.util.ArrayList;

public class TowerOfHanoi {
  String name;
  ArrayList[] peg;
  int numDiscs;

  public TowerOfHanoi(String name, int n) {
    this.name = name;
    this.numDiscs = n;
    this.peg = new ArrayList[3];
    // Write your code here
    ArrayList<Integer> sourcePeg = new ArrayList<Integer>();
    ArrayList<Integer> intermediatePeg = new ArrayList<Integer>();
    ArrayList<Integer> destinationPeg = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      sourcePeg.add(i);
      peg[0] = sourcePeg;
      peg[1] = intermediatePeg;
      peg[2] = destinationPeg;
    }
  }

  private void moveDisc(int src, int des) {
    // Write your code here
    peg[des].add((int) peg[src].get(peg[src].size() - 1));
    peg[src].remove((int) peg[src].get(peg[src].size() - 1));
    printTower();
  }

  public void printTower() {
    // Write your code here
    System.out.println(peg);
  }

  public void makeMoves(int n, int src, int des, int aux) {
    if (n <= 0) return;
    makeMoves(n-1, src, aux, des);
    moveDisc(src, des);
    makeMoves(n-1, aux, des, src);
    return;
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number of disks: ");
    int n = input.nextInt();
    TowerOfHanoi t = new TowerOfHanoi("Hanoi", n);
    t.printTower();
    t.makeMoves( n, 0, 2, 1 );
  }
}
  