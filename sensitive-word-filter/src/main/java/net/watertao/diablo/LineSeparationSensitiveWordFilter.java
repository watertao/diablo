package net.watertao.diablo;

import net.watertao.diablo.reader.LineSeparationReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * A helper class for conveniently creating filter from line-separating formatting sensitive word file.
 *
 * @author watertao
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
