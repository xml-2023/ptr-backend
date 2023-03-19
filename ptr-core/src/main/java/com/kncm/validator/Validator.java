package com.kncm.validator;

public interface Validator<T> {
    ValidationReport validate(T model);
}
