package net.wowdev.ecommerce.domain.generator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.hibernate.annotations.ValueGenerationType;

/** Marks an order number as generated before an entity is inserted. */
@ValueGenerationType(generatedBy = OrderNumberGenerator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface GeneratedOrderNumber {
  String sequenceName() default "order_number_seq";
}
