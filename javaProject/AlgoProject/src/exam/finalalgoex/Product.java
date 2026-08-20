package exam.finalalgoex;

   public class Product implements Comparable<Product> {

       private String name;
       private int stock;

       public Product(String name, int stock) {
           this.name = name;
           this.stock = stock;
       }

       public String getName() {
           return name;
       }

       public int getStock() {
           return stock;
       }

       // 재고 감소
       public void release(int count) {
           stock -= count;
       }

       // 이진 탐색 트리에서 품목명으로 비교
       @Override
       public int compareTo(Product other) {
           return this.name.compareTo(other.name);
       }

       @Override
       public String toString() {
           return name + " : " + stock + "개";
       }
}
