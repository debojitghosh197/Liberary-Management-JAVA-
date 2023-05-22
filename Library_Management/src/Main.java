import java.util.Random;
import java.util.HashSet;
import java.util.Scanner;

class Library {
    private String[] bookanme = new String[100000];
    private String[][] issue_return = new String[100000][2];
    private long[][] details = new long[100000][3];

    public void buy(int x) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter Book Name - ");
        bookanme[x] = sc.nextLine();
        System.out.println();

        System.out.print("Enter the Book Price");
        double bookprice = sc.nextDouble();
        System.out.println();

        System.out.print("Enter Book ID - ");
        details[x][0] = sc.nextInt();
        System.out.println();

        System.out.print("Enter the Total Number Of Books - ");
        details[x][1] = sc.nextInt();
        System.out.println();

        System.out.print("Total BILL AMOUNT - ");
        details[x][2] = (long) (details[x][1] * bookprice);

        System.out.print("Press y/n to confirm the order: ");
        char ch = sc.next().charAt(0);
        System.out.println();

        if (ch == 'y' || ch == 'Y') {
            System.out.println("Order Confirmed");
            System.out.println("!!Thank You For Your Time Visit Again!!");
        }
        System.out.println();
    }

    public void issueBooks(int x) {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter Book Name - ");
        bookanme[x] = sc.nextLine();
        System.out.println();

        System.out.print("Enter the total number of books - ");
        details[x][1] = sc.nextInt();
        System.out.println();

        System.out.print("Enter Issue Date: ");
        sc.nextLine();
        issue_return[x][0] = sc.nextLine();
        System.out.println();

        System.out.print("Enter Return Date: ");
        issue_return[x][1] = sc.nextLine();
        System.out.println();
        
        System.out.print("Press y/n to confirm the Issue: ");
        char ch = sc.next().charAt(0);
        System.out.println();

        if (ch == 'y' || ch == 'Y') {
            System.out.println("Issue Confirmed");
            System.out.println("!!Thank You For Your Time Visit Again!!");
        }
        System.out.println();
    }

    public void getBuydetails(int x) {
        if (bookanme[x] != null && details[x][0] != 0 && details[x][1] != 0 && details[x][2] != 0) {
            System.out.println();
            System.out.print("Book Name - " + bookanme[x]);
            System.out.println();

            System.out.print("Book ID - " + details[x][0]);
            System.out.println();

            System.out.print("Total number of books - " + details[x][1]);
            System.out.println();

            System.out.print("Total BILL AMOUNT - " + details[x][2]);
            System.out.println();

        } else {
            System.out.println("Sorry no data found on this data code.");
        }
        System.out.println();
    }

    public void getIssueDetails(int x) {
        if (bookanme[x] != null && details[x][1] != 0 && issue_return[x][0] != null && issue_return[x][1] != null) {
            System.out.print("Book Name - " + bookanme[x]);
            System.out.println();

            System.out.print("Total number of books - " + details[x][1]);
            System.out.println();

            System.out.print("Issue Date - " + issue_return[x][0]);
            System.out.println();

            System.out.print("Book Return Date - " + issue_return[x][1]);
            System.out.println();
        } else {
            System.out.println("Sorry no data found on this data code.");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        boolean config = true;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        Library lib = new Library();

        while (config == true) {

            int randomNumber = random.nextInt(100000);
            boolean containsElement = hashSet.contains(randomNumber);

            if (containsElement == false) {
                hashSet.add(randomNumber);
                System.out.println("****************** Welcome To Our Library *******************");
                System.out.println("*                👇Select any of the option👇                *");
                System.out.println("*                    ---1.Buy Books---                      *");
                System.out.println("*                   ---2.Issue Books---                     *");
                System.out.println("*                  ---3.Issued Details---                   *");
                System.out.println("*                  ---4.Buying Details---                   *");
                System.out.println("*                        --5.Exit--                         *");
                System.out.println("*************************************************************");
                System.out.println();

                System.out.print("Enter your option --> ");
                int optionInp = sc.nextInt();

                switch (optionInp) {
                    case 1:
                        System.out.print("Your Unique Data Code - " + randomNumber);
                        System.out.println();
                        System.out.println("Enter this code to check your details.");
                        lib.buy(randomNumber);
                        break;
                    case 2:
                        System.out.print("Your Unique Data Code - " + randomNumber);
                        System.out.println();
                        System.out.println("Enter this code to check your details.");
                        lib.issueBooks(randomNumber);
                        break;
                    case 3:
                        System.out.println("Enter the Data code: ");
                        int code = sc.nextInt();
                        lib.getIssueDetails(code);
                        break;
                    case 4:
                        System.out.println("Enter the Data code: ");
                        int code1 = sc.nextInt();
                        lib.getBuydetails(code1);
                        break;
                    case 5:
                        config = false;
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;
                }
            }
        }
    }
}