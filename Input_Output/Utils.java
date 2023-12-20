import java.io.*;
import java.nio.file.*;
import java.util.List;

public class Utils {

  // Phương thức để đọc một tệp .txt từ ổ cứng
  public static String readContentFromFile(String path) {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content.toString();
  }

  /**
   * cmt.
   */

  // Phương thức để xuất nội dung một xâu vào 1 tệp trong ổ cứng, xóa nội dung cũ
  public static void writeContentToFile(String path, String content) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(path))) {
      writer.print(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * cmt.
   */

  // Phương thức để xuất nội dung một xâu vào 1 tệp trong ổ cứng, bổ sung nội dung mới vào cuối
  public static void appendContentToFile(String path, String content) {
    try (FileWriter writer = new FileWriter(path, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
      printWriter.println(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * cmt.
   */

  // Phương thức để tìm kiếm một tệp trong một thư mục
  public static File findFileByName(String folderPath, String fileName) {
    File folder = new File(folderPath);
    File[] files = folder.listFiles();

    if (files != null) {
      for (File file : files) {
        if (file.isFile() && file.getName().equals(fileName)) {
          return file;
        }
      }
    }

    return null; // Không tìm thấy tệp trong thư mục
  }
}
