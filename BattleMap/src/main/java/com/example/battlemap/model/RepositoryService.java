package com.example.battlemap.model;

import com.example.battlemap.repository.GameRepo;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {
    GameRepo gameRepo;

    public RepositoryService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public void saveGame(Game game) {
        gameRepo.save(game);
    }
}
