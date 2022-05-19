//package com.company.GameStore.viewmodel;
//
//import com.company.GameStore.models.Consoles;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class ConsolesViewModel {
//
//    private int id;
//    private String model;
//    private String manufacturer;
//    private String memoryAmount;
//    private String processor;
//    private BigDecimal price;
//    private int quantity;
//    private List<Consoles> consoles = new ArrayList<>();
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public String getManufacturer() {
//        return manufacturer;
//    }
//
//    public void setManufacturer(String manufacturer) {
//        this.manufacturer = manufacturer;
//    }
//
//    public String getMemoryAmount() {
//        return memoryAmount;
//    }
//
//    public void setMemoryAmount(String memoryAmount) {
//        this.memoryAmount = memoryAmount;
//    }
//
//    public String getProcessor() {
//        return processor;
//    }
//
//    public void setProcessor(String processor) {
//        this.processor = processor;
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
//    public List<Consoles> getConsoles() {
//        return consoles;
//    }
//
//    public void setConsoles(List<Consoles> consoles) {
//        this.consoles = consoles;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ConsolesViewModel that = (ConsolesViewModel) o;
//        return id == that.id && quantity == that.quantity && Objects.equals(model, that.model) && Objects.equals(manufacturer, that.manufacturer) && Objects.equals(memoryAmount, that.memoryAmount) && Objects.equals(processor, that.processor) && Objects.equals(price, that.price) && Objects.equals(consoles, that.consoles);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity, consoles);
//    }
//}
