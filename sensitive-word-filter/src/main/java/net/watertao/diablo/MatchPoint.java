package net.watertao.diablo;

import java.io.Serializable;

/**
 * A value class for hold matched part of sensitive word in text
 *
 * @author watertao
 */
public class MatchPoint implements Serializable {

  /** the start index of sensitive word in text */
  private int start;

  /** the end index of sensitive word in text */
  private int end;

  private String word;

  public MatchPoint(int start, int end, String word) {
    this.start = start;
    this.end = end;
    this.word = word;
  }

  public int getStart() {
    return start;
  }

  public int getEnd() {
    return end;
  }

  public String getWord() {
    return word;
  }

}
