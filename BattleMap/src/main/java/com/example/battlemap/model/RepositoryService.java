package com.example.battlemap.model;

import com.example.battlemap.repository.GameRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class RepositoryService {
    GameRepo gameRepo;

    public RepositoryService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public void saveGame(Game game) {
        gameRepo.save(game);
        log.info("game saved: " + game.getGameName());
        //todo only one game can be created because Name is @Id and is all-times same...
    }
}
