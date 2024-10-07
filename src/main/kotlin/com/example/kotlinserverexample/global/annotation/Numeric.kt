package com.example.kotlinserverexample.global.annotation

import jakarta.validation.Constraint
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [NumericValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class Numeric (
    val message: String = "숫자만 입력 가능합니다.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Any>> = []
){

}