import java.util.Scanner;

public class Battleship {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int SIZE = 5;
    private static final char EMPTY = '-';
    private static final char SHIP = '@';
    private static final char HIT = 'X';
    private static final char MISS = 'O';

    public static void main(String[] args) {
        System.out.println("Welcome to Battleship!\n");

        char[][] player1Board = new char[SIZE][SIZE];
        char[][] player2Board = new char[SIZE][SIZE];
        char[][] player1Shots = new char[SIZE][SIZE];
        char[][] player2Shots = new char[SIZE][SIZE];

        initializeBoard(player1Board);
        initializeBoard(player2Board);
        initializeBoard(player1Shots);
        initializeBoard(player2Shots);

        // Player 1 Place Ships
        System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

        placeShips(player1Board);

        // Clear screen
        clearScreen();

        // Player 2 Place Ships
        System.out.println("PLAYER 2, ENTER YOUR SHIPS' COORDINATES.");
        placeShips(player2Board);

        // Clear screen
        clearScreen();

        boolean player1Turn = true;
        while (!checkWin(player1Board) && !checkWin(player2Board)) {
            if (player1Turn) {
                System.out.println("\nPlayer 1, enter hit row/column:");
                takeTurn("PLAYER 1", "PLAYER 2", player1Shots, player2Board);
                player1Turn = false;
            } else {
                System.out.println("");
                System.out.println("Player 2, enter hit row/column:");
                takeTurn("PLAYER 2", "PLAYER 1", player2Shots, player1Board);
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
        System.out.println("");
        System.out.println("Final boards:");
        System.out.println("");
        printBattleShip(player1Board);
        System.out.println("");
        printBattleShip(player2Board);
        System.out.println("");
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
                System.out.println(String.format("Enter ship %d location:", i));
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


    private static void takeTurn(String playerName1, String playerName2, char[][] shotsBoard, char[][] opponentBoard) {
        while (true) { // 使用无限循环，当有效射击发生时会通过break跳出
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (!isValidLocation(row, col)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
                continue; // 如果坐标无效，立即开始下一次循环迭代
            }
            
            if (shotsBoard[row][col] != EMPTY) {
                System.out.println("You already fired on this spot. Choose different coordinates.");
                continue; // 如果已经射击过，立即开始下一次循环迭代
            }
    
            if (opponentBoard[row][col] == SHIP) {
                System.out.println(String.format("%s HIT %s's SHIP!",playerName1, playerName2));

                shotsBoard[row][col] = HIT;
                opponentBoard[row][col] = HIT; // 标记对手的棋盘上的击中
            } else {
                System.out.println(String.format("%s MISSED!", playerName1));
                shotsBoard[row][col] = MISS;
                opponentBoard[row][col] = MISS;
            }
            break; // 成功射击，跳出循环
        }
        printBattleShip(shotsBoard); // 打印射击后的棋盘
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
        for (int i = 0; i < 100; i++)
            System.out.println();
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
