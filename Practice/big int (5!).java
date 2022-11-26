import java.math.BigInteger;

class bigInt {
    public static void main(String[] args) {
        BigInteger b2 = new BigInteger("1");
        for (int i = 1; i <= 5; i++) {
            b2 = b2.multiply(new BigInteger(""+i));
        }
        System.out.println(b2);

    }
}