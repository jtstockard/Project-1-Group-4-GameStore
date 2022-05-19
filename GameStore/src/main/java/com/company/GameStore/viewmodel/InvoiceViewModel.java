package com.company.GameStore.viewmodel;

import java.math.BigDecimal;
import java.util.Objects;
import com.company.GameStore.service.ServiceLayer;

public class InvoiceViewModel {
    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String itemType;
    private int itemId;
    private BigDecimal unitPrice;
    private BigDecimal subTotal;
    private BigDecimal taxTotal;
    private BigDecimal processing;
    private int quantity;
    private BigDecimal total;

    public InvoiceViewModel(int id, String name, String street, String city, String state, String zipCode, String itemType, int itemId, BigDecimal unitPrice, BigDecimal subTotal, BigDecimal taxTotal, BigDecimal processing, int quantity, BigDecimal total) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.itemType = itemType;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.subTotal = subTotal;
        this.taxTotal = taxTotal;
        this.processing = processing;
        this.quantity = quantity;
        this.total = total;
    }
}
