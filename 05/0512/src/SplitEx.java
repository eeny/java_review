public class SplitEx {
    public static void main(String[] args) {
        String str = "1,2,3,4,5";
        String str2 = "1#2#3#4#5";
        String str3 = "1,a/2,b/3,c/4,d/5,e";

        String[] strA = str.split(",");
        //strA[0] = 1
        for (int i = 0; i < strA.length; i++) {
            System.out.println(strA[i]);
        }

        String[] strB = str2.split("#");
        for (int i = 0; i < strB.length; i++) {
            System.out.println(strB[i]);
        }

        String[] strC = str3.split("/");
//		String[] strCC = strC[0].split(",");
//		String[] strCC2 = strC[1].split(",");
//		String[] strCC3 = strC[2].split(",");
//		String[] strCC4 = strC[3].split(",");
//		String[] strCC5 = strC[4].split(",");
        for (int i = 0; i < strC.length; i++) {
            System.out.println(strC[i].split(",")[0] + " " + strC[i].split(",")[1]);
        }
    }
}