package prevK;

public class heap {
    // t347中使用到了堆，在这里复习一下堆
    public int[] elem; // 创建数组对象
    public heap(){
        elem = new int[20];
    }

    // 初始化数组
    public void init(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            elem[i] = arr[i];
        }
    }

    // 维护大根堆的性质
    public void maxHeapify(int len, int idx){
        int largest = idx;
        int lson = idx * 2 + 1;
        int rson = idx * 2 + 2;
        if (lson < len && elem[largest] < elem[lson]){
            largest = lson;
        }
        if (rson < len && elem[largest] < elem[rson]){
            largest = rson;
        }
        if (largest != idx){
            int tmp = elem[largest];
            elem[largest] = elem[idx];
            elem[idx] = tmp;
            maxHeapify(len, largest);
        }
    }

    // 创建一个大根堆的方法
    public void createMaxHeap(int len){
        for (int i = (len / 2) - 1; i >= 0; i--){
            maxHeapify(len, i);
        }
    }

    // 利用大根堆从小到大进行排序
    // 需要从大到小排序需要使用小根堆
    public void maxHeapSort(int len){
        // 排序
        for (int i = len - 1; i > 0; i--){
            // 交换堆顶和最后一个元素
            int tmp = elem[i];
            elem[i] = elem[0];
            elem[0] = tmp;
            maxHeapify(i, 0);
        }
    }

    // 维护小根堆的性质
    public void minHeapify(int len, int idx){
        int min = idx;
        int lson = idx * 2 + 1;
        int rson = idx * 2 + 2;
        if (lson < len && elem[min] > elem[lson]){
            min = lson;
        }
        if (rson < len && elem[min] > elem[rson]){
            min = rson;
        }
        if (min != idx){
            int tmp = elem[min];
            elem[min] = elem[idx];
            elem[idx] = tmp;
            minHeapify(len, min);
        }
    }

    // 创建一个小根堆的方法
    public void createMinHeap(int len){
        for (int i = (len / 2) - 1; i >= 0; i--){
            minHeapify(len, i);
        }
    }

    // 利用大根堆从小到大进行排序
    // 需要从大到小排序需要使用小根堆
    public void minHeapSort(int len){
        // 排序
        for (int i = len - 1; i > 0; i--){
            // 交换堆顶和最后一个元素
            int tmp = elem[i];
            elem[i] = elem[0];
            elem[0] = tmp;
            minHeapify(i, 0);
        }
    }
}
