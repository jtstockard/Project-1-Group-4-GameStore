//package com.comapny.GameStore.service;
//
//import com.comapny.GameStore.models.Games;
//import com.comapny.GameStore.repositories.ConsolesRepository;
//import com.comapny.GameStore.repositories.GamesRepository;
//import com.comapny.GameStore.repositories.InvoicesRepository;
//import com.comapny.GameStore.repositories.TshirtsRepository;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//
//@Component
//public class ServiceLayer {
//    private GamesRepository gamesRepository;
//    private ConsolesRepository consolesRepository;
//    private TshirtsRepository tshirtsRepository;
//    private InvoicesRepository invoicesRepository;
//
//    public ServiceLayer(GamesRepository gamesRepository, ConsolesRepository consolesRepository, TshirtsRepository tshirtsRepository, InvoicesRepository invoicesRepository) {
//        this.gamesRepository = gamesRepository;
//        this.consolesRepository = consolesRepository;
//        this.tshirtsRepository = tshirtsRepository;
//        this.invoicesRepository = invoicesRepository;
//
//    }
//
//    @Transactional
//    public GamesViewModel saveGames(GamesViewModel viewModel) {
//
//        // Persist Games
//        Games a = new Games();
//        a.setId(viewModel.getId());
//        a.setName(viewModel.getName());
//        a.setEsrbRating(viewModel.getEsrbRating());
//        a.setDescription(viewModel.getDescription());
//        a.setPrice(viewModel.getPrice().getId());
//        a.setStudio(viewModel.getStudio).getId());
//        a.setQuantity(viewModel.getQuantity).getId());
//        a = gamesRepository.save(a);
//        viewModel.setId(a.getId());
//        return viewModel;
//    }
//}
