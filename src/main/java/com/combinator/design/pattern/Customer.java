package com.combinator.design.pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dob;
}
