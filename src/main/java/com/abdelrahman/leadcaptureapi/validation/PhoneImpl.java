package com.abdelrahman.leadcaptureapi.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneImpl implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
	    if (value == null || value.trim().isEmpty()) {
	        return true; // سيب null/empty لڤاليديتر تاني زي @NotNull
	    }

	    // E.164 format
	    Pattern pattern = Pattern.compile("^01[0125][0-9]{8}$");
	    Matcher matcher = pattern.matcher(value);

	    return matcher.matches();
	}

}
