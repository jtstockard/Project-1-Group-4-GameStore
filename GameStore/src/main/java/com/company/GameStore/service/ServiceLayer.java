
package com.company.GameStore.service;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.models.Invoices;
import com.company.GameStore.repositories.ConsolesRepository;
import com.company.GameStore.repositories.GamesRepository;
import com.company.GameStore.repositories.InvoicesRepository;
import com.company.GameStore.repositories.TshirtsRepository;
import com.company.GameStore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
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

        public Consoles addConsoles(Consoles consoles) {
        return consolesRepository.save(consoles);
        }

        public void deleteConsole(int id){
        }

        public void updateConsoles( Consoles consoles){
        }


    @Transactional
    public InvoiceViewModel saveInvoices(InvoiceViewModel invoiceViewModel) {
//
//        // Persist Invoice
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

        

        return invoiceViewModel;
    }

}
