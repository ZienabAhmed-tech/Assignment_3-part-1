
import java.util.Scanner;

public class Cinema_Ticket {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[][] seats = new char[5][6];

        String[] movieNames = {
            "Superman", "Avatar", "Minecraft", "Inside Out", "F1"
        };

        int choice;
        int bookSeat;


        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'O';
            }
        }

        while (true) {

            System.out.println("\nMain Menu");
            System.out.println("1. Display Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show all movies");
            System.out.println("5. Show number of available and booked seats");
            System.out.println("0. Exit");

            System.out.print("Please enter your choice: ");
            choice = input.nextInt();

            if (choice == 1) {

                displaySeats(seats);

            }

            else if (choice == 2) {

                System.out.println("Please enter seat number: ");
                bookSeat = input.nextInt();

                int row = bookSeat / 10;
                int column = bookSeat % 10;

                if (row < 1 || row > 5 || column < 1 || column > 6) {

                    System.out.println("Invalid Seat.");

                }

                else if (seats[row - 1][column - 1] == 'X') {

                    System.out.println("Seat is already booked.");

                }

                else {

                    seats[row - 1][column - 1] = 'X';

                    System.out.println("Seat booked successfully.");
                }

            }

            else if (choice == 3) {

                System.out.println("Please enter seat number to cancel: ");
                bookSeat = input.nextInt();

                int row = bookSeat / 10;
                int column = bookSeat % 10;

                if (row < 1 || row > 5 || column < 1 || column > 6) {

                    System.out.println("Invalid Seat.");

                }

                else if (seats[row - 1][column - 1] == 'O') {

                    System.out.println("Seat is not booked.");

                }

                else {

                    seats[row - 1][column - 1] = 'O';

                    System.out.println("Booking cancelled successfully.");
                }

            }

            else if (choice == 4) {

                showMovies(movieNames);

            }

            else if (choice == 5) {

                showSeatsCount(seats);

            }

            else if (choice == 0) {

                System.out.println("Goodbye!");
                break;

            }

            else {

                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }

    // Function to display seats

    public static void displaySeats(char[][] seats) {

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                System.out.print(seats[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Function to show movies

    public static void showMovies(String[] movieNames) {

        for (int i = 0; i < movieNames.length; i++) {

            System.out.println((i + 1) + ". " + movieNames[i]);
        }
    }

    // Function to count available and booked seats

    public static void showSeatsCount(char[][] seats) {

        int available = 0;
        int booked = 0;

        for (int i = 0; i < seats.length; i++) {

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == 'O') {

                    available++;

                }

                else if (seats[i][j] == 'X') {

                    booked++;
                }
            }
        }

        System.out.println("Available Seats: " + available);
        System.out.println("Booked Seats: " + booked);
    }
}


