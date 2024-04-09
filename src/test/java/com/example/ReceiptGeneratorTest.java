package test.java.com.example;
import main.java.com.example.Product;

import main.java.com.example.ReceiptGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReceiptGeneratorTest {
    private ReceiptGenerator receiptGenerator;

    @Before
    public void setUp() {
        receiptGenerator = new ReceiptGenerator();
    }

//    @Test
//    public void testGenerateReceiptWithNoProducts() {
//        receiptGenerator.generateReceipt(); // Generate receipt with no products
//        String generatedReceipt = receiptGenerator.getGeneratedReceipt();
//        assertEquals("", generatedReceipt); // Assert that generated receipt is empty
//    }

    @Test
    public void testGenerateReceiptWithProducts() {
        ReceiptGenerator receiptGenerator = new ReceiptGenerator();
        receiptGenerator.addProduct(new Product("book", 12.49, false, true)); // Exempt from basic tax, not imported
        receiptGenerator.addProduct(new Product("chocolate bar", 0.85, false, false)); // Exempt from basic tax, not imported

        // Generate the receipt
        receiptGenerator.generateReceipt();
        String generatedReceipt = receiptGenerator.getGeneratedReceipt();

        // Define the expected receipt content
        String expectedReceipt =
                "1 book : 12.49\n" +
                        "1 chocolate bar : 0.85\n" +
                        "--------------------\n" +
                        "Sales Taxes : 0\n" +
                        "Total : 13.45";

        // Compare the generated receipt with the expected receipt
        assertEquals(expectedReceipt, generatedReceipt);
    }
}
