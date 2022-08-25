package ru.netology;

import java.util.LinkedList;

import java.util.ArrayList;

public class Game {
    private LinkedList<Player> players = new LinkedList<>();


    public void register(Player player) {

        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {

        int result = 0;

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1.getStrength() > player2.getStrength()) {
            result = 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            result = 2;
        }

        return result;
    }

    private Player findByName(String playerName) throws NotRegisteredException {

        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegisteredException(playerName);
    }
}