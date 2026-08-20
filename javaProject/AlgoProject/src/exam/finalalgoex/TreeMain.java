package exam.finalalgoex;

public class TreeMain {

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree =
                new BinarySearchTree<>();

        tree.add(12);
        tree.add(40);
        tree.add(7);
        tree.add(16);
        tree.add(1);
        tree.add(14);
        tree.add(17);
        tree.add(29);
        tree.add(55);
        tree.add(61);

        System.out.println("노드 개수 : " + tree.size());

        System.out.println("40 존재? : " + tree.contains(40));

        tree.remove(40);

        System.out.println("40 삭제 후 존재? : " + tree.contains(40));

        System.out.println("노드 개수 : " + tree.size());
    }
}