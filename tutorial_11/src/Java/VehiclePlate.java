package Java;

import java.lang.*;

public class VehiclePlate {
    public static int[] processPrefix(String prefix) {
        int prefixLength = 2;
        char[] charPrefixArray = prefix.toCharArray();
        int[] intPrefixArray = new int[prefix.length()];
        int[] prefixResultArray = new int[prefixLength];

        for (int i = 0; i < prefix.length(); i++) {
            intPrefixArray[i] = (int) charPrefixArray[i] - 64;
        }

        if (prefix.length() == 1) {
            prefixResultArray[0] = 0;
            prefixResultArray[1] = intPrefixArray[0];
        } else if (prefix.length() == 2) {
            prefixResultArray[0] = intPrefixArray[0];
            prefixResultArray[1] = intPrefixArray[1];
        } else if (prefix.length() == 3) {
            prefixResultArray[0] = intPrefixArray[1];
            prefixResultArray[1] = intPrefixArray[2];
        }
    return prefixResultArray;
    }

    public static int[] processSuffix(int suffix) {
        int suffixLength = 4;
        String stringSuffix = Integer.toString(suffix);
        char[] charSuffixArray = stringSuffix.toCharArray();
        int[] intPrefixArray = new int[stringSuffix.length()];
        int[] suffixResultArray = new int[suffixLength];

        for (int i = 0; i < stringSuffix.length(); i++) {
            intPrefixArray[i] = (int) charSuffixArray[i] - 48;
        }

        if (stringSuffix.length() == 1) {
            suffixResultArray[0] = 0;
            suffixResultArray[1] = 0;
            suffixResultArray[2] = 0;
            suffixResultArray[3] = intPrefixArray[0];
        } else if (stringSuffix.length() == 2) {
            suffixResultArray[0] = 0;
            suffixResultArray[1] = 0;
            suffixResultArray[2] = intPrefixArray[0];
            suffixResultArray[3] = intPrefixArray[1];
        } else if (stringSuffix.length() == 3) {
            suffixResultArray[0] = 0;
            suffixResultArray[1] = intPrefixArray[0];
            suffixResultArray[2] = intPrefixArray[1];
            suffixResultArray[3] = intPrefixArray[2];
        } else if (stringSuffix.length() == 4) {
            suffixResultArray[0] = intPrefixArray[0];
            suffixResultArray[1] = intPrefixArray[1];
            suffixResultArray[2] = intPrefixArray[2];
            suffixResultArray[3] = intPrefixArray[3];
        }
        return suffixResultArray;
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }

    public static char generateCheckSum(String prefix, int suffix) {
        int mergedLength = 6;
        int[] mergedList = new int[mergedLength];
        mergedList = mergeArray(processPrefix(prefix), processSuffix(suffix));

        int result = 0;
        result = (mergedList[0]*9 + mergedList[1]*4 + mergedList[2]*5 + mergedList[3]*4 + mergedList[4]*3
                + mergedList[5]*2)%19;

        String[] referenceList = {"A", "Z", "Y", "X", "U", "T", "S", "R", "P", "M", "L", "K", "J", "H", "G", "E", "D"
                , "C", "B"};

        return referenceList[result].charAt(0);
    }

    public static void main(String[] args){
        System.out.println(generateCheckSum("SS", 11));
    }
}
