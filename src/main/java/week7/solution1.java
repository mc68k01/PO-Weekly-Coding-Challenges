package week7;

/*
Create a function that takes the memory size (ms is a string type) as an argument and returns the actual memory size.

Examples
    actualMemorySize("32GB") --> "29.76GB"
    actualMemorySize("2GB") --> "1.86GB"
    actualMemorySize("512MB") --> "476MB"
Notes
    -The actual storage loss on a USB device is 7% of the overall memory size!
    -If the actual memory size was greater than 1 GB, round your result to two decimal places.
    -If the memory size after adjustment is smaller then 1 GB, return the result in MB.
 */
public class solution1 {
    static double memLoss = 0.93;

    public static void actualMemorySize(String memorySize) {
        if (memorySize.contains("GB")) {
            double actualMem = Integer.parseInt(memorySize.substring(0,memorySize.indexOf("G"))) * memLoss;
            System.out.printf("%.2fGB%n", actualMem);
        }
        else if (memorySize.contains("MB")) {
            double actualMem = Integer.parseInt(memorySize.substring(0,memorySize.indexOf("M"))) * memLoss;
            System.out.printf("%.2fMB%n", actualMem);
        }
        else if (memorySize.contains("KB")) {
            double actualMem = Integer.parseInt(memorySize.substring(0,memorySize.indexOf("K"))) * memLoss;
            System.out.printf("%.2fKB%n", actualMem);
        }
    }
    public static void main(String[] args) {
        String[] list = {"1024GB","32GB", "512MB", "256KB"};
        for (String s : list) {
            actualMemorySize(s);
        }
    }
}
