package com.company.GameStore.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class ProcessingFees {
    
    @Id
    private String itemType;
    private BigDecimal fee;

    public ProcessingFees(String itemType, BigDecimal fee) {
        this.itemType = itemType;
        this.fee = fee;
    }

    public ProcessingFees() {
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFees that = (ProcessingFees) o;
        return Objects.equals(itemType, that.itemType) && Objects.equals(fee, that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemType, fee);
    }

    @Override
    public String toString() {
        return "ProcessingFees{" +
                "itemType='" + itemType + '\'' +
                ", fee=" + fee +
                '}';
    }
}
