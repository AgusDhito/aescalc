package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class FileUtil {
  public static String readLines(File file) throws Exception{
    Path path = getPath(file);
    String lines = Files.readAllLines(path).get(0);
    String result = lines;
    return result;
  }

  public static byte[] readBytes(File file) throws Exception {
    Path path = getPath(file);
    return Files.readAllBytes(path);
  }

  public static Path getPath(File file) {
    return Paths.get(file.getAbsolutePath());
  }

  public static void writeToFile(byte[] input, String file_name) throws Exception {
    Path output_path = Paths.get(file_name);
    Files.write(output_path, input);
  }
}
