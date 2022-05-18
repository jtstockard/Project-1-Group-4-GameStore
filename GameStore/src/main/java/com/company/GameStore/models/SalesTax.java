package com.company.GameStore.models;


import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class SalesTax {
    @Id
    private String state;
    private double rate;

    public SalesTax(String state, double rate) {
        this.state = state;
        this.rate = rate;
    }

    public SalesTax() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTax salesTax = (SalesTax) o;
        return Double.compare(salesTax.rate, rate) == 0 && Objects.equals(state, salesTax.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }

    @Override
    public String toString() {
        return "SalesTax{" +
                "state='" + state + '\'' +
                ", rate=" + rate +
                '}';
    }
}
