//package com.company.GameStore.viewmodel;
//
//import com.company.GameStore.models.Tshirts;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class TshirtsViewModel {
//    private int id;
//    private String size;
//    private String color;
//    private String description;
//    private BigDecimal price;
//    private int quantity;
//    private List<Tshirts> tshirts = new ArrayList<>();
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public List<Tshirts> getTshirts() {
//        return tshirts;
//    }
//
//    public void setTshirts(List<Tshirts> tshirts) {
//        this.tshirts = tshirts;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        TshirtsViewModel that = (TshirtsViewModel) o;
//        return id == that.id && quantity == that.quantity && Objects.equals(size, that.size) && Objects.equals(color, that.color) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(tshirts, that.tshirts);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, size, color, description, price, quantity, tshirts);
//    }
//}
