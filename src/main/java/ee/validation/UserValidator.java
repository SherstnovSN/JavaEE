package ee.validation;

import javax.json.JsonObject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<ValidUser, JsonObject> {

    @Override
    public boolean isValid(JsonObject jsonObject, ConstraintValidatorContext constraintValidatorContext) {
        return jsonObject.getString("name") != null;
    }

    @Override
    public void initialize(ValidUser constraintAnnotation) {
    }

}
