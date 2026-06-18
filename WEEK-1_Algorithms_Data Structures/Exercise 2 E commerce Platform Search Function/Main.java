import java.util.Arrays;

class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + productId + ", name='" + productName + '\'' + '}';
    }
}

public class Main {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == targetId) {
                return products[mid];
            }
            if (products[mid].getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Mouse", "Accessories"),
                new Product(108, "Keyboard", "Accessories"),
                new Product(102, "Monitor", "Electronics"),
                new Product(110, "Desk", "Furniture")
        };

        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(products, 108);
        System.out.println("Found (108): " + (foundLinear != null ? foundLinear : "Not found"));

        System.out.println("\n--- Binary Search ---");
        Arrays.sort(products);
        Product foundBinary = binarySearch(products, 102);
        System.out.println("Found (102): " + (foundBinary != null ? foundBinary : "Not found"));
    }
}