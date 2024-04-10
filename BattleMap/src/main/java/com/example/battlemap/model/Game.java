package com.example.battlemap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
  private  String gameName;
    //todo add location (start place)
    //todo add date of event
   private List<Flag> flags;
}
