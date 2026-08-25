package exam.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {

    private final Comparator<? super E> comparator;
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    private Object[] array;

    // 생성자
    public Heap() {
        this(null);
    }

    public Heap(Comparator<? super E> comparator) {
        this.array = new Object[DEFAULT_CAPACITY + 1];
        this.size = 0;
        this.comparator = comparator;
    }

    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = new Object[capacity + 1];
        this.size = 0;
        this.comparator = comparator;
    }

    // 부모 노드 인덱스
    private int getParent(int index) {
        return index / 2;
    }

    // 왼쪽 자식 노드 인덱스
    private int getLeftChild(int index) {
        return index * 2;
    }

    // 오른쪽 자식 노드 인덱스
    private int getRightChild(int index) {
        return index * 2 + 1;
    }

    // 배열 크기 변경
    private void resize(int newCapacity) {

        Object[] newArray = new Object[newCapacity + 1];

        for (int i = 1; i <= size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    // 데이터 추가
    public void add(E value) {

        // 배열이 꽉 찬 경우 크기 증가
        if (size + 1 >= array.length) {
            resize(array.length * 2);
        }

        siftUp(size + 1, value);
        size++;
    }

    // 상향 정렬
    private void siftUp(int idx, E target) {

        if (comparator != null) {
            siftUpComparator(idx, target, comparator);
        } else {
            siftUpComparable(idx, target);
        }
    }

    // Comparator를 이용한 상향 정렬
    @SuppressWarnings("unchecked")
    private void siftUpComparator(int idx, E target,
            Comparator<? super E> comp) {

        while (idx > 1) {

            int parent = getParent(idx);
            Object parentVal = array[parent];

            if (comp.compare(target, (E) parentVal) >= 0) {
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = target;
    }

    // Comparable을 이용한 상향 정렬
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target) {

        Comparable<? super E> comp =
                (Comparable<? super E>) target;

        while (idx > 1) {

            int parent = getParent(idx);
            Object parentVal = array[parent];

            if (comp.compareTo((E) parentVal) >= 0) {
                break;
            }

            array[idx] = parentVal;
            idx = parent;
        }

        array[idx] = target;
    }

    // 루트 데이터 삭제
    @SuppressWarnings("unchecked")
    public E remove() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        E result = (E) array[1];

        // 마지막 요소
        E target = (E) array[size];

        // 마지막 요소 삭제
        array[size] = null;
        size--;

        // 요소가 남아있으면 재정렬
        if (size > 0) {
            siftDown(1, target);
        }

        // 배열 크기 줄이기
        if (array.length > DEFAULT_CAPACITY + 1
                && size < array.length / 4) {

            resize(Math.max(DEFAULT_CAPACITY, array.length / 2));
        }

        return result;
    }

    // 하향 정렬
    private void siftDown(int idx, E target) {

        if (comparator != null) {
            siftDownComparator(idx, target, comparator);
        } else {
            siftDownComparable(idx, target);
        }
    }

    // Comparator를 이용한 하향 정렬
    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx, E target,
            Comparator<? super E> comp) {

        int parent = idx;

        while (getLeftChild(parent) <= size) {

            int child = getLeftChild(parent);
            int right = getRightChild(parent);

            // 오른쪽 자식이 더 작은 경우
            if (right <= size
                    && comp.compare((E) array[child],
                            (E) array[right]) > 0) {

                child = right;
            }

            // target이 자식보다 작거나 같으면 종료
            if (comp.compare(target, (E) array[child]) <= 0) {
                break;
            }

            array[parent] = array[child];
            parent = child;
        }

        array[parent] = target;
    }

    // Comparable을 이용한 하향 정렬
    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target) {

        Comparable<? super E> comp =
                (Comparable<? super E>) target;

        int parent = idx;

        while (getLeftChild(parent) <= size) {

            int child = getLeftChild(parent);
            int right = getRightChild(parent);

            // 오른쪽 자식이 왼쪽 자식보다 작은 경우
            if (right <= size
                    && ((Comparable<? super E>) array[child])
                            .compareTo((E) array[right]) > 0) {

                child = right;
            }

            // target이 자식보다 작거나 같으면 종료
            if (comp.compareTo((E) array[child]) <= 0) {
                break;
            }

            array[parent] = array[child];
            parent = child;
        }

        array[parent] = target;
    }

    // 요소 개수
    public int size() {
        return size;
    }

    // 루트 요소 확인
    @SuppressWarnings("unchecked")
    public E peek() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        return (E) array[1];
    }

    // 비어있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 배열로 변환
    public Object[] toArray() {
        return Arrays.copyOfRange(array, 1, size + 1);
    }

    // 배열을 전달받아 Heap 정렬 후 반환
    public E[] sort(E[] array) {

        Heap<E> heap = new Heap<>(comparator);

        // 배열의 모든 요소를 Heap에 추가
        for (E value : array) {
            heap.add(value);
        }

        // 작은 값부터 하나씩 꺼내서 배열에 저장
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.remove();
        }

        return array;
    }
}