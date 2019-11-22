package pl.edu.wszib.gui;

import pl.edu.wszib.costume.Costume;
import pl.edu.wszib.db.DBConnector;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Gui {
    private static int helloMenu() {

        while (true) {
            System.out.println("1. Dodanie nowego kostiumu do bazy");
            System.out.println("2. Lista wszystkich kostiumow");
            System.out.println("3. Zmiana rozmiaru kostiumu");
            System.out.println("4. Usuniecie kostiumu");
            System.out.println("5. Sprawdzenie czy kostium jest w bazie");
            System.out.println("6. Koniec");
            Scanner scanner = new Scanner(System.in);
            //int choice = Integer.parseInt(scanner.nextLine());

            String choice = scanner.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
                    || choice.equals("5") || choice.equals("5")) {
                return Integer.parseInt(choice);
            }


        }
    }

    private static Costume choice1() {
        while (true) {
            System.out.println("Nazwa kostiumu: ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            System.out.println("Podaj rozmiar: ");
            String size = scanner.nextLine();

            System.out.println("Podaj ID: ");
            Integer costumeId = scanner.nextInt();

            System.out.println("czy jest dostępny: ");
            Boolean rent = scanner.hasNext();
            Costume costume = new Costume(name, size, costumeId, rent);
            DBConnector.addCostume(name, size, costumeId, rent);
            return costume;


        }
    }

    private static Costume choice2() {
        while (true) {
            List<Costume> costume2 = DBConnector.getAllCostumes();
            for (Costume costume : costume2) {
                System.out.println(costume.getName() + " - " + costume.getSize() + " - " + costume.getCostumeId() + " - "
                        + costume.isRent());



            }return null;

        }
    }

    private static Costume choice3() {
        while (true) {
            System.out.println("Podaj nazwe kostiumu");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            System.out.println("Podaj nowy rozmiar");
            Scanner scanner1 = new Scanner(System.in);
            String size = scanner1.nextLine();
            if ((size.length() > 2)) {
                System.out.println("Za dlugi rozmiar");
            }
            DBConnector.updateCostume(size, name);
            return null;
        }
    }

    private static Costume choice4() {
        while (true) {
            System.out.println("Podaj ID kostiumu, ktore chcesz usunac");
            Scanner scanner = new Scanner(System.in);
            Integer id = scanner.nextInt();
            DBConnector.deleteCostume(id);
            return null;
        }
    }

    private static Costume choice5() {
        while (true) {


            System.out.println("Podaj nazwe kostiumu");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            DBConnector.existCostume(name);
            return null;
        }
    }
    private static Costume choice6(){
        return null;
    }


    public static void appController() {
        while (true) {
            int choice = helloMenu();
            switch (choice) {
                case 1:
                    Costume costume = choice1();
                    helloMenu();
                    break;
                case 2:
                    Costume costume2 = choice2();
                    helloMenu();
                    break;
                case 3:
                    Costume costume3 = choice3();
                    helloMenu();
                    break;
                case 4:
                    Costume costume4 = choice4();
                    helloMenu();
                    break;
                case 5:
                    Costume costume5 = choice5();
                    helloMenu();
                    break;
                case 6:
                    Costume costume6 = choice6();
                            break;
            }
        }
    }
}