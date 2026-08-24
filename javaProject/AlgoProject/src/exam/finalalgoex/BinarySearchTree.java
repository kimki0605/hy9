package exam.finalalgoex;

import java.util.Comparator;

public class BinarySearchTree<E> {

    private Node<E> root;
    private int size;
    private final Comparator<? super E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.root = null;
        this.size = 0;
    }

    public boolean add(E value) {

        if (comparator == null) {
            return addUsingComparable(value) == null;
        }

        return addUsingComparator(value, comparator) == null;
    }

    private E addUsingComparable(E value) {

        Node<E> current = root;
        Node<E> currentParent;

        @SuppressWarnings("unchecked")
        Comparable<? super E> compValue =
                (Comparable<? super E>) value;

        int compResult;

        if (current == null) {
            root = new Node<E>(value);
            size++;
            return null;
        }

        do {
            currentParent = current;

            compResult = compValue.compareTo(current.value);

            if (compResult < 0) {
                current = current.left;
            } else if (compResult > 0) {
                current = current.right;
            } else {
                return value;
            }

        } while (current != null);

        Node<E> newNode =
                new Node<E>(value, currentParent);

        if (compResult < 0) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }

        size++;

        return null;
    }

    private E addUsingComparator(
            E value,
            Comparator<? super E> comp) {

        Node<E> current = root;
        Node<E> currentParent;

        int compResult;

        if (current == null) {
            root = new Node<E>(value);
            size++;
            return null;
        }

        do {
            currentParent = current;

            compResult = comp.compare(value, current.value);

            if (compResult < 0) {
                current = current.left;
            } else if (compResult > 0) {
                current = current.right;
            } else {
                return value;
            }

        } while (current != null);

        Node<E> newNode =
                new Node<E>(value, currentParent);

        if (compResult < 0) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }

        size++;

        return null;
    }

    // 검색
    public E search(E value) {

        if (comparator == null) {

            @SuppressWarnings("unchecked")
            Comparable<? super E> compValue =
                    (Comparable<? super E>) value;

            Node<E> current = root;

            while (current != null) {

                int result =
                        compValue.compareTo(current.value);

                if (result < 0) {
                    current = current.left;
                } else if (result > 0) {
                    current = current.right;
                } else {
                    return current.value;
                }
            }

        } else {

            Node<E> current = root;

            while (current != null) {

                int result =
                        comparator.compare(value, current.value);

                if (result < 0) {
                    current = current.left;
                } else if (result > 0) {
                    current = current.right;
                } else {
                    return current.value;
                }
            }
        }

        return null;
    }

    // contains
    public boolean contains(Object o) {

        if (comparator == null) {
            return containsUsingComparable(o);
        }

        return containsUsingComparator(o, comparator);
    }

    private boolean containsUsingComparable(Object o) {

        @SuppressWarnings("unchecked")
        Comparable<? super E> value =
                (Comparable<? super E>) o;

        Node<E> node = root;

        while (node != null) {

            int result = value.compareTo(node.value);

            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    private boolean containsUsingComparator(
            Object o,
            Comparator<? super E> comp) {

        E value = (E) o;

        Node<E> node = root;

        while (node != null) {

            int result =
                    comp.compare(value, node.value);

            if (result < 0) {
                node = node.left;
            } else if (result > 0) {
                node = node.right;
            } else {
                return true;
            }
        }

        return false;
    }

    // 삭제
    public E remove(E value) {

        Node<E> parent = null;
        Node<E> current = root;
        boolean isLeftChild = false;

        while (current != null) {

            int result;

            if (comparator == null) {

                @SuppressWarnings("unchecked")
                Comparable<? super E> compValue =
                        (Comparable<? super E>) value;

                result = compValue.compareTo(current.value);

            } else {
                result =
                        comparator.compare(value, current.value);
            }

            if (result == 0) {
                break;
            }

            parent = current;

            if (result < 0) {
                isLeftChild = true;
                current = current.left;
            } else {
                isLeftChild = false;
                current = current.right;
            }
        }

        if (current == null) {
            return null;
        }

        // 자식이 없는 경우
        if (current.left == null && current.right == null) {

            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // 왼쪽 자식만 있는 경우
        else if (current.right == null) {

            if (current == root) {
                root = current.left;
            } else if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        }

        // 오른쪽 자식만 있는 경우
        else if (current.left == null) {

            if (current == root) {
                root = current.right;
            } else if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        }

        // 자식이 둘인 경우
        else {

            Node<E> successorParent = current;
            Node<E> successor = current.right;

            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.value = successor.value;

            if (successorParent.left == successor) {
                successorParent.left = successor.right;
            } else {
                successorParent.right = successor.right;
            }
        }

        size--;

        return value;
    }

    // 전위 순회
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node<E> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");

        preorder(node.left);
        preorder(node.right);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }
}