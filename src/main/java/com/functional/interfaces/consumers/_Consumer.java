package com.functional.interfaces.consumers;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String... args) {
        Customer subhasish = new Customer(1, "Subhasish");
        custDetails(subhasish);
        custDetailsConsumer.accept(subhasish);
    }

    // imperative approach
    static void custDetails(Customer customer) {
        System.out.println("imperative approach " + customer.toString());
    }

    // declarative approach
    static Consumer<Customer> custDetailsConsumer = customer -> {
        System.out.println("declarative approach " + customer.toString());
    };

    static class Customer {
        private int custId;
        private String custName;

        public Customer(int custId, String custName) {
            this.custId = custId;
            this.custName = custName;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "custId=" + custId +
                    ", custName=" + custName +
                    '}';
        }
    }
}
