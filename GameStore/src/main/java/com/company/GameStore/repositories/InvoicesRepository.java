package com.company.GameStore.repositories;

import com.company.GameStore.models.Invoices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoicesRepository extends JpaRepository<Invoices, Integer>{

    List<Invoices> findById(int id);

    List<Invoices> findByName(String name);

    List<Invoices> findByStreet(String street);

    List<Invoices> findByCity(String City);

    List<Invoices> findByState(String state);

    List<Invoices> findByZipCode(Integer zipCode);
    
    List<Invoices> findByItemType(String itemType);

    List<Invoices> findByItemId(Integer itemId);

    List<Invoices> findByQuantity(int quantity);
}
