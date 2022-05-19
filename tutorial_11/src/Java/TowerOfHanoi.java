package Java;

import java.util.Arrays;
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

    ArrayList<Integer> positionZeroArrayList = new ArrayList<Integer>();
    ArrayList<Integer> positionOneArrayList = new ArrayList<Integer>();
    ArrayList<Integer> positionTwoArrayList = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      positionZeroArrayList.add(i);

    this.peg[0] = positionZeroArrayList;
    this.peg[1] = positionOneArrayList;
    this.peg[2] = positionTwoArrayList;
    }
  }

  private void moveDisc(int src, int des) {
    peg[des].add((int) peg[src].get(peg[src].size() - 1));
    peg[src].remove((int) peg[src].get(peg[src].size() - 1));

  }

  public void printTower() {
    System.out.println(Arrays.toString(peg));
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