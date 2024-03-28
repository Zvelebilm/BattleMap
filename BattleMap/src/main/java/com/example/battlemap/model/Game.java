package com.example.battlemap.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Game {
    @Id
    private String gameName;
    private List<Player> players; //todo players in-game>
    private List<Flag> flags;
}
