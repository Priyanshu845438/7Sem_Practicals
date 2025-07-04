// Program: Quick Sort with Iteration Logging

package HPC;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    // List to store logs of each iteration
    static List<String> logs = new ArrayList<>();

    // Main QuickSort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // partition index
            logs.add("Pivot " + arr[pi] + " placed at index " + pi);
            logs.add("Array after pivot placed: " + Arrays.toString(arr));
            logs.add("-------------------------------------------");

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);        // left subarray
            quickSort(arr, pi + 1, high);       // right subarray
        }
    }

    // Partition function
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];     // choose last element as pivot
        logs.add("Choosing pivot: " + pivot + " (index " + high + ")");
        
        int i = low - 1;           // index of smaller element

        for (int j = low; j < high; j++) {
            logs.add("Comparing: arr[" + j + "] = " + arr[j] + " with pivot " + pivot);
            if (arr[j] <= pivot) {
                i++;
                logs.add(" --> Swapping arr[" + i + "] = " + arr[i] + " and arr[" + j + "] = " + arr[j]);
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                logs.add("     Array after swap: " + Arrays.toString(arr));
            }
        }

        // Final swap: put pivot in the correct position
        logs.add("Swapping pivot with arr[" + (i + 1) + "] = " + arr[i + 1]);
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        logs.add("     Array after placing pivot: " + Arrays.toString(arr));
        
        return i + 1;
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("----------- Iteration Steps -----------");
        for (String step : logs) {
            System.out.println(step);
        }

        System.out.println("----------- Final Sorted Array -----------");
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
