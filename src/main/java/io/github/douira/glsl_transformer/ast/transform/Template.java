package io.github.douira.glsl_transformer.ast.transform;

import java.util.*;
import java.util.function.Supplier;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.external_declaration.ExternalDeclaration;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.query.*;
import io.github.douira.glsl_transformer.parser.ParseShape;

public class Template<N extends ASTNode> {
  private final Map<ASTNode, Supplier<ASTNode>> replacements = new HashMap<>();
  private int localReplacementsMarked = 0;
  private List<ASTNode> localReplacements = Collections.emptyList();
  protected final N source;

  public Template(N source) {
    this.source = source;
  }

  public N getSource() {
    return source;
  }

  public Root getSourceRoot() {
    return source.getRoot();
  }

  @SuppressWarnings("unchecked") // the replacements map is always consistent
  public <R> R getReplacement(R original) {
    // correct use of the API should result in the right type here
    var replacementSupplier = replacements.get(original);
    return replacementSupplier == null ? null : (R) replacementSupplier.get();
  }

  @SuppressWarnings("unchecked") // all ASTNodes clone themselves with the right type
  public N getInstanceFor(Root root) {
    return (N) source.cloneInto(root);
  }

  public void supplyLocalReplacements(List<ASTNode> replacements) {
    Objects.requireNonNull(replacements);
    if (replacements.size() < localReplacementsMarked) {
      throw new IllegalStateException(
          "The local replacements must have enough items for all marked nodes in the template.");
    }
    this.localReplacements = replacements;
  }

  public void supplyLocalReplacements(ASTNode replacement) {
    Objects.requireNonNull(replacement);
    supplyLocalReplacements(Collections.singletonList(replacement));
  }

  public void supplyLocalReplacements(ASTNode... replacements) {
    Objects.requireNonNull(replacements);
    supplyLocalReplacements(Arrays.asList(replacements));
  }

  public N getInstanceFor(Root root, List<ASTNode> localReplacements) {
    supplyLocalReplacements(localReplacements);
    return getInstanceFor(root);
  }

  public N getInstanceFor(Root root, ASTNode localReplacement) {
    supplyLocalReplacements(localReplacement);
    return getInstanceFor(root);
  }

  public N getInstanceFor(Root root, ASTNode... localReplacements) {
    supplyLocalReplacements(localReplacements);
    return getInstanceFor(root);
  }

  public void markLocalReplacement(ASTNode original) {
    final var index = localReplacementsMarked++;
    markReplacement(original, () -> localReplacements.get(index));
  }

  public void markLocalReplacement(String tag, Class<? extends ASTNode> type) {
    markLocalReplacement(source.getRoot().identifierIndex.getOne(tag).getAncestor(type));
  }

  public void markIdentifierReplacement(String tag) {
    markLocalReplacement(source.getRoot().identifierIndex.getOne(tag));
  }

  public void markIdentifierReplacement(String tag, Supplier<ASTNode> replacement) {
    markReplacement(source.getRoot().identifierIndex.getOne(tag), replacement);
  }

  public void markReplacement(ASTNode original, Supplier<ASTNode> replacement) {
    Objects.requireNonNull(original);
    Objects.requireNonNull(replacement);
    replacements.put(original, replacement);
    original.markTemplate(this);
  }

  @SuppressWarnings("unchecked")
  public <NN extends ASTNode> void markReplacement(String tag, Class<NN> type, Supplier<NN> replacement) {
    markReplacement(source.getRoot().identifierIndex.getOne(tag).getAncestor(type), (Supplier<ASTNode>) replacement);
  }

  @SuppressWarnings("unchecked") // all ASTNodes clone themselves with the right type
  public static <N extends ASTNode> Template<N> ofCloned(N source) {
    return new Template<N>((N) source.cloneInto(RootSupplier.supplyDefault()));
  }

  public static Template<ExternalDeclaration> withExternalDeclaration(String input) {
    return new Template<>(ParseShape.EXTERNAL_DECLARATION._parseNodeSeparateInternal(input));
  }

  public static Template<Statement> withStatement(String input) {
    return new Template<>(ParseShape.STATEMENT._parseNodeSeparateInternal(input));
  }

  public static Template<Expression> withExpression(String input) {
    return new Template<>(ParseShape.EXPRESSION._parseNodeSeparateInternal(input));
  }
}
