import java.util.Scanner;

public class CondoManagementSystem {
    static Scanner input = new Scanner(System.in);

    public static void buyCondo(String[][] array, int floor, int room) {
        int n, m;

        System.out.println("\n---------------------------- Buy Condo ----------------------------");

        while (true) {
            System.out.print("-> Enter your desire floor : ");
            n = input.nextInt();
            if (n <= 0 || n > floor) {
                System.out.println(">> FLOOR RANGE START FROM 1 - " + floor);
            } else break;
        }
        while (true) {
            System.out.print("-> Enter your desire room : ");

            m = input.nextInt();
            if (m <= 0 || m > room) {
                System.out.println(">> ROOM RANGE START FROM 1 - " + room);
            } else break;
        }
        if (array[n - 1][m - 1] != null) {
            System.out.println(">> ROOM IS ALREADY OCCUPIED!");
        } else {
            System.out.print("-> Enter the room's owner : ");
            array[n - 1][m - 1] = input.next();
            System.out.println(">> YOU'VE SUCCESSFULLY BOUGHT A CONDO");
        }

        System.out.println("-------------------------------------------------------------------");
    }

    public static void displayInfo(String[][] array, int floor, int room) {
        System.out.println("\n------------------ Display Condo's Information --------------------");
        for (int i = floor - 1; i >= 0; i--) {
            System.out.print("\tFloor  [" + (int) (i + 1) + "]  =>   ");
            for (int j = 0; j < room; j++) {
                System.out.print(array[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public static void sellCondo(String[][] array, int floor, int room) {
        int n, m;
        int confirmation;
        System.out.println("\n--------------------------- Sell Condo ----------------------------");

        while (true) {
            System.out.print("-> Enter the floor : ");
            n = input.nextInt();
            if (n <= 0 || n > floor) {
                System.out.println(">> FLOOR RANGE START FROM 1 - " + floor);
            } else break;
        }
        while (true) {
            System.out.print("-> Enter the room : ");
            m = input.nextInt();
            if (m <= 0 || m > room) {
                System.out.println(">> ROOM RANGE START FROM 1 - " + room);
            } else break;
        }
        if (array[n - 1][m - 1] == null) {
            System.out.println(">> CANNOT SELL THE CONDO, YOU DON'T HAVE THE OWNER SHIP");
        } else {
            System.out.println(">> Selected condo's information : ");
            System.out.println("\tFloor : " + n);
            System.out.println("\tRoom : " + m);
            System.out.println("\tCondo belong to : " + array[n - 1][m - 1]);
            System.out.print("-> Enter 1 to confirm and 0 to cancel : ");
            confirmation = input.nextInt();
            if (confirmation == 0) {
                System.out.println("=> Selling condo process has been canceled!");
            } else {
                array[n - 1][m - 1] = null;
                System.out.println(">> YOU'VE SUCCESSFULLY SOLD YOUR CONDO!");
            }
        }

        System.out.println("-------------------------------------------------------------------");
    }

    public static void searchCondo(String[][] array, int floor, int room) {

        int opt;
        boolean quit = false;

        outerloop:
        do {
            boolean found = false;
            System.out.println("\n----------------------- Search Condo's Information -----------------------");
            System.out.println("1. Search by owner's name");
            System.out.println("2. Search by floor");
            System.out.println("3. Exit");
            System.out.println("-------------------------------------------------------------------");

            System.out.print("-> Please choose an option : ");
            opt = input.nextInt();

            switch (opt) {
                case 1 -> {
                    System.out.println("\n-------------------- Search by owner's name ---------------------");
                    System.out.print("-> Enter the owner name : ");
                    String name = input.next();
                    for (int i = 0; i < floor; i++) {
                        for (int j = 0; j < room; j++) {
                            if (name.equalsIgnoreCase(array[i][j])) {
                                found = true;
                                System.out.println("=> Condo owner name " + name + " stays in room no. " + (int) (j + 1) + ", floor no. " + (int) (i + 1) + ".");
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("=> Owner name " + name + " doesn't exist on our system!");
                    }
                }
                case 2 -> {
                    System.out.println("\n----------------------- Search by floor ------------------------");
                    System.out.print("-> Enter the floor number :");
                    int searchFloor = input.nextInt();
                    for (int i = 0; i < floor; i++) {
                        if ((int) (searchFloor - 1) == i) {
                            found = true;
                            System.out.print("\tFloor  [" + (int) (i + 1) + "]  =>   ");
                            for (int j = 0; j < room; j++) {
                                System.out.print(array[i][j] + "\t\t");
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("\tFloor " + searchFloor + " doesn't exist on our system!");
                    }
                }
                case 3 -> {
                    System.out.println("=> Exiting searching program...");
                    return;
                }
                default -> {
                    System.out.println("=> Invalid option, please choose again!");
                }
            }
            input.nextLine();
            System.out.println("=> Press any key to continue!");
            input.nextLine();
        } while (opt != 3);

        System.out.println("-------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        int floor, room, opt;

        System.out.println("========================= Set up the Condo =========================");
        while (true) {
            System.out.print("-> Enter the number of floor : ");
            if ((floor = input.nextInt()) <= 0) {
                System.out.println(">> FLOOR CANNOT BE ZERO OR NEGATIVE!");
            } else break;
        }
        while (true) {
            System.out.print("-> Enter the number of room : ");
            if ((room = input.nextInt()) <= 0) {
                System.out.println(">> FLOOR CANNOT BE ZERO OR NEGATIVE!");
            } else break;
        }

        String[][] condo = new String[floor][room];
        System.out.println("===================================================================");
        System.out.println("\tYou've successfully set up the condo!");
        System.out.println("\tThere are " + floor + (floor == 1 ? " floor" : " floors") + " and " + room + (room == 1 ? " room." : " rooms."));
        System.out.println("\tTotal condo : " + floor * room + (floor == 1 && room == 1 ? " condo" : " condos"));
        System.out.println("===================================================================");

        System.out.println("\n===================== WELCOME TO JS CONDO =========================");
        do {
            System.out.println("\n---------------------------- OPTIONS-------------------------------");
            System.out.println("1. Buy Condo");
            System.out.println("2. Sell Condo");
            System.out.println("3. Search Information");
            System.out.println("4. Display Information");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("-> Please choose an option : ");
            opt = input.nextInt();

            switch (opt) {
                case 1 -> {
                    buyCondo(condo, floor, room);
                }
                case 2 -> {
                    sellCondo(condo, floor, room);
                }
                case 3 -> {
                    searchCondo(condo, floor, room);
                }
                case 4 -> {
                    displayInfo(condo, floor, room);
                }
                case 5 -> {
                    System.out.println("=> Exiting program...");
                }
                default -> {
                    System.out.println("=> Invalid option, please choose again!");
                }
            }
            input.nextLine();
            System.out.print("=> Press any key to continue!");
            input.nextLine();
        } while (opt != 5);
    }
}
