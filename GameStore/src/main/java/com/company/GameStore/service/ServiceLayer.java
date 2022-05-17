
package com.company.GameStore.service;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.models.Invoices;
import com.company.GameStore.models.Games;
import com.company.GameStore.models.Tshirts;

import com.company.GameStore.repositories.ConsolesRepository;
import com.company.GameStore.repositories.GamesRepository;
import com.company.GameStore.repositories.InvoicesRepository;
import com.company.GameStore.repositories.TshirtsRepository;
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
        public List<Consoles> getAConsoles(int id) {
        return consolesRepository.findById(id);
        }

        public List<Consoles> getByManufacturer(String manufacturer) {
            return consolesRepository.findByManufacturer(manufacturer);
        }

        public Consoles addConsoles(Consoles consoles) {
        return consolesRepository.save(consoles);
        }


        public void deleteConsoles(int id){
        }
    public List<Consoles> findByManufacturer(String manufacturer) {
        return consolesRepository.findByManufacturer(manufacturer);
    }
        public List<Consoles> updateConsoles(Consoles consoles){
            return null;
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
    public List<Games> getGamesByStudio(String studio){
        return gamesRepository.findByStudio(studio);
    }
    public List<Games> getGamesByErsbRating(String ersbRating){
        return gamesRepository.findByEsrbRating(ersbRating);
    }
    public List<Games> getGamesByTitle(String title){
        return gamesRepository.findByTitle(title);
    }
    public List<Games> getAGamesById(int id){
        return gamesRepository.findById(id);
    }
    public Games addGames(Games games) {
        return gamesRepository.save(games); }

    public Games updateGames (Games games){
        gamesRepository.save(games);
        return games;
    }

    public void deleteGames (int id){
        gamesRepository.deleteById(id);
    }
    public List<Games> findAllGames() {
        return gamesRepository.findAll();
    }

//    public List<Games> updateGamesByStudio() {
//        gamesRepository.save();
//    }
//
//    public List<Games> updateGamesByRating() {
//    }
//
//    public List<Games> updateGamesByTitle() {
//    }
//
//    public List<Games> removeGamesByStudio() {
//    }
//
//    public List<Games> removeGamesByRating() {
//    }
//
//    public List<Games> removeGamesByTitle() {
//    }



//    Tshirts CRUD
    public List<Tshirts> getAllTshirts(){
        return tshirtsRepository.findAll();
    }
    public List<Tshirts> getATshirtsById(int id){
        return tshirtsRepository.findById(id);
    }
    public Tshirts addATshirts(Tshirts tshirts){
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




  
    @Transactional
    public InvoiceViewModel saveInvoices(InvoiceViewModel invoiceViewModel) {
        Invoices a = new Invoices();
        a.setId(invoiceViewModel.getId());
        a.setName(invoiceViewModel.getName());
        a.setStreet(invoiceViewModel.getStreet());
        a.setCity(invoiceViewModel.getCity());
        a.setState(invoiceViewModel.getState());
        a.setZipCode(invoiceViewModel.getZipCode());
        a.setItemType(invoiceViewModel.getItemType());
        a.setItemId(invoiceViewModel.getItemId());
        a.setQuantity(invoiceViewModel.getQuantity());
        a.setTotal(invoiceViewModel.getTotal());
        a = invoicesRepository.save(a);
        invoiceViewModel.setId(a.getId());

//       need to calculate total with


        

        return invoiceViewModel;
    }

}

