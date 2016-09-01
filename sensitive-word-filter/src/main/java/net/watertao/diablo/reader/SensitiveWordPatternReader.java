package net.watertao.diablo.reader;

import java.util.List;

/**
 * Created by watertao on 8/31/16.
 */
public interface SensitiveWordPatternReader {

  List<String> readWords() throws PatternReadingException;

}
