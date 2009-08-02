package com.wee.voyages.domain.model.customer;

/**
 * User: weejulius
 * Date: 2009-7-24
 * Time: 21:15:25
 */
public class IdentifyingCode {
    private final static IdentifyingCode ic = new IdentifyingCode();
    private final static int[] weights = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private final static String[] mappedNum = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    private IdentifyingCode() {
    }

    public static IdentifyingCode instance() {
        return ic;
    }

    public boolean validateCode(String idcardNum) {
        int length=idcardNum.length();
        String idcardWithoutIC=idcardNum.substring(0,length-1);
        String IC=idcardNum.substring(length-1,length);
        return new CodeGenerator().generate(idcardWithoutIC).equals(IC);
    }

    public static class CodeGenerator {


        public CodeGenerator() {

        }

        public String generate(String idcardNum) {
            int[] nums = parse(idcardNum.toCharArray());
            return map(modByeleven(totalWithWeight(nums)));
        }

        private int[] parse(char[] chars) {
            int[] result = new int[chars.length];
            int index = 0;
            for (char aChar : chars) {
                result[index] = aChar - 48;
                index++;
            }
            return result;
        }

        private int totalWithWeight(int[] nums) {
            int result = 0;
            int index = 0;
            for (int num : nums) {
                result += num * weights[index++];
            }
            return result;
        }

        private int modByeleven(int num) {
            return num % 11;
        }

        private String map(int num) {
            return mappedNum[num];
        }
    }

}
