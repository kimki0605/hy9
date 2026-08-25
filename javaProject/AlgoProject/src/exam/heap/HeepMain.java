package exam.heap;

import java.util.Arrays;

public class HeapMain {

    public static void main(String[] args) {

        Heap<Integer> heap = new Heap<>();

        heap.add(10);
        heap.add(3);
        heap.add(23);
        heap.add(44);
        heap.add(19);
        heap.add(35);
        heap.add(47);
        heap.add(80);
        heap.add(35);
        heap.add(60);

        // 가장 작은 값 출력
        System.out.println(heap.peek());

        // 현재 Heap 배열 출력
        System.out.println(Arrays.toString(heap.toArray()));

        // 하나씩 삭제하면서 출력
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.print(heap.remove() + " ");
        System.out.println(heap.remove());


        System.out.println("\n========== sort 테스트 ==========");

        Integer[] numbers = {
                10, 3, 23, 44, 19,
                35, 47, 80, 35, 60
        };

        Heap<Integer> sortHeap = new Heap<>();

        Integer[] result = sortHeap.sort(numbers);

        System.out.println(Arrays.toString(result));
    }
}