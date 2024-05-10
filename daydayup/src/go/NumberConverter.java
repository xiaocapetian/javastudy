package go;

/**
 * 进制转换
 */
public class NumberConverter {
    public static void main(String[] args) {
        int number = 123; // 要转换的数字

        // 10进制转其他进制
        String binary = Integer.toBinaryString(number);
        String octal = Integer.toOctalString(number);
        String hexadecimal = Integer.toHexString(number);

        // 输出转换结果
        System.out.println("Decimal: " + number);
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hexadecimal);

        // 其他进制转10进制
        int binaryToDecimal = Integer.parseInt(binary, 2);
        int octalToDecimal = Integer.parseInt(octal, 8);
        int hexadecimalToDecimal = Integer.parseInt(hexadecimal, 16);

        // 输出转换结果
        System.out.println("Binary to Decimal: " + binaryToDecimal);
        System.out.println("Octal to Decimal: " + octalToDecimal);
        System.out.println("Hexadecimal to Decimal: " + hexadecimalToDecimal);
    }
}
