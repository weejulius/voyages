package com.wee.voyages.application.validatation;

import com.wee.voyages.application.validatation.validator.Validator;

/**
 * User: weejulius
 * Date: 2009-7-26
 * Time: 21:15:44
 */
public class Validators {

    public static void validate(Validatable validatable) {
        Validator validator = ValidatorBinder.get(validatable);//.validate(validatable);
        if (Objects.existSuchA(validator)) {
            validator.validate(validatable);
        } else {
            throw new NoSuchObjectException("validator of " + validatable.getClass().getName() + " does not exist");
        }
    }


}
