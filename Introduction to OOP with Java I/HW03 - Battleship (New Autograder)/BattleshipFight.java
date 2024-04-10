import java.util.Scanner;

public class BattleshipFight {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int SIZE = 5;
    private static final char EMPTY = '-';
    private static final char SHIP = '@';
    private static final char HIT = 'X';
    private static final char MISS = 'O';

    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!");

        char[][] player1Board = new char[SIZE][SIZE];
        char[][] player2Board = new char[SIZE][SIZE];
        char[][] player1Shots = new char[SIZE][SIZE];
        char[][] player2Shots = new char[SIZE][SIZE];

        initializeBoard(player1Board);
        initializeBoard(player2Board);
        initializeBoard(player1Shots);
        initializeBoard(player2Shots);

        // Player 1 Place Ships
        System.out.println("\nPLAYER 1, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(player1Board);

        // Clear screen
        clearScreen();

        // Player 2 Place Ships
        System.out.println("\nPLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(player2Board);

        // Clear screen
        clearScreen();

        boolean player1Turn = true;
        while (!checkWin(player1Board) && !checkWin(player2Board)) {
            if (player1Turn) {
                System.out.println("Player 1, enter hit row/column:");
                takeTurn(player1Shots, player2Board);
                player1Turn = false;
            } else {
                System.out.println("Player 2, enter hit row/column:");
                takeTurn(player2Shots, player1Board);
                player1Turn = true;
            }
            if (checkWin(player2Board)) {
                System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                break;
            } else if (checkWin(player1Board)) {
                System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                break;
            }
        }

        // Show final boards
        System.out.println("\nFinal boards:");
        System.out.println("Player 1's ships:");
        printBattleShip(player1Board);
        System.out.println("\nPlayer 2's ships:");
        printBattleShip(player2Board);
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void placeShips(char[][] board) {
        for (int i = 1; i <= 5; i++) {
            boolean validPlacement = false;
            while (!validPlacement) {
                System.out.printf("Enter ship %d location:\n", i);
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (isValidLocation(row, col) && board[row][col] != SHIP) {
                    board[row][col] = SHIP;
                    validPlacement = true;
                } else if (!isValidLocation(row, col)) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                } else {
                    System.out.println("You already have a ship there. Choose different coordinates.");
                }
            }
        }
        printBattleShip(board);
    }

    private static void takeTurn(char[][] shotsBoard, char[][] opponentBoard) {
        boolean validShot = false;
        while (!validShot) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (isValidLocation(row, col)) {
                if (shotsBoard[row][col] == EMPTY) {
                    if (opponentBoard[row][col] == SHIP) {
                        System.out.println("HIT!");
                        shotsBoard[row][col] = HIT;
                        opponentBoard[row][col] = HIT;
                    } else {
                        System.out.println("MISS!");
                        shotsBoard[row][col] = MISS;
                    }
                    validShot = true;
                } else {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                }
            } else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
        }
        printBattleShip(shotsBoard);
    }

    private static boolean checkWin(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == SHIP) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidLocation(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private static void clearScreen() {
        for (int i = 0; i < 100; i++) System.out.println();
    }

	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}
}
