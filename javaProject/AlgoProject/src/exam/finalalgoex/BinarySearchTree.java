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

    // ================================
    // 노드 추가
    // ================================
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

            compResult =
                    compValue.compareTo(current.value);

            if (compResult < 0) {

                current = current.left;

            } else if (compResult > 0) {

                current = current.right;

            } else {

                return value;
            }

        } while (current != null);

        Node<E> newNode =
                new Node<>(value, currentParent);

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

            compResult =
                    comp.compare(value, current.value);

            if (compResult < 0) {

                current = current.left;

            } else if (compResult > 0) {

                current = current.right;

            } else {

                return value;
            }

        } while (current != null);

        Node<E> newNode =
                new Node<>(value, currentParent);

        if (compResult < 0) {
            currentParent.left = newNode;
        } else {
            currentParent.right = newNode;
        }

        size++;

        return null;
    }

    // ================================
    // 검색
    // ================================
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
                        comparator.compare(
                                value,
                                current.value);

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

    // ================================
    // 노드 삭제
    // ================================
    public E remove(E value) {

        if (comparator == null) {
            return removeUsingComparable(value);
        }

        return removeUsingComparator(
                value,
                comparator);
    }

    private E removeUsingComparable(E value) {

        Node<E> currentParent = null;
        Node<E> current = root;

        boolean hasLeft = false;

        int resComp;

        if (root == null) {
            return null;
        }

        @SuppressWarnings("unchecked")
        Comparable<? super E> compValue =
                (Comparable<? super E>) value;

        do {

            resComp =
                    compValue.compareTo(current.value);

            if (resComp == 0) {
                break;
            }

            currentParent = current;

            if (resComp < 0) {

                hasLeft = true;
                current = current.left;

            } else {

                hasLeft = false;
                current = current.right;
            }

        } while (current != null);

        if (current == null) {
            return null;
        }

        if (currentParent == null) {

            deleteNode(current);

            size--;

            return value;
        }

        if (hasLeft) {

            currentParent.left =
                    deleteNode(current);

        } else {

            currentParent.right =
                    deleteNode(current);
        }

        size--;

        return value;
    }

    private E removeUsingComparator(
            E value,
            Comparator<? super E> comp) {

        Node<E> currentParent = null;
        Node<E> current = root;

        boolean hasLeft = false;

        if (root == null) {
            return null;
        }

        while (current != null) {

            int result =
                    comp.compare(
                            value,
                            current.value);

            if (result == 0) {
                break;
            }

            currentParent = current;

            if (result < 0) {

                hasLeft = true;
                current = current.left;

            } else {

                hasLeft = false;
                current = current.right;
            }
        }

        if (current == null) {
            return null;
        }

        if (currentParent == null) {

            deleteNode(current);

        } else if (hasLeft) {

            currentParent.left =
                    deleteNode(current);

        } else {

            currentParent.right =
                    deleteNode(current);
        }

        size--;

        return value;
    }

    // ================================
    // 실제 노드 삭제
    // ================================
    private Node<E> deleteNode(
            Node<E> removeNode) {

        if (removeNode != null) {

            // 자식이 없는 경우
            if (removeNode.left == null
                    && removeNode.right == null) {

                if (removeNode == root) {
                    root = null;
                }

                return null;
            }

            // 자식이 양쪽에 있는 경우
            if (removeNode.left != null
                    && removeNode.right != null) {

                Node<E> replacement =
                        getSuccessorAndUnlink(
                                removeNode);

                removeNode.value =
                        replacement.value;

            } else if (removeNode.left != null) {

                if (removeNode == root) {

                    root = removeNode.left;

                    removeNode = root;

                } else {

                    removeNode =
                            removeNode.left;
                }

            } else {

                if (removeNode == root) {

                    root = removeNode.right;

                    removeNode = root;

                } else {

                    removeNode =
                            removeNode.right;
                }
            }
        }

        return removeNode;
    }

    // ================================
    // 후계자 찾기
    // ================================
    private Node<E> getSuccessorAndUnlink(
            Node<E> node) {

        Node<E> currentParent = node;
        Node<E> current = node.right;

        if (current.left == null) {

            currentParent.right =
                    current.right;

            current.right = null;

            return current;
        }

        while (current.left != null) {

            currentParent = current;
            current = current.left;
        }

        currentParent.left =
                current.right;

        current.right = null;

        return current;
    }

    // ================================
    // 중위 순회
    // ================================
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node<E> node) {

        if (node == null) {
            return;
        }

        inorder(node.left);

        System.out.println(node.value);

        inorder(node.right);
    }

    // ================================
    // contains
    // ================================
    public boolean contains(Object o) {

        if (comparator == null) {
            return containsUsingComparable(o);
        }

        return containsUsingComparator(
                o,
                comparator);
    }

    private boolean containsUsingComparable(
            Object o) {

        @SuppressWarnings("unchecked")
        Comparable<? super E> value =
                (Comparable<? super E>) o;

        Node<E> node = root;

        while (node != null) {

            int res =
                    value.compareTo(node.value);

            if (res > 0) {

                node = node.right;

            } else if (res < 0) {

                node = node.left;

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
                    comp.compare(
                            value,
                            node.value);

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

    // ================================
    // 기타 메소드
    // ================================
    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        size = 0;
        root = null;
    }
}