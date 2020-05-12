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

    // return the current value of itemNumber
    public int getItemNumber() {
        return itemNumber;
    }

    // updates the value of itemNumber
    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    // return the current value of name
    public String getName() {
        return name;
    }

    // update the value of name
    public void setName(String name) {
        this.name = name;
    }

    // return the current value of qtyInStock
    public int getQtyInStock() {
        return qtyInStock;
    }

    // update the value of qtyInStock
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    // return the current value of price
    public double getPrice() {
        return price;
    }

    // update the value of price
    public void setPrice(double price) {
        this.price = price;
    }

    //sustituir método toString() de la clase Object
    //para permitir la visualización de cada objeto en la consola
    @Override
    public String toString() {
        return "\nItemNumber=" + itemNumber +
                "\nName='" + name + '\'' +
                "\nQtyInStock=" + qtyInStock +
                "\nPrice=" + price;
    }
} // end of class Product


