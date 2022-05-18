
package com.company.GameStore.service;

import com.company.GameStore.models.*;
import com.company.GameStore.repositories.*;
import com.company.GameStore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class ServiceLayer {
    private GamesRepository gamesRepository;
    private ConsolesRepository consolesRepository;
    private TshirtsRepository tshirtsRepository;
    private InvoicesRepository invoicesRepository;

    @Autowired
    public ServiceLayer(GamesRepository gamesRepository, ConsolesRepository consolesRepository, TshirtsRepository tshirtsRepository, InvoicesRepository invoicesRepository) {
        this.gamesRepository = gamesRepository;
        this.consolesRepository = consolesRepository;
        this.tshirtsRepository = tshirtsRepository;
        this.invoicesRepository = invoicesRepository;
    }


    //    Console CRUD
    public List<Consoles> findAllConsoles() {
        return consolesRepository.findAll();
    }

    public Consoles getAConsoles(int id) {
        return consolesRepository.findById(id).get();
    }

    public List<Consoles> getByManufacturer(String manufacturer) {
        return consolesRepository.findByManufacturer(manufacturer);
    }

    public Consoles addConsoles(Consoles consoles) {
        return consolesRepository.save(consoles);
    }

    public Consoles updateConsoles(Consoles consoles) {
        return consolesRepository.save(consoles);
    }


    public void deleteConsoles(int id) {
        consolesRepository.deleteById(id);
    }

    public List<Consoles> findByManufacturer(String manufacturer) {
        return consolesRepository.findByManufacturer(manufacturer);
    }


    //    Invoice CRUD
    public List<Invoices> getAllInvoices() {
        return invoicesRepository.findAll();
    }

    public Optional<Invoices> getInvoicesById(int id) {
        return invoicesRepository.findById(id);
    }

    public Invoices addInvoices(Invoices invoices) {
        return invoicesRepository.save(invoices);
    }

    //    Game CRUD
    public List<Games> getAllGames() {
        return gamesRepository.findAll();
    }

    public List<Games> getGamesByStudio(String studio) {
        return gamesRepository.findByStudio(studio);
    }

    public List<Games> getGamesByErsbRating(String ersbRating) {
        return gamesRepository.findByEsrbRating(ersbRating);
    }

    public List<Games> getGamesByTitle(String title) {
        return gamesRepository.findByTitle(title);
    }

    //  Had to chnage int to Integer.
    public Games getGamesById(Integer id) {
        return gamesRepository.findById(id).get();
    }


    public Games addGames(Games games) {
        return gamesRepository.save(games);
    }


    public Games updateGames(Games games) {
        gamesRepository.save(games);
        return games;
    }

    public void deleteGames(int id) {
        gamesRepository.deleteById(id);
    }
//    public List<Games> findAllGames() {
//        return gamesRepository.findAll();
//    }


    //    Tshirts CRUD
    public List<Tshirts> getAllTshirts() {
        return tshirtsRepository.findAll();
    }

    public Tshirts getATshirtsById(Integer id) {
        return tshirtsRepository.findById(id).get();
    }

    public Tshirts addATshirts(Tshirts tshirts) {
        return tshirtsRepository.save(tshirts);
    }

    public List<Tshirts> getTshirtsByColor(String color) {
        return tshirtsRepository.findByColor(color);
    }

    public List<Tshirts> getTshirtsBySize(String size) {
        return tshirtsRepository.findBySize(size);
    }

    public Tshirts updateTshirts(Tshirts tshirts) {
        tshirtsRepository.save(tshirts);
        return tshirts;
    }

    public void deleteTshirts(int id) {
        tshirtsRepository.deleteById(id);
    }


// best idea for price calculation
    public Invoices buildInvoice(Invoices invoices) {
        Invoices updateInvoices = invoices;
        BigDecimal saleTax = SalesTaxRepository.findByState(invoices.getState().getRate());
        BigDecimal processingFee = ProcessingFeeRepository.findByItemType(Invoices.getItemType()).getFee();
//        BigDecimal subTotal =  invoices.getItemType() * invoices.getQuantity();

        BigDecimal subTotal = (new BigDecimal(String.valueOf(invoices.getItemType())).multiply(new BigDecimal(invoices.getQuantity());

        BigDecimal total = (subTotal.add(subTotal.multiply(saleTax)).add(processingFee));

        return invoicesRepository.save(updateInvoices);
    }
}
//    BigDecimal x = new BigDecimal("42");
//        x.multiply(new BigDecimal("100"));
