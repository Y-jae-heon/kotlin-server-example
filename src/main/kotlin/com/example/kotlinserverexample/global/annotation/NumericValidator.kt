package com.example.kotlinserverexample.global.annotation

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class NumericValidator: ConstraintValidator<Numeric, Int?> {
    override fun isValid(value: Int?, context: ConstraintValidatorContext): Boolean {
        if (value == null) return true  // null 값은 @NotNull에서 처리
        return value.toString().matches(Regex("^[0-9]+$"))
    }
}