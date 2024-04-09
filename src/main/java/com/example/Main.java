package main.java.com.example;

public class Main {
    public static void main(String[] args) {
        ReceiptGenerator receiptGenerator = new ReceiptGenerator();

        // Example Input 1
        receiptGenerator.addProduct(new Product("book", 12.49, false, true));
        receiptGenerator.addProduct(new Product("movie", 14.99, false, false));
        receiptGenerator.addProduct(new Product("chocolate bar", 0.85, false, true));
        receiptGenerator.generateReceipt();

        // Example Input 2
        receiptGenerator = new ReceiptGenerator(); // Reset for new receipt
        receiptGenerator.addProduct(new Product("imported box of chocolates", 10.00, true, true));
        receiptGenerator.addProduct(new Product("imported bottle of perfume", 47.50, true, false));
        receiptGenerator.generateReceipt();

        // Example Input 3
        receiptGenerator = new ReceiptGenerator(); // Reset for new receipt
        receiptGenerator.addProduct(new Product("imported bottle of perfume", 27.99, true, false));
        receiptGenerator.addProduct(new Product("bottle of perfume", 18.99, false, false));
        receiptGenerator.addProduct(new Product("packet of pills", 9.75, false, true));
        receiptGenerator.addProduct(new Product("imported box of chocolates", 11.25, true, true));
        receiptGenerator.generateReceipt();
    }
}