package mx.store;

public class ProductTest {
    public static void main(String[] args) {
        // Creating two objects with the default constructor
        Product p1 = new Product();
        Product p2 = new Product();

        // Creating 4 products with values in arguments of
        // constructor with parameters

        Product p3 = new Product(3, "Jumanji", 10, 5.55);
        Product p4 = new Product(4, "Avengers", 20, 6.66);
        Product p5 = new Product(5, "Dragon Ball Super Broly", 30, 7.77);
        Product p6 = new Product(6, "La vida es Bella", 40, 8.88);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
    }
}
