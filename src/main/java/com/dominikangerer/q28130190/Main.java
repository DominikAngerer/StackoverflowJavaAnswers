package com.dominikangerer.q28130190;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		// Locale US
		
		DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat
				.getInstance(Locale.US);

		currencyFormatter.setMaximumFractionDigits(2); // << This should
		currencyFormatter.setMinimumFractionDigits(2); // << do the trick

		System.out.println(currencyFormatter.format(-123456.7812));
		
		// Locale GERMANY
		
		currencyFormatter = (DecimalFormat) NumberFormat
				.getInstance(Locale.GERMANY);

		currencyFormatter.setMaximumFractionDigits(2); // << This should
		currencyFormatter.setMinimumFractionDigits(2); // << do the trick

		System.out.println(currencyFormatter.format(-123456.7812));
	}

}
