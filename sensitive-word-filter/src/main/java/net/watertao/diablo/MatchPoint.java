package net.watertao.diablo;

import java.io.Serializable;

/**
 * Created by watertao on 8/31/16.
 */
public class MatchPoint implements Serializable {

  private int start;

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
