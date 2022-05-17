
package com.company.GameStore.service;

import com.company.GameStore.models.Consoles;
import com.company.GameStore.models.Games;
import com.company.GameStore.models.Tshirts;
import com.company.GameStore.repositories.ConsolesRepository;
import com.company.GameStore.repositories.GamesRepository;
import com.company.GameStore.repositories.InvoicesRepository;
import com.company.GameStore.repositories.TshirtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.peer.CanvasPeer;
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

        public List<Consoles> findAllConsoles() {
        //stub that needs implementation
        return null;
        }

        public List<Consoles> saveConsole(Consoles consoles) {
        return null;
        }

        public List<Consoles> findByManufacturer(String manufacturer) {
        return null;
        }

        public List<Consoles> updateConsole(Consoles consoles) {
        return null;
    }

        public List<Consoles> deleteConsole() {
        return null;
        }

        public List<Games> findAllGames() {
        //stub that needs implementation
            return null;
        }
        public List<Games> saveGame() {
        //stub that needs implementation
            return null;
        }

        public List<Games> findGamesByStudio() {
            //stub that needs implementation
            return null;
        }

        public List<Games> findGamesByRating() {
            //stub that needs implementation
            return null;
        }
        public List<Games> findGamesByTitle() {
            //stub that needs implementation
            return null;
        }

        public List<Games> updateGamesByStudio() {
            return null;
        }

        public List<Games> updateGamesByRating() {
            return null;
        }

        public List<Games> updateGamesByTitle() {
            return null;
        }
        public List<Games> removeGamesByStudio() {
        return null;
        }

        public List<Games> removeGamesByRating() {
            return null;
        }

        public List<Games> removeGamesByTitle() {
            return null;
        }

        public List<Tshirts> findAllTshirts() {
            //stub that needs implementation
            return null;
        }




//    @Transactional
//    public InvoiceViewModel saveInvoices(InvoiceViewModel viewModel) {
//
//        // Persist Invoice
//        Invoices a = new Invoices();
//        a.setId(viewModel.getId());
//        a.setName(viewModel.getName());
//        a.setStreet(viewModel.getStreet());
//        a.setCity(viewModel.getCity());
//        a.setState(viewModel.getState());
//        a.setZipCode(viewModel.getZipCode());
//        a.setItemType(viewModel.getItemType());
//        a.setItemId(viewModel.getItemId());
//        a.setQuantity(viewModel.getQuantity());
//        a = invoicesRepository.save(a);
//        viewModel.setId(a.getId());
//
//        List<Games> game = viewModel.getGames();
//
//        game.stream()
//                .forEach(t ->
//                {
//                    t.setInvoicesId(viewModel.getId());
//                    gamesRepository.save(t);
//                });
//
//        game = gamesRepository.findAllGamesByInvoicesId(viewModel.getId());
//        viewModel.setGames(game);
//
//        List<Consoles> console = viewModel.getConsoles();
//
//        console.stream()
//                .forEach(t ->
//                {
//                    t.setInvoicesId(viewModel.getId());
//                    consolesRepository.save(t);
//                });
//
//        console = consolesRepository.findAllConsolesByInvoicesId(viewModel.getId());
//        viewModel.setConsoles(console);
//
//        List<Tshirts> tshirt = viewModel.getTshirts();
//
//        tshirt.stream()
//                .forEach(t ->
//                {
//                    t.setInvoicesId(viewModel.getId());
//                    tshirtRepository.save(t);
//                });
//
//        tshirt = tshirtRepository.findAllTshirtsByInvoicesId(viewModel.getId());
//        viewModel.setTshirts(tshirt);
//
//        return viewModel;
//    }
//    public InvoiceViewModel findInvoices(int id) {
//
//        Optional<Invoices> invoices = invoicesRepository.findById(id);
//
//        return invoices.isPresent() ? buildInvoiceViewModel(invoices.get()) : null;
//    }
//    private InvoiceViewModel buildInvoiceViewModel(Invoices album) {
//
//        // Get the associated game
//        Optional<Games> game = gamesRepository.findById(games.getGamesId());
//
//        // Get the associated console
//        Optional<Consoles> console = consolesRepository.findById(consoles.getConsolesId());
//
//        // Get the tracks associated with the album
//        Optional<Tshirts> tshirt = tshirtsRepository.findById(tshirts.getTshirtsId());
//
//        // Assemble the AlbumViewModel
//        InvoiceViewModel avm = new invoiceViewModel();
//        avm.setId(invoices.getId());
//        avm.setName(invoices.getName());
//        avm.setStreet(invoices.getStreet());
//        avm.setCity(invoices.getCity());
//        avm.setState(invoices.getState());
//        avm.setZipCode(invoices.getZipCode());
//        avm.setItemType(invoices.getItemType());
//        avm.setItemId(invoices.getItemId());
//        avm.setQuantity(invoices.getQuantity());
//
//        // Return the AlbumViewModel
//        return avm;
//    }
//
}
