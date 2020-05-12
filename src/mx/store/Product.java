package mx.store;

public class Product {
    // Instance field declarations
    private int itemNumber; // unique value for identification
    private String name; // name of the product
    private int qtyInStock; // quantity in stock
    private double price; // price of the product

    // default constructor witch initializes instance variables
    // numeric values are 0 and String values are "" (null)

    public Product() {
    }//end constructor

    // constructor that allows the setting of the initial values for Products
    public Product(int itemNumber, String name, int qtyInStock, double price) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.qtyInStock = qtyInStock;
        this.price = price;
    }// end constructor

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
} // end of class Product


