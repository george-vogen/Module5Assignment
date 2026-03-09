package edu.wctc;

// added a minnesota formatted driver's license
public class MinnesotaFormatter implements DriversLicenseFormatter {

    @Override
    public String formatLicenseNumber(DriversLicense driversLicense) {

        return driversLicense.getSoundexCode() + "-" +
                driversLicense.getFirstNameMiddleInitial() + "-" +
                driversLicense.getBirthYear() +
                driversLicense.getBirthMonthDayGender() + "-" +
                driversLicense.getOverflow();
    }
}
