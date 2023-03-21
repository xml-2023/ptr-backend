package com.kncm.validator;

public interface ReadValidator<T> {
    ValidationReport validate(T id);
}
