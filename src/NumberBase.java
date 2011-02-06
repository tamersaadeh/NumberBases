import org.apache.commons.lang.ArrayUtils;

public class NumberBase {
	private static final String ascii = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_=+`~\\/'\":;>.<,?!@#$%^&*(){}[] ";

	public static long binaryToDecimal(String binary) {
		if (isBinary(binary)) {
			char[] binStrArr = binary.toCharArray();
			int[] binArr = new int[binary.length()];
			for (int i = 0; i < binArr.length; i++) {
				binArr[i] = Integer.parseInt(binStrArr[i] + "");
			}
			ArrayUtils.reverse(binArr);
			int decimal = 0;
			for (int i = 0; i < binArr.length; i++) {
				decimal += binArr[i] * Math.pow(2, i);
			}
			return decimal;
		} else {
			return -1;
		}
	}

	private static boolean isBinary(String binary) {
		String notBinary = remove("01", ascii);
		System.out.println(notBinary);
		for (int i = 0; i < notBinary.length(); i++) {
			char c = notBinary.charAt(i);
			if (binary.contains(c + ""))
				return false;
		}
		return true;
	}

	private static String remove(String remove, String original) {
		for (int i = 0; i < remove.length(); i++) {
			String c = "" + remove.charAt(i);
			original = original.replace(c, "");
		}
		return original;
	}

	public static void main(String[] args) {
		System.out.println(binaryToDecimal("01010101011010"));
	}
}