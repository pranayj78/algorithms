/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pranay78.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pranay
 */
public class CandidateCode {

    public static int passCount(int input1, int input2, int input3) {
        List<Player> players = PlayerFactory.getPlayers(input1, input2);
//        for(Player player :players){
//            System.out.println("algorithims.CandidateCode.passCount() " +player);
//        }
        players.get(0).takeBall(input3);

        return Player.getTotalNumberOfMoves();
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("algorithims.CandidateCode.main() number of moves " + passCount(500, 400, 50));
        long endTime = System.nanoTime();
        System.out.println("algorithims.CandidateCode.main() time taken " + (endTime - startTime));
    }

    static class  PlayerFactory {

        public static List<Player> getPlayers(int totalNumberOfPlayers, int maxNumerOfTimeBallCanBeHeld) {
            List<Player> players = new ArrayList<>(totalNumberOfPlayers);
            Player player = new Player(1, maxNumerOfTimeBallCanBeHeld);
            players.add(player);
            Player currentPlayer = player;
            for (int i = 2; i <= totalNumberOfPlayers; i++) {
                Player newPlayer = currentPlayer.createNextPlayer();
                players.add(newPlayer);
                currentPlayer = newPlayer;
            } 
            player.setPlayerOnMyRight(currentPlayer);
            currentPlayer.setPlayerOnMyLeft(player);
            return players;
        }
    }

    static class Player {

        private final int playerNumber;
        private int numberOfTimesBallHeld = 0;
        private Player playerOnMyLeft;
        private Player playerOnMyRight;
        private final int maxNumberOfTimesIcanTakeTheBall;
        private static int totalNumberOfMoves = 0;
        private Player LthplayerOnMyLeft;
        private Player LthplayerOnMyRight;

        public Player(final int playerNumber, final int maxNumberOfTimesIcanTakeTheBall) {
            this.playerNumber = playerNumber;
            this.maxNumberOfTimesIcanTakeTheBall = maxNumberOfTimesIcanTakeTheBall;
        }

        public Player createNextPlayer() {
            Player player = new Player(playerNumber + 1, maxNumberOfTimesIcanTakeTheBall);
            this.playerOnMyLeft = player;
            player.setPlayerOnMyRight(this);
            return player;
        }

        public Player getPlayerOnMyLeft() {
            return playerOnMyLeft;
        }

        public void setPlayerOnMyLeft(Player playerOnMyLeft) {
            this.playerOnMyLeft = playerOnMyLeft;
        }

        public Player getPlayerOnMyRight() {
            return playerOnMyRight;
        }

        public void setPlayerOnMyRight(Player playerOnMyRight) {
            this.playerOnMyRight = playerOnMyRight;
        }

        public static int getTotalNumberOfMoves() {
            return totalNumberOfMoves;
        }

        public void takeBall(int moveToNextPlayer) {
            numberOfTimesBallHeld++;

            //   System.out.println("algorithims.Player.takeBall() totalNumberOfMoves " +totalNumberOfMoves);
            //   System.out.println("algorithims.Player.takeBall() numberOfTimesBallHeld " +numberOfTimesBallHeld);
            if (numberOfTimesBallHeld == maxNumberOfTimesIcanTakeTheBall) {
                return;
            } else {
                totalNumberOfMoves++;
                moveToPlayer(moveToNextPlayer);
            }
        }

        private void moveToPlayer(int moveToNextPlayer) {
            if (numberOfTimesBallHeld % 2 == 0) { // even number
                if (LthplayerOnMyLeft == null) { //Lazy finding 
                    int i = 0;
                    Player currentPlayer = this;
                    Player tempPlayer = null;
                    while (i < moveToNextPlayer) {
                        tempPlayer = currentPlayer.playerOnMyLeft;
                        currentPlayer = tempPlayer;
                        i++;
                    }
                    LthplayerOnMyLeft = currentPlayer;
                    //  System.out.println("Lth  the player on " + this.playerNumber +" left is " + LthplayerOnMyLeft.playerNumber);
                    LthplayerOnMyLeft.takeBall(moveToNextPlayer);
                } else {
                   // System.out.println("Lth  the player on " + this.playerNumber + " left is " + LthplayerOnMyLeft.playerNumber);
                    LthplayerOnMyLeft.takeBall(moveToNextPlayer);
                }
            } else // odd Number
            if (LthplayerOnMyRight == null) {
                int i = 0;
                Player currentPlayer = this;
                Player tempPlayer = null;
                while (i < moveToNextPlayer) {
                    tempPlayer = currentPlayer.playerOnMyRight;
                    currentPlayer = tempPlayer;
                    i++;
                }
                LthplayerOnMyRight = currentPlayer;
                //   System.out.println("L the player on " + this.playerNumber +" Right is " + LthplayerOnMyRight.playerNumber);
                LthplayerOnMyRight.takeBall(moveToNextPlayer);
            } else {
                //     System.out.println("L the player on " + this.playerNumber +" Right is " + LthplayerOnMyRight.playerNumber);
                LthplayerOnMyRight.takeBall(moveToNextPlayer);
            }
        }

        @Override
        public String toString() {
            return "Player{" + "playerNumber=" + playerNumber + ", playerOnMyLeft=" + playerOnMyLeft.playerNumber + ", playerOnMyRight=" + playerOnMyRight.playerNumber + '}';
        }

    }

}
