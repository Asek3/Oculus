package io.github.douira.glsl_transformer.ast.node;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;
import repack.antlr.v4.runtime.Token;

public class Identifier extends ASTNode {
  private String name;

  public Identifier(String name) {
    this.name = name;
    validateContents(name);
  }

  public Identifier(Token token) {
    this(token.getText());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (this.name.equals(name)) {
      return;
    }
    validateContents(name);
    getRoot().unregisterIdentifierRename(this);
    this.name = name;
    getRoot().registerIdentifierRename(this);
  }

  /**
   * Sets the name of this identifier without performing validation or registering
   * this change in the index. This method should only be called internally. Using
   * it otherwise will lead to inconsistencies.
   *
   * @param name The new name of this identifier.
   */
  public void _setNameInternal(String name) {
    getRoot().unregisterFastRename(this);
    this.name = name;
    getRoot().registerFastRename(this);
  }

  public static final void validateContents(String str) {
    // verify identifier contents to be only a-z, A-Z, 0-9 and _
    // and does not start with a digit
    if (str.length() == 0) {
      throw new IllegalArgumentException("Identifier cannot be empty");
    }
    if (!Character.isLetter(str.charAt(0)) && str.charAt(0) != '_') {
      throw new IllegalArgumentException("Identifier must start with a letter or underscore");
    }
    for (int i = 1; i < str.length(); i++) {
      char c = str.charAt(i);
      if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '_')) {
        throw new IllegalArgumentException("Invalid identifier name: " + str);
      }
    }
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitIdentifier(this);
  }

  @Override
  public Identifier clone() {
    return new Identifier(name);
  }

  @Override
  public Identifier cloneInto(Root root) {
    return (Identifier) super.cloneInto(root);
  }
}
