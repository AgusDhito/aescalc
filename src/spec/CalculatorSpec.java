package spec;
import java.io.File;


public class CalculatorSpec {
  public File input;
  public File key;
  public String command;

  public void setInputFile(File input) {
    this.input = input;
  }

  public File getInputFile() {
    return input;
  }

  public void setKeyFile(File key) {
    this.key = key;
  }

  public File getKeyFile() {
    return key;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }
}
