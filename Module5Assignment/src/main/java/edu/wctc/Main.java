package edu.wctc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Middle initial: ");
        String middleInitial = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Birth year: ");
        int year = scanner.nextInt();

        System.out.print("Birth month: ");
        int month = scanner.nextInt();

        System.out.print("Birth day: ");
        int day = scanner.nextInt();

        System.out.print("Gender (M/F): ");
        char gender = scanner.next().charAt(0);

        try {

            DriversLicense dl = new DriversLicense();

            FirstNameUtility fnUtil = new FirstNameUtility();
            LastNameUtility lnUtil = new LastNameUtility();
            MonthDayGenderUtility mdUtil = new MonthDayGenderUtility();

            dl.setSoundexCode(lnUtil.encodeLastName(lastName));
            dl.setFirstNameMiddleInitial(fnUtil.encodeFirstName(firstName, middleInitial));
            dl.setBirthYear(year % 100);
            dl.setBirthMonthDayGender(mdUtil.encodeMonthDayGender(year, month, day, gender));
            dl.setOverflow(0);

            // adding the minnesota formatter
            DriversLicenseFormatter fl = new FloridaFormatter();
            DriversLicenseFormatter wi = new WisconsinFormatter();
            DriversLicenseFormatter mn = new MinnesotaFormatter();

            // printing ou the minnesota formatter
            System.out.println("Florida License: " + fl.formatLicenseNumber(dl));
            System.out.println("Wisconsin License: " + wi.formatLicenseNumber(dl));
            System.out.println("Minnesota License: " + mn.formatLicenseNumber(dl));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
