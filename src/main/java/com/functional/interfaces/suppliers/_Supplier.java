package com.functional.interfaces.suppliers;

import java.util.function.Supplier;

public class _Supplier {

    public int supId;
    public String supName;

    public _Supplier(int supId, String supName) {
        this.supId = supId;
        this.supName = supName;
    }

    // imperative approach
    public int getSupId() {
        return supId;
    }

    public String getSupName() {
        return supName;
    }

    // declarative approach
    Supplier<Integer> getSupIdSupplier = () -> supId;
    Supplier<String> getSupNameSupplier = () -> supName;

    public static void main(String... args) {
        _Supplier supplier = new _Supplier(1, "Subhasish");
        System.out.println(String.format("imperative approach id %s %s ", supplier.getSupId(), supplier.getSupName()));
        System.out.println(String.format("declarative approach id %s %s ", supplier.getSupIdSupplier.get(), supplier.getSupNameSupplier.get()));
    }
}
