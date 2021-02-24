public class BattleshipImpl {
    public static void main(String[] args) throws InterruptedException {

        Battleship myShip = new Battleship();
        //Initialization
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println("Legend: ");
        System.out.println("@ = your own ship, c = CPU ship, ! = successful hit, - = miss, x = hit own ship");
        Thread.sleep(3000);
        System.out.println(" ");
        System.out.println("Right now, the sea is empty.");
        System.out.println(" ");
        Thread.sleep(1500);
        myShip.printMap();
        System.out.println(" ");

        //Player places own ship
        System.out.println("Deploy your ships: ");
        myShip.deployShip();
        myShip.printMap();
        System.out.println(" ");

        System.out.println("Your ships have been placed! Please wait while the Computer places their ships...");
        Thread.sleep(1500);
        System.out.println("#1 Ship DEPLOYED");
        Thread.sleep(300);
        System.out.println("#2 Ship DEPLOYED");
        Thread.sleep(300);
        System.out.println("#3 Ship DEPLOYED");
        Thread.sleep(300);
        System.out.println("#4 Ship DEPLOYED");
        Thread.sleep(300);
        System.out.println("#5 Ship DEPLOYED");
        Thread.sleep(300);
        System.out.println("----------------");
        System.out.println(" ");

        //CPU deploys ships
        myShip.deployComputerShip();
        myShip.printMap();
        Thread.sleep(500);

        //Battle begins until end
        myShip.startBattle();
    }
}
