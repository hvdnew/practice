package chk;

import java.util.stream.IntStream;

public class IntegerToRoman {

    /*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    */

    public static void main(String[] args) {

        System.out.println(new IntegerToRoman().intToRoman(1994));
    }

    public String intToRoman(int num) {

        StringBuffer sb = new StringBuffer();
        int check = num;
        int div = 10;

        while (check > 0) {

            int parse = check % div;
            sb.append(parseToRoman(parse));


            check = check / div;
            check = check * div;
            div *= 10;

        }

        return sb.toString();
    }

    private String parseToRoman(int parse) {

        StringBuffer sb = new StringBuffer();
        ParseAndReject result = null;

        while (result == null || result.reject > 0) {
            result = RomanTuple.parseAndReject(result == null ? parse : result.reject);
            sb.append(result.parse);
        }

        return sb.toString();
    }


    private static final class ParseAndReject {
        final String parse;
        final int reject;

        public ParseAndReject(String parse, int reject) {
            this.parse = parse;
            this.reject = reject;
        }
    }


    private enum RomanTuple {

        I {
            @Override
            ParseAndReject convert(int candidate) {
                StringBuffer sb = new StringBuffer();
                IntStream.range(1, candidate).forEach(i -> sb.append("I"));
                return new ParseAndReject(sb.toString(), 0);
            }

            @Override
            boolean matches(int candidate) {
                return candidate >= 1 && candidate <= 3;
            }
        },

        V {
            @Override
            ParseAndReject convert(int candidate) {

                StringBuffer sb = new StringBuffer();

                int diff = candidate - 5;
                int reject = 0;

                if (diff == -1) {
                    sb.append("IV");
                } else {
                    sb.append("V");
                    reject = diff;
                }

                return new ParseAndReject(sb.toString(), reject);
            }

            @Override
            boolean matches(int candidate) {
                return candidate >= 4 && candidate <= 8;
            }
        },

        X {
            @Override
            ParseAndReject convert(int candidate) {

                if (candidate == 9) {
                    return new ParseAndReject("IX", 0);
                }

                StringBuffer sb = new StringBuffer();
                IntStream.range(1, candidate / 10).forEach(i -> sb.append("X"));

                return new ParseAndReject(sb.toString(), 0);
            }

            @Override
            boolean matches(int candidate) {
                return candidate >= 9 && candidate <= 39;
            }
        }, L {
            @Override
            ParseAndReject convert(int candidate) {

                StringBuffer sb = new StringBuffer();

                int diff = candidate - 50;
                int reject = 0;

                if (diff < 0) {
                    sb.append("IL");
                } else {
                    sb.append("L");
                    reject = diff;
                }

                return new ParseAndReject(sb.toString(), reject);
            }

            @Override
            boolean matches(int candidate) {
                return candidate >= 40 && candidate <= 89;
            }
        }, C {
            @Override
            ParseAndReject convert(int candidate) {
                return null;
            }

            @Override
            boolean matches(int candidate) {
                return false;
            }
        }, D {
            @Override
            ParseAndReject convert(int candidate) {
                return null;
            }

            @Override
            boolean matches(int candidate) {
                return false;
            }
        }, M {
            @Override
            ParseAndReject convert(int candidate) {
                return null;
            }

            @Override
            boolean matches(int candidate) {
                return false;
            }
        };


        abstract ParseAndReject convert(int candidate);

        abstract boolean matches(int candidate);


        public static ParseAndReject parseAndReject(int parse) {

            for (RomanTuple each : RomanTuple.values()) {
                if (each.matches(parse)) {
                    return each.convert(parse);
                }
            }

            throw new IllegalArgumentException("cannot find match for " + parse);
        }

    }

}
