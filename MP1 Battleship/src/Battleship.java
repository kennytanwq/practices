import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Battleship {

        int[][] oceanMap = new int[10][10];

        public void printMap() {

            //First row
            printRow();


            //Side rows
            for (int j = 0; j < oceanMap.length; j++) {
                System.out.print(j + "|");

                for (int k = 0; k < oceanMap[j].length; k++) {

                    switch (oceanMap[j][k]) {
                        case 1:     //Player's ship
                            System.out.print("@");
                            break;
                        case 2:     //CPU's ship
                            System.out.print("c");
                            break;
                        case 3:     //Miss
                            System.out.print("-");
                            break;
                        case 4:     //Sunk own ship
                            System.out.print("x");
                            break;
                        case 5:     //Successful guess
                            System.out.print("!");
                            break;
                        default:    //Blank
                            System.out.print(" ");
                    }
                }
                System.out.println("|" + j);
            }

            //Last row
            printRow();
        }

        private void printRow() {
            System.out.print("  ");
            for (int i = 0; i < oceanMap.length; i++) {
                System.out.print(i);
            }
            System.out.print("\n");
        }

        public void deployShip() {

            Scanner input = new Scanner(System.in);

            int shipCount = 1;
            int x,y;

            do {
                try {
                System.out.println("Please enter the X coordinate of Ship# " + shipCount + " : ");
                x = input.nextInt();


                System.out.println("Please enter the Y coordinate of Ship# " + shipCount + " : ");
                y = input.nextInt();


                    if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                        if (isFree(x, y)) {
                            oceanMap[x][y] = 1;
                            shipCount++;
                        }
                    }
                    else {
                            System.out.println("Invalid coordinates! Please only enter numbers ranging from 0-9.");
                    }

            }
                catch (InputMismatchException e) {
                    System.out.println("Invalid coordinates! Please only enter numbers ranging from 0-9.");
                    input.next();
                }
            } while (shipCount < 6);
        }

        public void deployComputerShip() {

            Random rnd = new Random();

            int shipCount = 1;
            int x,y;

            do {
                x = rnd.nextInt(10);
                y = rnd.nextInt(10);


                if (isFree(x,y)) {
                oceanMap[x][y] = 2;
                shipCount++;
                }

            } while (shipCount < 6);
        }

        public boolean isFree(int row, int col) {

            if (oceanMap[row][col] == 0) {
                return true;
            }
            else return false;
        }

        public void startBattle() throws InterruptedException {
            int playerShips = 5;
            int computerShips = 5;
            int x,y;
            Scanner input = new Scanner(System.in);
            Scanner cname = new Scanner(System.in);
            Scanner pname = new Scanner(System.in);

            System.out.println("Enter your name: ");
            String playerName = pname.nextLine();
            playerName = playerName.toUpperCase();
            System.out.println("Enter name of COMPUTER player: ");
            String cpuName = cname.nextLine();
            cpuName = cpuName.toUpperCase();

            //Player's turn
            do {
                System.out.println(" ");
                System.out.println(playerName + "'s TURN");
                System.out.println("----------------");
                System.out.println("Please enter X coordinate: ");
                x = input.nextInt();

                System.out.println("Please enter Y coordinate: ");
                y = input.nextInt();

                if (oceanMap[x][y] == 2) { //Check if CPU ship is there
                    oceanMap[x][y] = 5;
                    computerShips--;
                    System.out.println("Boom! You sunk a ship!");
                    System.out.println(" ");
                }
                else if (oceanMap[x][y] == 1) { //Check if Player's ship is there
                    oceanMap[x][y] = 4;
                    playerShips--;
                    System.out.println("Oops! You sunk your own ship!");
                    System.out.println(" ");
                }
                else {
                    oceanMap[x][y] = 3;
                    System.out.println("Sorry, you missed!");
                    System.out.println(" ");
                }
                Thread.sleep(1000);
                printMap();
                System.out.println(playerName + "'s ships: " + playerShips + " | " + cpuName + "'s ships: " + computerShips);
                Thread.sleep(1000);

                //Computer's turn
                System.out.println(" ");
                System.out.println(cpuName + "'s TURN");
                System.out.println("----------------");

                Random rnd = new Random();
                x = rnd.nextInt(10);
                y = rnd.nextInt(10);

                System.out.println(cpuName + " chose " + x + " " + y);
                if (oceanMap[x][y] == 1) { //Check if Player's ship is there
                    oceanMap[x][y] = 5;
                    computerShips--;
                    System.out.println("Boom! " + cpuName + " sunk one of your ships!");
                    System.out.println(" ");
                }
                else if (oceanMap[x][y] == 2) { //Check if CPU's ship is there
                    oceanMap[x][y] = 4;
                    playerShips--;
                    System.out.println("Oops! " + cpuName + " sunk their own ship!");
                    System.out.println(" ");
                }
                else {
                    oceanMap[x][y] = 3;
                    System.out.println("Congratulations! " + cpuName + " missed your ships!");
                    System.out.println(" ");
                }
                Thread.sleep(1000);
                printMap();
                System.out.println(playerName + "'s ships: " + playerShips + " | " + cpuName + "'s ships: " + computerShips);
                Thread.sleep(1000);

            } while (playerShips > 0 && computerShips > 0);

            if (playerShips > 0 && computerShips == 0) {
                System.out.println("Hurray! You won the game!");
            }
            else System.out.println("Sorry, you have lost the game to " + cpuName + "!");

        }
}
