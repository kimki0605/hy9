package exam.finalalgoex;

public class BinarySearchTreeStorage<E>
        extends BinarySearchTree<E> {

    public int updateStock(E value, int quantity) {

        // 품목이 없는 경우
        if (!contains(value)) {
            return -2;
        }

        // 품목 검색
        E result = search(value);

        // Product로 변환
        Product product = (Product) result;

        // 재고 반출
        return product.getProduct(quantity);
    }
}