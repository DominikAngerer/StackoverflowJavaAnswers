#Question
Link: http://stackoverflow.com/q/28130190/1581725

#Answer
Link: http://stackoverflow.com/a/28130687/1581725

    DecimalFormat currencyFormatter = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());

    currencyFormatter.setMaximumFractionDigits(2); // << This should
    currencyFormatter.setMinimumFractionDigits(2); // << do the trick

    System.out.println(currencyFormatter.format(-123456.7812));

Will output:

    -123,456.78

Or if you have a locale like `Locale.GERMANY`:

    -123.456,78

**Update:**
I prepared an **online java testing** for you here: 
http://goo.gl/wq7aa5
All you have to do is press: `compile` and `execute`. Hope you like it.

**Update: (Simple copy & paste)**

    DecimalFormat dFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
    dFormat.setMaximumFractionDigits(2); // << This should
    dFormat.setMinimumFractionDigits(2); // << do the trick
    etPayment.setText(dFormat.format(p));