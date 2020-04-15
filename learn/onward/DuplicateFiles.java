/*
* Finds duplicate files with identical content in a directory
*
* @author pavaniprasanna
* @date 12/7/2018
*/

package learn.onward;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class DuplicateFiles {

  /**
  * Returns a file's content as a String
  *
  * @param path filename
  * @param encoding format of file's content
  * @return file content
  */
  public static String readFile(String path, Charset encoding) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }

  /**
  * Finds duplicate Files
  *
  * @param folderPath of a folder
  * @return HashMap with key: file content, value: list of filenames
  */
  public static HashMap<String,ArrayList<String>> getDuplicateFiles(String folderPath) throws IOException {
    // key: file content, value: list of filenames
    HashMap<String,ArrayList<String>> duplicateMap =
            new HashMap<>();
    File[] fileList = new File(folderPath).listFiles();

    if (fileList != null) {

      for (File file : fileList) {
        String content = readFile(file.toString(), StandardCharsets.UTF_8);
        ArrayList<String> list = duplicateMap.containsKey(content) ?
                duplicateMap.get(content) : new ArrayList<>();
        list.add(file.toString());
        duplicateMap.put(content, list);
      }
    }
    return duplicateMap;
  }

  /**
  * Main method to test getDuplicateFiles
  */
  public static void main(String[] args) {
      try {
      System.out.println(DuplicateFiles.getDuplicateFiles("duplicateTest"));
      System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
      }
      catch (IOException e) {
        System.out.println(e);
      }
    }
}
