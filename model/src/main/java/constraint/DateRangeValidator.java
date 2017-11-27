package constraint;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * Constraint validate date range
 *
 * @author gandrieu
 * @version 1.0
 */

public class DateRangeValidator implements ConstraintValidator<DateRangeConstraint, Object>{
    private String dateStart;
    private String dateEnd;

    /**
     * Initialize DateRangeConstraint
     *
     * @param dateRangeValidator
     */
    @Override
    public void initialize(DateRangeConstraint dateRangeValidator) {
        this.dateStart = dateRangeValidator.dateStart();
        this.dateEnd = dateRangeValidator.dateEnd();
    }

    /**
     * Control if is valid
     *
     * @param date
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object date, ConstraintValidatorContext constraintValidatorContext) {

        // Try if dateStart is previous to dateEnd
        try {
            Date dateStartValue = (Date) new BeanWrapperImpl(date).getPropertyValue(dateStart);
            Date dateEndValue = (Date) new BeanWrapperImpl(date).getPropertyValue(dateEnd);

            if (dateEndValue != null && dateStartValue != null) {
                return dateEndValue.compareTo(dateStartValue) >= 0;
            } else
                return false;

        }catch(final Exception ignore){
            ignore.printStackTrace();
            return false;
        }
    }

    // Getters / Setters
    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
}
