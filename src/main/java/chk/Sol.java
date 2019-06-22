package chk;

import java.util.ArrayList;
import java.util.List;

public class Sol {

    private static final int ZIG = 0;
    private static final int ZAG = 1;

    public static void main(String[] args) {

        Sol so = new Sol();
        String result = so.convert("orfefwofihmozumjkgeilldtosfnorocltisrxxbelrdhdormtaxeftuxyhosxsdtbxkyuoehfkolyfxthwympskqcaibsnutkhtevylciznigkcohccywooaoychlycvfwbcuofepuowfqmouoordfttdvapudkbzmgvclzsfpomiaccqtvvyppdmrsiufkvtqqvdrnkjbzrddtwwrtwiiaucsdwzpushmomgdyphxgmdbibucycmyxoscnutjmcvcqdgoupocbremuaqsdcsctneihzrvboyrsghmvvpyovkjvadadwcylggshzninnbhvjusglrvibgdejgjfihqrpkyoajdpkllvhfeswzaahfeqlnyuwqnlblbdwesjpdewjiohjqjqynjlchhyxulagmdcrwlgbsfmcvwomfgmtpxxyfywzjyhycmpyxxbrcowakkmpqakixkgciectdjrhvghvgiokykkkuycnymvwydagicanorwladiilxsmhfwedytenocltcsdfusvnognrrvfoqrxvpdyowedmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhxkjvcxnpglnbnfxjkxspbuoiphimjhvgteewbrnhcajqhibugtjjqzrfgctploygteewvrgaupsbztxhohqegkmpmfezuefpiklgbrgviazktwrjfiooucdihjhdqosayegcxozgoaqjzjtgtjunlzvuleydvqdtwkxuazcpzuaafthzedorfmmqqktlcyhbigvjfzahvahawozcsouxaipsukgwipztvuebvgiqgpregqhagdzilobfajdiyddtzhwvpgnwyecexlgfofozvrgvamfarlvsuspkydiyjkegwkokpcmkvuhvipvzaquwkjglmojyzogxyuhqwvctsmoadlcfewbqfibuwnuxdaudvevtbyntmdup",
                620);
        System.out.println(result);

    }


    public String convert(String str, int numRows) {

        List<Tuple> outputList = getTuples(str, numRows);
        int columnSize = countColumns(outputList);
        String[][] output = new String[numRows][columnSize];

        int colIdx = 0;

        for (Tuple tuple : outputList) {
            System.out.println("processing " + tuple);

            if (tuple.type == ZIG) {
                int row = 0;
                for (char _ch : tuple.str.toCharArray()) {
                    output[row][colIdx] = _ch + "";
                    row++;
                }
                colIdx++;
            } else {

                int row = numRows > 2 ? numRows - 2 : 0;
                for (char _ch : tuple.str.toCharArray()) {
                    output[row][colIdx] = _ch + "";
                    row--;
                    colIdx++;
                }

            }
        }


        printArr(output);
        return toStr(output);
    }

    private int countColumns(List<Tuple> tuples) {

        return tuples.stream()
                .mapToInt(tuple -> {
                    if (tuple.type == ZIG) {
                        return 1;
                    } else {
                        return tuple.str.length();
                    }
                })
                .sum();
    }

    private List<Tuple> getTuples(String str, int numRows) {
        List<Tuple> outputList = new ArrayList<>();

        int zigLength = numRows;
        int zagLength = numRows > 2 ? numRows - 2 : 0;

        int counter = 1;
        for (int i = 0; i < str.length(); i++) {

            if (counter % 2 != 0 || zagLength == 0) {
                // ZIG
                int endIndex = getEndIndex(str, zigLength, i);
                outputList.add(new Tuple(ZIG, str.substring(i, endIndex)));
                i = endIndex - 1;
                counter++;
            } else {
                // ZAG
                int endIndex = getEndIndex(str, zagLength, i);
                outputList.add(new Tuple(ZAG, str.substring(i, endIndex)));
                i = endIndex - 1;
                counter++;
            }
        }

        return outputList;
    }

    private int getEndIndex(String str, int zigLength, int i) {
        return (i + zigLength > str.length() - 1) ? str.length() : i + zigLength;
    }

    private void printArr(String[][] output) {

        for (String[] row : output) {
            for (String str : row) {
                System.out.print((str == null ? " " : str) + "\t");
            }
            System.out.println();
        }

    }

    private String toStr(String[][] output) {

        StringBuffer sb = new StringBuffer();
        for (String[] row : output) {
            for (String eachStr : row) {
                if (eachStr == null) {
                    continue;
                }
                sb.append(eachStr);
            }
        }
        return sb.toString();
    }

    private static final class Tuple {

        int type;

        String str;

        public Tuple(int type, String str) {
            this.type = type;
            this.str = str;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "type=" + type +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

}
