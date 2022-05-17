package com.company.GameStore.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "invoices")
public class Invoices {
    @Id
    @Column(name = "invoices_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "Invoices")
    private Set<Games> games = new HashSet<>();
    private Set<Consoles> consoles = new HashSet<>();
    private Set<Tshirts> tshirts = new HashSet<>();
    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String itemType;
    private Integer itemId;
    private int quantity;
    private BigDecimal total;

    public Invoices() {
    }

    public Invoices(Set<Games> games, Set<Consoles> consoles, Set<Tshirts> tshirts, int id, String name, String street, String city, String state, String zipCode, String itemType, Integer itemId, int quantity, BigDecimal total) {
        this.games = games;
        this.consoles = consoles;
        this.tshirts = tshirts;
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.itemType = itemType;
        this.itemId = itemId;
        this.quantity = quantity;
        this.total = total;
    }

    public Set<Games> getGames() {
        return games;
    }

    public void setGames(Set<Games> games) {
        this.games = games;
    }

    public Set<Consoles> getConsoles() {
        return consoles;
    }

    public void setConsoles(Set<Consoles> consoles) {
        this.consoles = consoles;
    }

    public Set<Tshirts> getTshirts() {
        return tshirts;
    }

    public void setTshirts(Set<Tshirts> tshirts) {
        this.tshirts = tshirts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoices invoices = (Invoices) o;
        return id == invoices.id && quantity == invoices.quantity && Objects.equals(games, invoices.games) && Objects.equals(consoles, invoices.consoles) && Objects.equals(tshirts, invoices.tshirts) && Objects.equals(name, invoices.name) && Objects.equals(street, invoices.street) && Objects.equals(city, invoices.city) && Objects.equals(state, invoices.state) && Objects.equals(zipCode, invoices.zipCode) && Objects.equals(itemType, invoices.itemType) && Objects.equals(itemId, invoices.itemId) && Objects.equals(total, invoices.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(games, consoles, tshirts, id, name, street, city, state, zipCode, itemType, itemId, quantity, total);
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "games=" + games +
                ", consoles=" + consoles +
                ", tshirts=" + tshirts +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
