package main.java.com.example;

import main.java.com.example.Product;

import java.util.ArrayList;
import java.util.List;
public class ReceiptGenerator {


    private List<Product> products;
    private String generatedReceipt;

    public ReceiptGenerator() {
        this.products = new ArrayList<>();
    }

    public String getGeneratedReceipt() {
        return this.generatedReceipt;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public void generateReceipt() {
        double totalSalesTaxes = 0;
        double totalPrice = 0;

        System.out.println("Receipt:");
        for (Product product : products) {
            double taxedPrice = calculateTaxedPrice(product);
            totalSalesTaxes += taxedPrice - product.getPrice();
            totalPrice += taxedPrice;
            System.out.println(formatProductLine(product, taxedPrice));
        }

        System.out.println("--------------------");
        System.out.println("Sales Taxes: " + roundToNearest0_05(totalSalesTaxes));
        System.out.println("Total: " + roundToNearest0_05(totalPrice));
    }

    private double calculateTaxedPrice(Product product) {
        double taxRate = getTaxRate(product);
        double taxedPrice = product.getPrice() + (product.getPrice() * taxRate);
        return roundToNearest0_05(taxedPrice);
    }

    private double getTaxRate(Product product) {
        double basicTaxRate = product.isExempt() ? 0 : 0.1;
        double importTaxRate = product.isImported() ? 0.05 : 0;
        return basicTaxRate + importTaxRate;
    }

    private String formatProductLine(Product product, double taxedPrice) {
        return String.format("%d %s: %.2f", 1, product.getName(), taxedPrice);
    }

    private double roundToNearest0_05(double value) {
        return Math.ceil(value * 20) / 20; // Round to the nearest 0.05
    }
}
