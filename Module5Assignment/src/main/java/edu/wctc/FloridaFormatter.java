package edu.wctc;

public class FloridaFormatter implements DriversLicenseFormatter {

    @Override
    public String formatLicenseNumber(DriversLicense dl) {

        return dl.getSoundexCode() + "-" +
                dl.getFirstNameMiddleInitial() + "-" +
                dl.getBirthYear() + "-" +
                dl.getBirthMonthDayGender() + "-" +
                dl.getOverflow();
    }
}
