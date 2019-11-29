package com.yogibali;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatCurrencyLocale {

/**
 * Standard IDR format
 * param --> int/double/string
 *
    String uangstr=com.yogibali.FormatCurrencyLocale.toIDR(param);*/


    public static String toIDR(double d) {
        Locale localeID = new Locale("in", "ID");
        String _patern = "'Rp'#,##0.00";
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(localeID);
        decimalFormatSymbols.setCurrencySymbol("Rp");
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat _rupiah = new DecimalFormat(_patern, decimalFormatSymbols);
        return _rupiah.format(d);
    }

    public static String toIDR(String s) {
        return toIDR(Double.valueOf(s));
    }
    public static String toIDR(int i) {
        return toIDR(Double.valueOf(i));
    }
}
