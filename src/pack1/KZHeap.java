package pack1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class KZHeap<T> implements KZQueue<T> {
    private ArrayList<T> heap;
    private Comparator<T> comparator;

    public KZHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void heapifyUp(int i) {
        while (i > 0 && comparator.compare(heap.get(parent(i)), heap.get(i)) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        if (left < size() && comparator.compare(heap.get(left), heap.get(maxIndex)) > 0) {
            maxIndex = left;
        }
        int right = rightChild(i);
        if (right < size() && comparator.compare(heap.get(right), heap.get(maxIndex)) > 0) {
            maxIndex = right;
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    @Override
    public void addSong(T element) {
        heap.add(element);
        heapifyUp(size() - 1);
    }
    
    public void add(T element) {
        heap.add(element);
        heapifyUp(size() - 1);
    }

    @Override
    public void deleteAll() {
        heap.clear();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public T peekSong() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    @Override
    public void pushSong(T element) {
        addSong(element);
    }

    @Override
    public T removeSong() {
        T result = peekSong();
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        heapifyDown(0);
        return result;
    }
    
    public T remove() {
        T result = peekSong();
        heap.set(0, heap.get(size() - 1));
        heap.remove(size() - 1);
        heapifyDown(0);
        return result;
    }

    @Override
    public int size() {
        return heap.size();
    }

}

