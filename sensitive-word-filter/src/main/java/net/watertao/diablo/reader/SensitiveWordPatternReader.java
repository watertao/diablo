package net.watertao.diablo.reader;

import java.util.List;

/**
 * An interface for defining readers for reading sensitive words from various formats.
 *
 * @author watertao
 */
public interface SensitiveWordPatternReader {

  /**
   * Read sensitive words from somewhere.
   *
   * @return
   * @throws PatternReadingException
     */
  List<String> readWords() throws PatternReadingException;

}
