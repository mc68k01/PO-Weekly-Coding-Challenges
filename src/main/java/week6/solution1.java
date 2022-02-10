package week6;

import java.util.ArrayList;
import java.util.List;

public class solution1 {
    public static boolean ascending(String aString) {
        // we will assume all numbers are ascending
        // and disprove this assumption with a counter example
        boolean ascending = true;
        // this list stores the sizes of the subsets we can break up each string into
        List<Integer> l = new ArrayList<>();

        // if the string is of an odd size, the numbers cannot be even
        if (aString.length() %2==1){
            ascending = false;
            System.out.print(aString + " is oddly sized.");
        }
        // if the string is of size 2, then we can only test the first and second digits
        else if (aString.length() ==2) {
            if (Integer.parseInt(aString.substring(0,1)) > Integer.parseInt(aString.substring(1))  ){
                ascending = false;
            }
        }
        // if the string is larger than size 2, we can test for other substrings
        else if (aString.length() >2) {
            for (int i = 2; i < aString.length(); i++) {
                if (aString.length() % i == 0) {
                    l.add(i);
                }
            }
        }

        // iterate over the list of subset sizes
        for (int i = 0; i < l.size(); i++) {
//            System.out.println(aString + " is evenly divided by: " + l.get(i));
            // compare each subset term to the next subset of numbers
            for (int j = 0; j < l.size(); j+=l.get(i)){
                if(Integer.parseInt(aString.substring(j,j+l.get(i))) > Integer.parseInt(aString.substring(j+l.get(i), j+2*l.get(i)))){
                    ascending = false;
                }
            }
            if (ascending==false) {
                System.out.print(aString + " is NOT ascending for " + l.get(i) +"\n");
            }
//            System.out.println("");
        }
        System.out.println("");
        return ascending;
    }
    public static void main(String[]args) {
        String[] problem1 = {"232425", "2324256", "444445", "9865", "333222"};
        for (int i = 0; i < problem1.length; i++) {
            System.out.println(problem1[i] + ": " + ascending(problem1[i]) + "\n");
        }
    }
}
