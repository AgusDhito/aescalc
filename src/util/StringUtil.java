package util;

public class StringUtil {
  public static byte[] addPadding(byte[] input) {
    int res = 16 - input.length % 16;
    byte[] result = new byte[res];
    System.out.println(res);
    result = fill(result,(byte) res);
    return merge(input, result);
  }

  public static byte[] removePadding(byte[] input) {
    int res = input[input.length - 1];
    byte[] result = new byte[input.length - res];
    System.arraycopy(input, 0, result, 0, result.length);
    return result;
  }

  private static byte[] merge(byte[] arr1, byte[] arr2) {
    byte[] results = new byte[arr1.length + arr2.length];
    int i = 0;
    for (; i < arr1.length; i++) {
      results[i] = arr1[i];
    }
    for (int j = i; j-i < arr2.length; j++) {
      results[j] = arr2[j-i];
    }
    return results;
  }

  private static byte[] fill(byte[] arr, byte elem) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = elem;
    }
    return arr;
  }

  public static void print(byte[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
