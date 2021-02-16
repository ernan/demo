package com.example.web.api;

import com.example.domain.Individual;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.util.Calendar;

public class IndividualValdator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return cls == Individual.class;
    }

    @Override
    public void validate(Object ip, Errors errors) {
        Individual individual = (Individual) ip;
        if (individual.getName().length() > 25) {
            errors.reject("name", "Name length cannot be more than 25 charachers.");
        }

        Date now = new Date(Calendar.getInstance().getTime().getTime());
        if (individual.getDateOfBirth().after(now)) {
            errors.reject("DateOfBirth", "Date of birth cannot be in the future.");
        }

        int yearsInDays16 = 5844; // 365.25d * 16
        Date nowDt = new Date(Calendar.getInstance().getTime().getTime());
        if (individual.getDateOfBirth().after(nowDt)) {
            errors.reject("DateOfBirth", "Date of birth cannot be in the future.");
        }

        Calendar calendar = Calendar.getInstance(); // this would default to now
        calendar.add(Calendar.DAY_OF_MONTH, -1 * yearsInDays16);
        Date minAgeDt = new Date(calendar.getTime().getTime());
        if (individual.getDateOfBirth().after(minAgeDt)) {
            errors.reject("DateOfBirth", "Person must be older then 16 years.");
        }

        if (!individual.getMobilePhone().startsWith("08")) {
            errors.reject("MobilePhone", "Mobile phone must start with 08.");
        }
    }

}
