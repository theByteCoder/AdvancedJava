package com.combinator.design.pattern;

import java.time.LocalDate;

import static com.combinator.design.pattern.CustomerRegistrationValidatorCombinator.isEmailValid;
import static com.combinator.design.pattern.CustomerRegistrationValidatorCombinator.isPhoneNumberValid;
import static com.combinator.design.pattern.CustomerRegistrationValidatorCombinator.isAdult;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Test",
                "test@test.com",
                "2055550125",
                LocalDate.of(1992, 02, 23));
        System.out.println(CustomerValidatorService.isCustomerValid.test(customer));

        ValidationResult isCustomerValid = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println("Combinator pattern, is customer valid - " + isCustomerValid);
    }
}
