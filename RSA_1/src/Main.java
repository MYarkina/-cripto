import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException {
        RSA rsa = new RSA(1024);
        DataInputStream input = new DataInputStream(System.in);
        String inputString;
        System.out.println("Enter text");
        inputString = input.readLine();
        byte[] enc = rsa.encrypt(inputString.getBytes());
        byte[] dec = rsa.decrypt(enc);
        System.out.println("Text after decrypt - " + new String(dec));
    }
}