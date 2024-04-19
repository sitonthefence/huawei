package TEST;

public class TEST5版本号比较 {

        public static void main(String[] args) {
            String v1 = "19.1.1.2";
            String v2 = "19.1.1.3";

            boolean result = compareVersions(v1, v2);
            System.out.println(result);
        }

        public static boolean compareVersions(String v1, String v2) {
            String[] version1 = v1.split("\\.");
            String[] version2 = v2.split("\\.");

            int length = Math.max(version1.length, version2.length);

            for (int i = 0; i < length; i++) {
                int num1 = (i < version1.length) ? Integer.parseInt(version1[i]) : -1;
                int num2 = (i < version2.length) ? Integer.parseInt(version2[i]) : -1;

                if (num1 != num2) {
                    return false;
                }
            }

            return true;
        }

}
