package edu.wctc;

import java.time.DateTimeException;
import java.time.LocalDate;

public class MonthDayGenderUtility {

    private final int MOD_MALE = 0;
    private final int MOD_FEMALE = 500;

    private final char CODE_MALE = 'M';
    private final char CODE_FEMALE = 'F';

    public int encodeMonthDayGender(int year, int month, int day, char genderCode)
            throws UnknownGenderCodeException, InvalidBirthdayException {

        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            throw new InvalidBirthdayException(year, month, day);
        }

        int genderMod;

        if (genderCode == CODE_MALE) {
            genderMod = MOD_MALE;
        } else if (genderCode == CODE_FEMALE) {
            genderMod = MOD_FEMALE;
        } else {
            throw new UnknownGenderCodeException(genderCode);
        }

        return (month - 1) * 40 + day + genderMod;
    }
}
