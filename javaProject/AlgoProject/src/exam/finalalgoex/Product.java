package exam.finalalgoex;

public class Product implements Comparable<Product> {

    private String productName;
    private int productStock;

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(String productName, int productStock) {
        this.productName = productName;
        this.productStock = productStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    // 재고 반출
    // 0 : 재고가 없음
    // 1 : 재고 반출 성공
    // -1 : 재고 부족
    public int getProduct(int quantity) {

        if (productStock == 0) {
            return 0;
        }

        if (productStock < quantity) {
            return -1;
        }

        productStock -= quantity;

        if (productStock == 0) {
            return 0;
        }

        return 1;
    }

    // 상품명을 기준으로 비교
    @Override
    public int compareTo(Product product) {
        return productName.compareTo(product.productName);
    }

    @Override
    public String toString() {
        return productName + " : " + productStock;
    }
}