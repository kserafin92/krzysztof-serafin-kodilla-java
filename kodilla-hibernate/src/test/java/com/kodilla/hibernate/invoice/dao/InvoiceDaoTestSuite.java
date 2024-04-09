package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    public void cleanUp() {
        invoiceDao.deleteAll();

    }




    @Transactional
    @Test
    void testInvoiceDaoSave() {
        // Given
        Product product = new Product("Test product");
        Item item1 = new Item(product, BigDecimal.valueOf(10), 2);
        Item item2 = new Item(product, BigDecimal.valueOf(20), 3);
        Invoice invoice = new Invoice("Test invoice");
        invoice.addItem(item1);
        invoice.addItem(item2);

        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();
        int itemsCount = invoice.getItems().size();

        // Then
        assertEquals(1, invoiceId);
        assertEquals(2, itemsCount);

    }
}