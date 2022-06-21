package Java;

import java.util.Scanner;
import java.util.ArrayList;

public class TowerOfHanoi {
  String name;
  ArrayList[] peg;
  int numDiscs;

  public TowerOfHanoi(String name, int n){
    this.name= name;
    this.numDiscs= n;
    this.peg= new ArrayList[3];
    for (int i=0; i<3; i++){
      this.peg[i]= new ArrayList();
    }
    for (int i=0; i<n; i++){
      this.peg[0].add(i);
    }
  }

  private void moveDisc(int src, int des){
    int idx= this.peg[src].size()-1;
    Integer disc= (Integer) this.peg[src].remove(idx); //In python, this translates to peg[src].pop(idx)
    this.peg[des].add(disc);
    printTower();
  }

  public void printTower(){
    for (int i=0; i<3; i++){
      System.out.print("[");
      for (int j=0; j<this.peg[i].size(); j++){
        System.out.print(this.peg[i].get(j)+" ");
      }
      System.out.print("]");
      if (i!=2) System.out.print(", ");

    }
    System.out.println(); //prints a spacing
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