package net.watertao.diablo.reader;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * This Reader used for reading line separated sensitive words format file.
 * A line is considered to be terminated by any one of a line feed ('\n'), a carriage return ('\r'), or a carriage
 * return followed immediately by a linefeed.
 *
 * @author watertao
 */
public class LineSeparationReader implements SensitiveWordPatternReader {

  private BufferedReader patternReader = null;

  public LineSeparationReader(File file) throws FileNotFoundException {
    InputStream in = new FileInputStream(file);
    patternReader = new BufferedReader(new InputStreamReader(in));
  }

  public LineSeparationReader(File file, Charset charset) throws FileNotFoundException {
    InputStream in = new FileInputStream(file);
    patternReader = new BufferedReader(new InputStreamReader(in, charset));
  }

  /**
   * Use platform default charset to read stream
   * (Not recommended)
   *
   * @param in
   */
  public LineSeparationReader(InputStream in) {
    patternReader = new BufferedReader(new InputStreamReader(in));
  }

  /**
   * Use specified charset to read stream
   *
   * @param in
   * @param charset
   */
  public LineSeparationReader(InputStream in, Charset charset) {
    patternReader = new BufferedReader(new InputStreamReader(in, charset));
  }

  public List<String> readWords() throws PatternReadingException {

    List<String> words = new ArrayList<String>();
    String line = null;

    try {
      while ((line = patternReader.readLine()) != null) {
        line = line.trim();
        if (line.length() > 0) {
          words.add(line);
        }
      }
    } catch (IOException e) {
      throw new PatternReadingException(e.getMessage(), e);
    }

    return words;
  }

}
