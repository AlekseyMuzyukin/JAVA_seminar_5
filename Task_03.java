import java.util.Arrays;
import java.util.Random;

public class Task_03 {
    public static void main(String[] args) {
        int size = 10;
        int maxVal = 100;
        int[] arr = new int[size];
        FillArray(arr, maxVal);
        System.out.println(Arrays.toString(arr));
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void HeapSort(int arr[]) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--)
            NodeHeap(arr, len, i);
        for (int i = len - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            NodeHeap(arr, i, 0);
        }
    }

    public static void ArrayHeap(int arr[], int maxIndex) {
        int start = (maxIndex / 2) - 1;
        for (int i = start; i >= 0; i--) {
            NodeHeap(arr, maxIndex, i);
        }
    }

    public static void NodeHeap(int[] arr, int maxNodeIndex, int i) {
        int nodeIndex = i;
        int left = 2 * nodeIndex + 1;
        int right = 2 * nodeIndex + 2;
        if (left < maxNodeIndex && arr[left] > arr[nodeIndex])
            nodeIndex = left;
        if (right < maxNodeIndex && arr[right] > arr[nodeIndex])
            nodeIndex = right;
        if (nodeIndex != i) {
            int tmp = arr[i];
            arr[i] = arr[nodeIndex];
            arr[nodeIndex] = tmp;
            NodeHeap(arr, maxNodeIndex, nodeIndex);
        }
    }

    public static void FillArray(int[] arr, int maxVal) {
        Random rand = new Random();
        int s = arr.length;
        for (int i = 0; i < s; i++) {
            arr[i] = rand.nextInt(maxVal);
        }
    }
}
