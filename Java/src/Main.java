import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList[] peg;
        peg = new ArrayList[3];
        ArrayList<Integer> positionZeroArrayList = new ArrayList<Integer>();
        ArrayList<Integer> positionOneArrayList = new ArrayList<Integer>();
        ArrayList<Integer> positionTwoArrayList = new ArrayList<Integer>();

        for (int i = 0; i < 3; i++) {
            positionZeroArrayList.add(i);
        }

        peg[0] = positionZeroArrayList;
        peg[1] = positionOneArrayList;
        peg[2] = positionTwoArrayList;

        peg[1].add((int) peg[0].get(peg[0].size() - 1));
        peg[0].remove((int) peg[0].get(peg[0].size() - 1));

        System.out.println(Arrays.toString(peg));

        peg[1].add((int) peg[0].get(peg[0].size() - 1));
        peg[0].remove((int) peg[0].get(peg[0].size() - 1));

        System.out.println(Arrays.toString(peg));
    }
}