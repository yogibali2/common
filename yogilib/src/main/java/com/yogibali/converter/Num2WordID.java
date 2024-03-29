package com.yogibali.converter;

import java.text.DecimalFormat;


public class Num2WordID {
    /**
     * Converting Number into Indonesia Rupiah words.
     * <p>
     * usage:
     * param >> long / string / double / int
     * String duithuruf = com.yogibali.converterNum2WordID.convert(12500));
     * String duithuruf = com.yogibali.converterNum2WordID.convert("12500"));
     */

    private static final String[] tensNames = {
            "",
            " sepuluh",
            " dua puluh",
            " tiga puluh",
            " empat puluh",
            " lima puluh",
            " emnam puluh",
            " tujuh puluh",
            " delapan puluh",
            " sembilan puluh"
    };
    private static final String[] numNames = {
            "",
            " satu",
            " dua",
            " tiga",
            " empat",
            " lima",
            " enam",
            " tujuh",
            " delapan",
            " sembilan",
            " sepuluh",
            " sebelas",
            " dua belas",
            " tiga belas",
            " empat belas",
            " lima belas",
            " enam belas",
            " tujuh belas",
            " delapan belas",
            " sembilan belas"
    };

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " ratus" + soFar;
    }

    public static String convert(String s) {
        return convert(Long.parseLong(s));
    }

    public static String convert(int i) {
        return convert(Long.parseLong(String.valueOf(i)));
    }

    public static String convert(double i) {
        return convert(Long.parseLong(String.valueOf(i)));
    }

    public static String convert(long number) {
        // 0 to 999 999 999 999
        if (number == 0) {
            return "nol";
        }
        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        String snumber = df.format(number);

        // XXXnnnnnnnnn
        int billions = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXXnnnnnn
        int millions = Integer.parseInt(snumber.substring(3, 6));
        // nnnnnnXXXnnn
        int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(9, 12));

        String tradBillions;
        switch (billions) {
            case 0:
                tradBillions = "";
                break;
            default:
                tradBillions = convertLessThanOneThousand(billions)
                        + " milyar ";
        }
        String result = tradBillions;

        String tradMillions;
        switch (millions) {
            case 0:
                tradMillions = "";
                break;
            default:
                tradMillions = convertLessThanOneThousand(millions)
                        + " juta ";
        }
        result = result + tradMillions;

        String tradHundredThousands;
        switch (hundredThousands) {
            case 0:
                tradHundredThousands = "";
                break;
            case 1:
                tradHundredThousands = "seribu ";
                break;
            default:
                tradHundredThousands = convertLessThanOneThousand(hundredThousands)
                        + " ribu ";
        }
        result = result + tradHundredThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}
