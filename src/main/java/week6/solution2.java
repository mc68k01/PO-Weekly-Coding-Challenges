package week6;

public class solution2 {

    public static void squarePatch(int n) {
        StringBuilder row = new StringBuilder("[]");
        int offset = 1;
        if(n==0) {
            System.out.println(row);
        }
        else {
            for(int i = 0; i < n; i++) {
                row.insert(offset,n);
                if (i<n-1) {
                    row.insert(offset+1,",");
                }
                offset+=Integer.toString(n).length()+1;
            }
            for (int i =0; i < n; i++) {
                System.out.println(row);
            }
        }
    }
    public static void main(String[] args) {
        int[] test = {0,1,2,3,4,5};
        for (int i:test) {
            squarePatch(i);
        }
    }
}
