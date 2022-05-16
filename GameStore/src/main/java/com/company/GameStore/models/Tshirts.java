package com.company.GameStore.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Tshirts {
    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    public Tshirts(int id, String size, String color, String description, BigDecimal price, int quantity) {
        this.id = id;
        this.size = size;
        this.color = color;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Tshirts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tshirts tshirts = (Tshirts) o;
        return id == tshirts.id && quantity == tshirts.quantity && Objects.equals(size, tshirts.size) && Objects.equals(color, tshirts.color) && Objects.equals(description, tshirts.description) && Objects.equals(price, tshirts.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "Tshirts{" +
                "id=" + id +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
