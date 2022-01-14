package com.combinator.design.pattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.regex.Pattern;

enum ValidationResult {
    SUCCESS,
    INVALID_EMAIL_ID,
    INVALID_PHONE_NUMBER,
    UNDER_AGED
}

public interface CustomerRegistrationValidatorCombinator extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidatorCombinator isEmailValid() {
        return customer -> Pattern.compile("^[A-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[A-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" +
                ")*@[A-Z0-9-]+(?:\\.[A-Z0-9-]+)*$", Pattern.CASE_INSENSITIVE).matcher(customer.getEmail()).find() ? ValidationResult.SUCCESS : ValidationResult.INVALID_EMAIL_ID;
    }

    static CustomerRegistrationValidatorCombinator isPhoneNumberValid() {
        return customer -> Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$").matcher(customer.getPhoneNumber()).find() ? ValidationResult.SUCCESS : ValidationResult.INVALID_PHONE_NUMBER;
    }

    static CustomerRegistrationValidatorCombinator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS : ValidationResult.UNDER_AGED;
    }

    default CustomerRegistrationValidatorCombinator and(CustomerRegistrationValidatorCombinator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

}
