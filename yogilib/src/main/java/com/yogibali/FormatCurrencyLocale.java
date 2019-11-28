package com.yogibali;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatCurrencyLocale {

/**
 * param --> int, double, string
 * FormatCurrencyLocale uangfr=new FormatCurrencyLocale();
    String uangstr=uangfr.toRp(param);*/


    public String toRp(double d) {
        Locale localeID = new Locale("in", "ID");
        String _patern = "'Rp'#,##0.00";
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(localeID);
        decimalFormatSymbols.setCurrencySymbol("Rp");
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat _rupiah = new DecimalFormat(_patern, decimalFormatSymbols);
        return _rupiah.format(d);
    }

    public String toRp(String s) {
        return toRp(Double.valueOf(s));
    }
    public String toRp(int i) {
        return toRp(Double.valueOf(i));
    }
}
