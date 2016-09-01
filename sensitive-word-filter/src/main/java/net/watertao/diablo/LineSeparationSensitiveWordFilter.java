package net.watertao.diablo;

import net.watertao.diablo.reader.LineSeparationReader;
import net.watertao.diablo.reader.SensitiveWordPatternReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by watertao on 9/1/16.
 */
public class LineSeparationSensitiveWordFilter extends SensitiveWordFilter {

  public LineSeparationSensitiveWordFilter(File file) throws FileNotFoundException {
    super(new LineSeparationReader(file));
  }

  public LineSeparationSensitiveWordFilter(File file, Charset charset) throws FileNotFoundException {
    super(new LineSeparationReader(file));
  }

  public LineSeparationSensitiveWordFilter(InputStream in) throws FileNotFoundException {
    super(new LineSeparationReader(in));
  }

  public LineSeparationSensitiveWordFilter(InputStream in, Charset charset) throws FileNotFoundException {
    super(new LineSeparationReader(in, charset));
  }

}
