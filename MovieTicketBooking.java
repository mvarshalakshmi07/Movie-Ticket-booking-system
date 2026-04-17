import java.util.*;
public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Integer> shows = new HashMap<>();

        shows.put("Avengers", 50);
        shows.put("Leo", 40);
        shows.put("Jailer", 30);

        int choice = 0;

        while (choice != 4) {
            System.out.println("===== Movie Ticket Booking System =====");
            System.out.println("1. View Shows");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = s.nextInt();
                s.nextLine();
                if (choice == 1) {
                    System.out.println("Available Shows:");
                    for (Map.Entry<String, Integer> entry : shows.entrySet()) {
                        System.out.println(entry.getKey() + " - Seats Available: " + entry.getValue());
                    }
                }

                else if (choice == 2) {
                    System.out.print("Enter Movie Name: ");
                    String movie = s.nextLine();
                    if (shows.containsKey(movie)) {
                        System.out.print("Enter number of seats: ");
                        int seats = s.nextInt();
                        s.nextLine();
                        int available = shows.get(movie);
                        if (seats <= available) {
                            shows.put(movie, available - seats);
                            System.out.print("Enter Customer Name: ");
                            String customer = s.nextLine();
                            System.out.println("Booking successful for " + customer);
                        }
                        else {
                            System.out.println("Not enough seats available.");
                        }
                    }
                    else {
                        System.out.println("Movie not found.");
                    }
                }

                else if (choice == 3) {
                    System.out.print("Enter Movie Name to cancel: ");
                    String movie = s.nextLine();
                    if (shows.containsKey(movie)) {
                        System.out.print("Enter seats to cancel: ");
                        int seats = s.nextInt();
                        s.nextLine();
                        int available = shows.get(movie);
                        shows.put(movie, available + seats);
                        System.out.println("Ticket cancelled successfully.");
                    }
                    else {
                        System.out.println("Movie not found.");
                    }
                }

                else if (choice == 4) {
                    System.out.println("Exiting...");
                }
                else {
                    System.out.println("Invalid choice!");
                }
            }

            catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                s.nextLine();
            }
        }
        s.close();
    }
}