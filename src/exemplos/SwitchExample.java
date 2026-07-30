package exemplos;

import java.util.Scanner;

public class SwitchExample {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the month (1-12): ");
        int month = in.nextInt();

        System.out.print("Is it a leap year? (true/false): ");
        boolean isLeapYear = in.nextBoolean();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31 days");
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30 days");
                break;

            case 2:
                if (isLeapYear) {
                    System.out.println("29 days");
                } else {
                    System.out.println("28 days");
                }
                break;

            default:
                System.out.println("Invalid month.");
        }

        // Limpa o buffer
        in.nextLine();


        System.out.print("\nEnter the day of the week: ");
        String dayOfWeekArg = in.nextLine();

        String typeOfDay;

        switch (dayOfWeekArg) {
            case "Monday":
                typeOfDay = "Start of work week";
                break;

            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;

            case "Friday":
                typeOfDay = "End of work week";
                break;

            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;

            default:
                typeOfDay = "Invalid day";
        }

        System.out.println("Type of day: " + typeOfDay);

        in.close();
    }
}