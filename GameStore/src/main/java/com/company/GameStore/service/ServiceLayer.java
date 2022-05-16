package com.company.GameStore.service;

import com.company.GameStore.models.Games;
import com.company.GameStore.repositories.ConsolesRepository;
import com.company.GameStore.repositories.GamesRepository;
import com.company.GameStore.repositories.InvoicesRepository;
import com.company.GameStore.repositories.TshirtsRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ServiceLayer {
    private GamesRepository gamesRepository;
    private ConsolesRepository consolesRepository;
    private TshirtsRepository tshirtsRepository;
    private InvoicesRepository invoicesRepository;

    public ServiceLayer(GamesRepository gamesRepository, ConsolesRepository consolesRepository, TshirtsRepository tshirtsRepository, InvoicesRepository invoicesRepository) {
        this.gamesRepository = gamesRepository;
        this.consolesRepository = consolesRepository;
        this.tshirtsRepository = tshirtsRepository;
        this.invoicesRepository = invoicesRepository;

    }

    @Transactional
    public GamesViewModel saveGames(GamesViewModel viewModel) {

        // Persist Games
        Games a = new Games();
        a.setId(viewModel.getId());
        a.setTitle(viewModel.getTitle());
        a.setEsrbRating(viewModel.getEsrbRating());
        a.setDescription(viewModel.getDescription());
        a.setPrice(viewModel.getPrice().getId());
        a.setStudio(viewModel.getStudio).getId());
        a.setQuantity(viewModel.getQuantity).getId());
        a = gamesRepository.save(a);
        viewModel.setId(a.getId());
        return viewModel;
    }
}
