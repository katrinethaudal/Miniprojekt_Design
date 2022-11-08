package tui;
import java.util.Scanner;


public class LPMenu {
    
    public LPMenu() {

    }
    
    public void start() {
        LPMenu();
    }
    
        private void LPMenu() {
        boolean running = true;
        while (running) {
            int choice = writeLPMenu();
            switch (choice) {
                case 1:
                  System.out.println(" Denne er ikke implementeret endnu!");
                  break;
                case 0:
                  running = false;
                  break;
                default:
                  System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                  break;
            }
        }
    }
    
    private int writeLPMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** LP menu ******");
        System.out.println(" (1) HVAD SKAL DEN KUNNE HER");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
        private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}