package com.example.cricket.service;

import com.example.cricket.entity.Player;
import com.example.cricket.repo.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public Player addPlayer(String playerName, String category, String auctionPrice, String team, String image, String strength, String weakness, String status){

        Player player = new Player();
        player.setPlayerName(playerName);
        player.setCategory(category);
        player.setAuctionPrice(auctionPrice);
        player.setTeam(team);
        player.setImage(image);
        player.setStrength(strength);
        player.setWeakness(weakness);
        player.setStatus(status);
        return playerRepo.save(player);

    }

    public Player deletePlayerByName (String playerName){
        if(playerRepo.findById(playerName).isPresent()){
            Player player = playerRepo.findById(playerName).get();
            playerRepo.deleteById(playerName);
            return player;
        }
        return null;

    }
    public Player getPlayerByName (String playerName){
        if(playerRepo.findById(playerName).isPresent()){
            return playerRepo.findById(playerName).get();
        }
        return null;
    }
    public Player updatePlayerByName (String playerNameid, String playerName, String category, String auctionPrice, String team, String image, String strength, String weakness, String status) {
        if(playerRepo.findById(playerNameid).isPresent()){
            playerRepo.deleteById(playerNameid);
            Player player = new Player();
            player.setPlayerName(playerName);
            player.setCategory(category);
            player.setAuctionPrice(auctionPrice);
            player.setTeam(team);
            player.setImage(image);
            player.setStrength(strength);
            player.setWeakness(weakness);
            player.setStatus(status);
            playerRepo.save(player);
            return player;
        }
        return null;
    }

    public  List<Player> getAllPlayer(){
        Iterable<Player> players = playerRepo.findAll();
        List<Player> players1 = new ArrayList<>();
        for (Player player : players) {
            players1.add(player);
        }
        return players1;
    }
    public List<Player> getPlayersByTeam(String team) {
        Iterable<Player> players = playerRepo.findAll();
        List<Player> players1 = new ArrayList<>();
        for (Player player : players) {
            if(player.getTeam().equals(team) ) {
                players1.add(player);
            }
        }
        return players1;
    }

    public List<Player> getMatchPlayers(String name) {
        Iterable<Player> players = playerRepo.findAll();
        List<Player> players1 = new ArrayList<>();
        for(Player player: players){
            System.out.println(player.getPlayerName());
            if((player.getPlayerName().toLowerCase()).matches("^[a-zA-Z ]*" +name + "[a-zA-Z ]*$")) {
                players1.add(player);
            }
        }
        return players1;
    }

    public List<Player> getExpensivePlayers(){

        Iterable<Player> players = playerRepo.findAll();

        PriorityQueue<Player> minHeap = new PriorityQueue<>(new Comparator<Player>(){
            @Override
            public int compare(Player a, Player b) {
                if ((Integer.parseInt(a.getAuctionPrice()) - Integer.parseInt(b.getAuctionPrice())) < 0) {
                    return -1;
                } else if ((Integer.parseInt(a.getAuctionPrice()) - Integer.parseInt(b.getAuctionPrice())) > 0) {
                    return 1;
                } else return 0;
            }
        });

        for(Player player: players){
            minHeap.offer(player);

            if(minHeap.size()>8){
                minHeap.poll();
            }
        }

        List<Player> players1 = new ArrayList<>();
        players1.addAll(minHeap);

        players1.sort(new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                if ((Integer.parseInt(a.getAuctionPrice()) - Integer.parseInt(b.getAuctionPrice())) < 0) {
                    return 1;
                } else if ((Integer.parseInt(a.getAuctionPrice()) - Integer.parseInt(b.getAuctionPrice())) > 0) {
                    return -1;
                } else return 0;
            }
        });
        return players1;
    }
}
