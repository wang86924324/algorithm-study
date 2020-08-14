package homework.week2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
    private static final int d = 2;
    private int[] heap;
    private int heapSize;

    public BinaryHeap(int capocity) {
        heapSize = 0;
        heap = new int[capocity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return (i - 1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    public void insert(int x) {
        if (isFull()) throw new NoSuchElementException("heap is full,no space to insert element");
        // 尾部插入
        heap[heapSize++] = x;
        // 调整插入元素的位置
        // todo
    }

    public int delete(int x) {
        if (isEmpty()) throw new NoSuchElementException("heap is empty,no element to deleted");

        int maxElement = heap[x];
        // 尾部节点放到x的位置，然后往下移动
        heap[x] = heap[heapSize - 1];
        heapSize--;
        return maxElement;
    }


    private void heapifyUp(int i) {
        int insertValue = heap[i];
        // 比插入元素小的元素往下移动
        while (i > 0 && heap[parent(i)] < insertValue) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }

        heap[i] = insertValue;
    }

    // 背景：i位置的元素需要往下移动
    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (kthChild(i, 1) < heapSize) {

        }
    }


}
