package io.github.douira.glsl_transformer.ast.query.match;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.parser.ParseShape;

/**
 * A hinted matcher contains an additional string that can be used to find
 * identifiers whose matching ancestor might match the pattern. This makes
 * working with matchers much less verbose.
 */
public class HintedMatcher<N extends ASTNode> extends Matcher<N> {
  protected String hint;

  public HintedMatcher(N pattern, String wildcardPrefix, String hint) {
    super(pattern, wildcardPrefix);
    this.hint = hint;
  }

  public HintedMatcher(N pattern, String hint) {
    super(pattern);
    this.hint = hint;
  }

  public HintedMatcher(String input, ParseShape<?, N> parseShape, String wildcardPrefix, String hint) {
    super(input, parseShape, wildcardPrefix);
    this.hint = hint;
  }

  public HintedMatcher(String input, ParseShape<?, N> parseShape, String hint) {
    super(input, parseShape);
    this.hint = hint;
  }

  public String getHint() {
    return hint;
  }
}
