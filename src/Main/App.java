package Main;

import java.util.Scanner;

import Entities.Board;
import Entities.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Player player_1 = new Player("X", 1);
        Player player_2 = new Player("O", 2);
        Player[] players = new Player[] { player_1, player_2 };

        Board board = new Board();

        Boolean has_winner = false;
        Player winner = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Positions:");
        System.out.println("[1][2][3]\n[4][5][6]\n[7][8][9]");

        do {
            for (Player player : players) {
                System.out.println();
                System.out.println("Player " + player.getSimbol() + "'s turn.");

                System.out.print("position: ");
                int position = sc.nextInt();

                board.MoveTo(player, position);

                System.out.println();

                board.Render(player_1, player_2);

                if (board.HasWinner()) {
                    winner = player;
                    has_winner = true;
                    break;
                }
            }
        } while (!has_winner);

        System.out.println("Winner is Player " + winner.getSimbol() + "!");

        sc.close();
    }
}
