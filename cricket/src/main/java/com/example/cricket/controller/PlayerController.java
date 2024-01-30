package com.example.cricket.controller;

import com.example.cricket.dto.PlayerRequestDTO;
import com.example.cricket.entity.Player;
import com.example.cricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    ResponseEntity<List<Player>> allPlayers (){
        List<Player> player = playerService.getAllPlayer();

        if(player == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    @GetMapping("/expensive")
    ResponseEntity<List<Player>> allExpensivePlayers (){
        List<Player> player = playerService.getExpensivePlayers();

        if(player == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }
    //add player
    @PostMapping("")
    ResponseEntity<Player> addPlayer (@RequestBody PlayerRequestDTO body){
        Player player = playerService.addPlayer(body.getPlayerName(), body.getCategory(), body.getAuctionPrice(), body.getTeam(), body.getImage(), body.getStrength(), body.getWeakness(), body.getStatus());
        if(player == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }
    //get player by name
    @GetMapping("/{playerName}")
    ResponseEntity<Player> getPlayerByName(@PathVariable("playerName") String playerName){
        Player player = playerService.getPlayerByName(playerName);
        if(player == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }
    @GetMapping("/team/{team}")
    ResponseEntity<List<Player>> getPlayersByTeam(@PathVariable("team") String team){
        List<Player>  players = playerService.getPlayersByTeam(team);
        if(players == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(players);
    }
    @GetMapping("/match/{name}")
    ResponseEntity<List<Player>> getMatchPlayer (@PathVariable("name") String name){
        List<Player> players = playerService.getMatchPlayers(name);
        if(players == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(players);
    }
    //delete player
    @DeleteMapping("/{playerName}")
    ResponseEntity<Player> deletePlayerByName(@PathVariable("playerName") String playerName){
        Player player = playerService.deletePlayerByName(playerName);
        if(player == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }

    //update player
    @PutMapping("/{playerName}")
    ResponseEntity<Player> updatePlayerByName(@PathVariable("playerName") String playerName, @RequestBody PlayerRequestDTO body){
        Player player = playerService.updatePlayerByName(playerName, body.getPlayerName(), body.getCategory(), body.getAuctionPrice(), body.getTeam(), body.getImage(), body.getStrength(), body.getWeakness(), body.getStatus());
        if(player == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }


    //get player by category
}
