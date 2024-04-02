package io.github.douira.glsl_transformer.ast.query.match;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.parser.ParseShape;

/**
 * The auto-hinted matcher is a matcher that automatically determines the hint
 * by finding the longest identifier in the pattern. If that hint is not the
 * best (most distinguishing) hint, then the manually hinted
 * {@link HintedMatcher} should be used instead.
 */
public class AutoHintedMatcher<N extends ASTNode> extends HintedMatcher<N> {
  public AutoHintedMatcher(N pattern, String wildcardPrefix) {
    super(pattern, wildcardPrefix, null);
  }

  public AutoHintedMatcher(N pattern) {
    super(pattern, null);
  }

  public AutoHintedMatcher(String input, ParseShape<?, N> parseShape, String wildcardPrefix) {
    super(input, parseShape, wildcardPrefix, null);
  }

  public AutoHintedMatcher(String input, ParseShape<?, N> parseShape) {
    super(input, parseShape, null);
  }

  private void determineHint() {
    preparePatternItems();
    String longestHint = null;
    var hintLength = 0;
    for (var item : patternItems) {
      if (item instanceof Identifier id) {
        var idContent = id.getName();
        if (idContent.length() > hintLength
            && (wildcardPrefix == null || !idContent.startsWith(wildcardPrefix))) {
          longestHint = idContent;
          hintLength = idContent.length();
        }
      }
    }
    if (longestHint == null) {
      throw new IllegalArgumentException(
          "The provided pattern must contain a non-wildcard identifier to use as the hint!");
    }
    hint = longestHint;
  }

  @Override
  public String getHint() {
    if (hint == null) {
      determineHint();
    }
    return super.getHint();
  }
}
