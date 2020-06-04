package com.games.snakeladder.driver;

import com.games.snakeladder.entities.Ladder;
import com.games.snakeladder.entities.Player;
import com.games.snakeladder.entities.Snake;
import com.games.snakeladder.utils.DiceRoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SnakeAndLadderBoard {
    private List<Snake> snakeList;
    private List<Ladder> ladderList;
    private List<Player> playerList;
    private DiceRoller diceRoller;
    private HashMap<Integer, Integer> snakeMap;
    private HashMap<Integer, Integer> ladderMap;

    SnakeAndLadderBoard() {
        snakeList = new LinkedList();
        ladderList = new LinkedList();
        playerList = new LinkedList();
        diceRoller = new DiceRoller();
        snakeMap = new HashMap();
        ladderMap = new HashMap();
    }

    Player hasWinner() {
        for(Player player : playerList) {
            if(player.getCurrentPosition()==100) {
                return player;
            }
        }

        return null;
    }

    void rollDice(Player player) {
        int move = diceRoller.roll();
        int initialPosition = player.getCurrentPosition();
        int immediatePosition = initialPosition+move;
        if(immediatePosition>100) {
            immediatePosition = initialPosition;
        }

        while(snakeMap.containsKey(immediatePosition) || ladderMap.containsKey(immediatePosition)) {
            if(snakeMap.containsKey(immediatePosition)) {
                immediatePosition = snakeMap.get(immediatePosition);
            }
            if(ladderMap.containsKey(immediatePosition)) {
                immediatePosition = ladderMap.get(immediatePosition);
            }
        }

        player.setCurrentPosition(immediatePosition);
        System.out.println(
                String.format("%s rolled a %d and moved from %d to %s",
                        player.getName(),
                        move,
                        initialPosition,
                        immediatePosition));
    }

    void startGame() {
        boolean gameOver = false;
        while(true) {
            for(Player player : playerList) {
                rollDice(player);
                Player winner = hasWinner();
                if(winner != null) {
                    System.out.println(winner.getName()+" wins the game");
                    gameOver = true;
                    break;
                }
            }
            if(gameOver) {
                break;
            }
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SnakeAndLadderBoard snakeAndLadderBoard = new SnakeAndLadderBoard();
        System.out.println("Please enter game data:");
        String[] data = null;

        int snakeCount = Integer.parseInt(br.readLine());
        for(int i=0;i<snakeCount;i++) {
            data = br.readLine().split(" ");
            int head = Integer.parseInt(data[0]);
            int tail = Integer.parseInt(data[1]);
            snakeAndLadderBoard.snakeMap.put(head, tail);
            snakeAndLadderBoard.snakeList.add(new Snake(head, tail));
        }

        int ladderCount = Integer.parseInt(br.readLine());
        for(int i=0;i<ladderCount;i++) {
            data = br.readLine().split(" ");
            int start = Integer.parseInt(data[0]);
            int end = Integer.parseInt(data[1]);
            snakeAndLadderBoard.ladderMap.put(start, end);
            snakeAndLadderBoard.ladderList.add(new Ladder(start, end));
        }

        int playerCount = Integer.parseInt(br.readLine());
        for(int i=0;i<playerCount;i++) {
            String playerName = br.readLine().trim();
            snakeAndLadderBoard.playerList.add(new Player(playerName, 0));
        }
        // init complete
        snakeAndLadderBoard.startGame();
    }
}
