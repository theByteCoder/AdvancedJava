package com.combinator.design.pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class CustomerValidatorService {

    public static Function<String, Boolean> isEmailValid = email -> {
        Pattern pattern = Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +
                ")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(email).find();
    };

    public static Function<String, Boolean> isPhoneNumberValid = phoneNumber -> {
        Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
        return pattern.matcher(phoneNumber).find();
    };

    public static Function<LocalDate, Boolean> isAdult = dob -> Period.between(dob, LocalDate.now()).getYears() > 18;

    public static Predicate<Customer> isCustomerValid = customer -> {
        return isEmailValid.apply(customer.getEmail())
                && isPhoneNumberValid.apply(customer.getPhoneNumber())
                && isAdult.apply(customer.getDob());
    };
}
