package constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Constraint validate date range
 *
 * @author gandrieu
 * @version 1.0
 */

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface DateRangeConstraint {
    String dateStart();
    String dateEnd();

    String message() default "{DateRangeConstraint.fieldmatch}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @interface List
    {
        DateRangeConstraint[] value();
    }
}
