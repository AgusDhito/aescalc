import spec.CalculatorSpec;
import util.FileUtil;
import util.StringUtil;
import crypto.Aes;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class TugasPemrograman {

  public static void main(String[] args) {
    String plain_path = "C:/Users/Acer/Desktop/input.txt";
    String key_path = "C:/Users/Acer/Desktop/key.txt";
    File input = new File(plain_path);
    File key = new File(key_path);
    String command = "ENCRYPT";
    CalculatorSpec spec = new CalculatorSpec();
    spec.setInputFile(input);
    spec.setKeyFile(key);
    spec.setCommand(command);

    File inputFile = spec.getInputFile();
    File keyFile = spec.getKeyFile();
    /* READ FILE AND COMMAND TYPE*/
    try {
      byte[] input_bytes = FileUtil.readBytes(inputFile);
      byte[] key_bytes = FileUtil.readBytes(keyFile);
      System.out.printf("Input bytes : %s\n", new String(input_bytes));
      System.out.printf("Key bytes : %s\n", new String(key_bytes));
      System.out.printf("Command : %s\n", spec.getCommand());
      execute(input_bytes, key_bytes, spec.getCommand());
    } catch (Exception e) {
        e.printStackTrace();
    }

  }
  private static void execute(byte[] input, byte[] key, String cmd) throws Exception{
    Aes aes = new Aes();
    switch(cmd) {
        case "ENCRYPT":
        byte[] input_with_padding = StringUtil.addPadding(input);
        byte[] cipher_text = aes.encrypt(input_with_padding, key);
        FileUtil.writeToFile(cipher_text, "cipher.txt");
        break;

        case "DECRYPT":
        byte[] plain_text = aes.decrypt(input, key);
        byte[] plain_text_ex_padding = StringUtil.removePadding(plain_text);
        FileUtil.writeToFile(plain_text_ex_padding, "plain.txt");
        break;
    }
  }
}
