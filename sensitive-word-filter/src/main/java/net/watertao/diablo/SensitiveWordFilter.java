package net.watertao.diablo;

import net.watertao.diablo.reader.PatternReadingException;
import net.watertao.diablo.reader.SensitiveWordPatternReader;
import org.ahocorasick.trie.Emit;
import org.ahocorasick.trie.Trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A filter for finding sensitive words in specified text.
 * Use aho-corasick algorithm.
 *
 *
 * @author watertao
 */
public class SensitiveWordFilter {

  private SensitiveWordPatternReader patternReader;

  private Trie trie;

  private boolean isReady = false;

  public SensitiveWordFilter(SensitiveWordPatternReader patternReader) {
    if (patternReader == null) {
      throw new NullPointerException();
    }
    this.patternReader = patternReader;
  }


  /**
   * reading pattern & construct Trie data structure
   * This function could call multiple times, when you update your sensitive words source, you may re-call this method
   * to update the trie data structure.
   *
   * @throws PatternReadingException
   */
  public void build() throws PatternReadingException {
    synchronized (SensitiveWordFilter.class) {
      List<String> words = patternReader.readWords();
      Trie.TrieBuilder trieBuilder = Trie.builder();
      for (String word : words) {
        trieBuilder.addKeyword(word);
      }
      trie = trieBuilder.build();
      isReady = true;
    }
  }

  /**
   * find sensitive words in specified text
   *
   * @return MatchPoint list, empty list if no sensitive word found
   */
  public List<MatchPoint> findSensitiveWord(CharSequence text) {
    if (!isReady) {
      throw new RuntimeException("Filter not initialized, try call build() first.");
    }

    Collection<Emit> emits = trie.parseText(text);
    List<MatchPoint> matchPoints = new ArrayList<MatchPoint>(emits.size());
    for (Emit emit : emits) {
      matchPoints.add(new MatchPoint(emit.getStart(), emit.getEnd(), emit.getKeyword()));
    }

    return matchPoints;
  }

}
