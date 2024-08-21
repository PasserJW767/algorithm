package prevK;

import java.util.Arrays;

public class heapMain {
    public static void main(String[] args) {
        heap max_heap = new heap();
        max_heap.init(new int[]{5, 9, 4, 2, 1, 3, 6, 8, 0});
        System.out.println("Arrays: " + Arrays.toString(max_heap.elem));
        max_heap.createMaxHeap(9);
        System.out.println("Create Max Heap: " + Arrays.toString(max_heap.elem));
        max_heap.maxHeapSort(9);
        System.out.println("Max Heap Sort: " + Arrays.toString(max_heap.elem));

        System.out.println("------------------------------------------------------");

        heap min_heap = new heap();
        min_heap.init(new int[]{5, 9, 4, 2, 1, 3, 6, 8, 0});
        System.out.println("Arrays: " + Arrays.toString(min_heap.elem));
        min_heap.createMinHeap(9);
        System.out.println("Create Min Heap: " + Arrays.toString(min_heap.elem));
        min_heap.minHeapSort(9);
        System.out.println("Min Heap Sort: " + Arrays.toString(min_heap.elem));
    }
}
