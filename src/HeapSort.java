/**
 *
 * @author Patrick Mulvihill
 * CMPT 438: Algorithms
 * Dr. Tian
 * Project 4
 * pmulvihill01@manhattan.edu
 * github.com/PatMulvihill/HeapSort
 */
import java.util.Arrays;
public class HeapSort {
    
    static int heap_size;
    
    public static void buildMaxHeap (int[] A) {
//        int n = A.length - 1;
        heap_size = A.length - 1;
        for (int i = (heap_size / 2); i >= 0; i--) {
            maxHeapify(A, i);
        }
    }
    
    public static void maxHeapify (int[] A, int i) {
        int largest;
        int l = 2 * i;
        int r = (2 * i) + 1;
        if (l <= heap_size && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if ( r <= heap_size && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(A, i, largest);
            maxHeapify(A, largest);
        }
    }
    
    public static void heapSort (int[] A) {
        buildMaxHeap(A);
        for (int i = A.length - 1; i > 0; i--) {
            swap(A, 1, i);
            heap_size -= 1;
            maxHeapify(A, 1);
        }
    }

    public static void swap(int A[], int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp; 
    }   

    public static void main(String[] args) {
        int[] testArr1 = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        System.out.println("Before HeapSort: testArr1 = " + Arrays.toString(testArr1));
        heapSort(testArr1);
        System.out.println("After HeapSort: testArr1 = " + Arrays.toString(testArr1));
        int[] testArr2 = {-15, 10, 3, 25, -2, 1, 14, 4, 19, 8};
        System.out.println("\nBefore HeapSort: testArr2 = " + Arrays.toString(testArr2));
        heapSort(testArr2);
        System.out.println("After HeapSort: testArr2 = " + Arrays.toString(testArr2));
    }    
}
