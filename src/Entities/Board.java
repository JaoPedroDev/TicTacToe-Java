package Entities;

public class Board {
    int[][] board_array = new int[][] {
            { 0, 0, 0 },
            { 0, 0, 0 },
            { 0, 0, 0 }
    };

    public void Render(Player player_1, Player player_2) {
        String board = "";
        for (int i = 0; i < board_array.length; i++) {
            for (int j = 0; j < board_array[i].length; j++) {
                if (board_array[i][j] == player_1.getNumber()) {
                    board += "[" + player_1.getSimbol() + "]";
                } else if (board_array[i][j] == player_2.getNumber()) {
                    board += "[" + player_2.getSimbol() + "]";
                } else {
                    board += "[ ]";
                }
            }
            board += "\n";
        }

        System.out.println(board);
    }

    public void MoveTo(Player player, int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board_array[row][col] = player.getNumber();
    }

    public Boolean HasWinner() {
        for (int i = 0; i < board_array.length; i++) {
            // Check rows
            if (board_array[i][0] != 0 && board_array[i][0] == board_array[i][1]
                    && board_array[i][1] == board_array[i][2]) {
                return true;
            }

            // Check columns
            if (board_array[0][i] != 0 && board_array[0][i] == board_array[1][i]
                    && board_array[1][i] == board_array[2][i]) {
                return true;
            }
        }

        // Check diagonals
        if (board_array[1][1] == 0) {
            return false;
        }
        if (board_array[0][0] == board_array[1][1] && board_array[1][1] == board_array[2][2]) {
            return true;
        }
        if (board_array[0][2] == board_array[1][1] && board_array[1][1] == board_array[2][0]) {
            return true;
        }

        return false;
    }
}
