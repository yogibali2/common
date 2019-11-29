package com.yogibali.converter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CurrencyLocaleIDR {

    /**
     * Standard IDR format
     * <p>
     * 1. Simbol Rp Diikuti Angka Tanpa Spasi atau Titik dan Diikuti Desimal (,00)
     * contoh: Rp1.000,00
     * 2. Penulisan dengan Huruf
     * contoh: Rp10ribu, sepuluh ribu rupiah
     * 3. Penggunaan IDR
     * contoh: 10.000 IDR
     * <p>
     * Usage:
     * param --> int/double/string
     * String uangstr=com.yogibali.converter.CurrencyLocaleIDR.toIDR(param);
     */

// 1. Simbol Rp Diikuti Angka Tanpa Spasi atau Titik dan Diikuti Desimal (,00)
    public static String formatRp(double d) {
        Locale localeID = new Locale("in", "ID");
        String _patern = "'Rp'#,##0.00";
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(localeID);
        decimalFormatSymbols.setCurrencySymbol("Rp");
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat _rupiah = new DecimalFormat(_patern, decimalFormatSymbols);
        return _rupiah.format(d);
    }

    public static String formatRp(String s) {
        return formatRp(Double.valueOf(s));
    }

    public static String formatRp(int i) {
        return formatRp(Double.valueOf(i));
    }

    // 2. Penulisan dengan Huruf
    public static String formatWordRp(long l) {
        String _loc1 = Num2WordID.convert(l);
        return _loc1;
    }

    public static String formatWordRp(double d) {
        String _loc1 = Num2WordID.convert(d);
        return _loc1;
    }

    public static String formatWordRp(String s) {
        String _loc1 = Num2WordID.convert(s);
        return _loc1;
    }

    public static String formatWordRp(int i) {
        String _loc1 = Num2WordID.convert(i);
        return _loc1;
    }

    // 3. Penggunaan IDR not test yet
    public static String formatIDR(double d) {
        Locale localeID = new Locale("in", "ID");
        String _patern = "#.##0,00' IDR'";
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(localeID);
        decimalFormatSymbols.setCurrencySymbol("IDR");
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        DecimalFormat _rupiah = new DecimalFormat(_patern, decimalFormatSymbols);
        return _rupiah.format(d);
    }

    public static String formatIDR(String s) {
        return formatIDR(Double.valueOf(s));
    }

    public static String formatIDR(int i) {
        return formatIDR(Double.valueOf(i));
    }
}
