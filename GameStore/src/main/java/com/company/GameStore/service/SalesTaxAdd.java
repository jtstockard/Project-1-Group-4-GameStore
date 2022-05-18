package com.company.GameStore.service;

import com.company.GameStore.models.Invoices;
import com.company.GameStore.models.SalesTax;
import com.company.GameStore.repositories.SalesTaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SalesTaxAdd {

    @Autowired
    SalesTaxRepository salesTaxRepository;

//    public SalesTax findByState(Invoices invoices){
//        return salesTaxRepository.findByState(invoices.getState());
//    }

    public void assignSalesTax(){
        salesTaxRepository.save(new SalesTax("AL", .05));
        salesTaxRepository.save(new SalesTax("AK", .06));
        salesTaxRepository.save(new SalesTax("AZ", .04));
        salesTaxRepository.save(new SalesTax("AR", .06));
        salesTaxRepository.save(new SalesTax("CA", .06));
        salesTaxRepository.save(new SalesTax("CO", .04));
        salesTaxRepository.save(new SalesTax("CT", .03));
        salesTaxRepository.save(new SalesTax("DE", .05));
        salesTaxRepository.save(new SalesTax("FL", .06));
        salesTaxRepository.save(new SalesTax("GA", .07));
        salesTaxRepository.save(new SalesTax("HI", .05));
        salesTaxRepository.save(new SalesTax("ID", .03));
        salesTaxRepository.save(new SalesTax("IL", .05));
        salesTaxRepository.save(new SalesTax("IN", .05));
        salesTaxRepository.save(new SalesTax("IA", .04));
        salesTaxRepository.save(new SalesTax("KS", .06));
        salesTaxRepository.save(new SalesTax("KY", .04));
        salesTaxRepository.save(new SalesTax("LA", .05));
        salesTaxRepository.save(new SalesTax("ME", .03));
        salesTaxRepository.save(new SalesTax("MD", .07));
        salesTaxRepository.save(new SalesTax("MA", .05));
        salesTaxRepository.save(new SalesTax("MI", .06));
        salesTaxRepository.save(new SalesTax("MN", .06));
        salesTaxRepository.save(new SalesTax("MS", .05));
        salesTaxRepository.save(new SalesTax("MO", .03));
        salesTaxRepository.save(new SalesTax("MT", .03));
        salesTaxRepository.save(new SalesTax("NE", .04));
        salesTaxRepository.save(new SalesTax("NV", .04));
        salesTaxRepository.save(new SalesTax("NH", .06));
        salesTaxRepository.save(new SalesTax("NJ", .05));
        salesTaxRepository.save(new SalesTax("NM", .05));
        salesTaxRepository.save(new SalesTax("NY", .06));
        salesTaxRepository.save(new SalesTax("NC", .05));
        salesTaxRepository.save(new SalesTax("ND", .05));
        salesTaxRepository.save(new SalesTax("OH", .04));
        salesTaxRepository.save(new SalesTax("OK", .04));
        salesTaxRepository.save(new SalesTax("OR", .07));
        salesTaxRepository.save(new SalesTax("PA", .06));
        salesTaxRepository.save(new SalesTax("RI", .06));
        salesTaxRepository.save(new SalesTax("SC", .06));
        salesTaxRepository.save(new SalesTax("SD", .06));
        salesTaxRepository.save(new SalesTax("TN", .05));
        salesTaxRepository.save(new SalesTax("TX", .03));
        salesTaxRepository.save(new SalesTax("UT", .04));
        salesTaxRepository.save(new SalesTax("VT", .07));
        salesTaxRepository.save(new SalesTax("VA", .06));
        salesTaxRepository.save(new SalesTax("WA", .05));
        salesTaxRepository.save(new SalesTax("WV", .05));
        salesTaxRepository.save(new SalesTax("WI", .03));
        salesTaxRepository.save(new SalesTax("WY", .04));
    }
}
