package ArrayQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayPart1 {
    ArrayList<Integer> arr;

    public ArrayPart1(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public void run() {
        System.out.println("\t>> Is Array Sorted :: " + isArraySorted(arr) + "\n");
        if(isArraySorted(arr)) {
            System.out.println("\t>> After removing duplicates");
            System.out.println("\t   Number of unique elements :: " + removeDuplicatesFromSortedArray(arr));
            System.out.println("\t   and the array is :: " + arr + "\n");
        }
        arr = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3,4,5,6,7,7));
        if(isArraySorted(arr)) {
            System.out.println("\t>> After removing duplicates (Clean code)");
            System.out.println("\t   Number of unique elements :: " + removeDuplicatesFromSortedArrayClean(arr));
            System.out.println("\t   and the array is :: " + arr + "\n");
        }
        System.out.println("\t>> Largest Element is :: " + largestElem(arr) + "\n");
        System.out.println("\t>> Second Largest Element is (Using brute):: " + secondLargestBrute(arr) + "\n");
        System.out.println("\t>> Second Largest Element is  (Better Approach):: " + secondLargestBetter(arr) + "\n");
        System.out.println("\t>> Second Largest Element is (Optimal):: " + secondLargestOptimal(arr) + "\n");
        System.out.println("\t>> Ninja Second Order is:: " + ninjaSecondOrder(arr) + "\n");

    }

    public static int removeDuplicatesFromSortedArrayClean(ArrayList<Integer> arr) {
        int fillUpPos = 0;
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i) != arr.get(fillUpPos)) {
                arr.set(fillUpPos+1, arr.get(i));
                fillUpPos++;
            }
        }

        return fillUpPos+1;
    }
    public static int removeDuplicatesFromSortedArray(ArrayList<Integer> arr) {

        int prevElem = arr.get(0);
        int fillUpPos = 1;
        int i = 1;
        while (i < arr.size()){
            if(arr.get(i) == prevElem) {
                while (i+1 < arr.size() && arr.get(i+1) == prevElem) i++;
                if(i+1 < arr.size()) {
                    arr.set(fillUpPos, arr.get(i + 1));
                    prevElem = arr.get(i + 1);
                    fillUpPos++;
                }
            } else {
                prevElem = arr.get(i);
                fillUpPos++;
            }
            i++;
        }
        return fillUpPos;
    }

    public static int largestElem(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int j : arr) {
            if (j > max) max = j;
        }
        return max;
    }

    public static int secondLargestBrute(ArrayList<Integer> arr) {
        Collections.sort(arr);
        int max = arr.get(arr.size() - 1);
        for (int i = arr.size()-1; i >= 0; i--) {
            if (arr.get(i) < max) return arr.get(i);
        }

        return -1;
    }

    public static int secondLargestBetter(ArrayList<Integer> arr) {
        int max = largestElem(arr);

        int secondLargest = -1;
        for (int i: arr) {
            if(i != max && i > secondLargest) secondLargest = i;
        }
        return secondLargest;
    }

    public static int secondLargestOptimal(ArrayList<Integer> arr) {
        int largest = arr.get(0), secondLargest = -1;

        for(int i: arr) {
            if(i > largest) {
                secondLargest = largest;
                largest = i;
            } else if(i < largest && i > secondLargest) secondLargest = i;
        }
        return secondLargest;
    }

    public static int secondSmallestBetter(ArrayList<Integer> arr) {
        int smallest = arr.get(0);
        for (int i : arr) if( i < smallest ) smallest = i;

        int secSmallest = Integer.MAX_VALUE;
        for (int i : arr) {
            if ( i != smallest && i < secSmallest ) secSmallest = i;
        }
        return secSmallest;
    }

    public static int secondSmallestOptimal(ArrayList<Integer> arr) {
        int smallest = arr.get(0);
        int secSmallest = Integer.MAX_VALUE;
        for (int i : arr)  {
            if ( i < smallest) {
                secSmallest = smallest;
                smallest = i;
            } else if(i > smallest && i < secSmallest) {
                secSmallest = i;
            }
        }
        return secSmallest;
    }

    public static ArrayList<Integer> ninjaSecondOrder(ArrayList<Integer> arr) {
        int slargest = secondLargestOptimal(arr);
        int ssmallest = secondSmallestOptimal(arr);
        return new ArrayList<>(Arrays.asList(slargest, ssmallest));
    }

    public static boolean isArraySorted(ArrayList<Integer> arr) {
        int prevElem = arr.get(0);
        for (int i : arr) {
            if (i < prevElem) return false;
            prevElem = i;
        }
        return true;
    }
}