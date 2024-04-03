package io.github.douira.glsl_transformer.ast.query;

import io.github.douira.glsl_transformer.ast.query.index.*;

import java.util.function.Supplier;

/**
 * Supplies root instances with specific pre-configured indexes. There are a
 * number of presets which are the most common, but custom instances of this
 * class can specify their own index suppliers.
 */
public class RootSupplier implements Supplier<Root> {
  public static final RootSupplier EXACT_UNORDERED = new RootSupplier(
      NodeIndex::withUnordered, IdentifierIndex::withOnlyExact);
  public static final RootSupplier PREFIX_UNORDERED = new RootSupplier(
      NodeIndex::withUnordered, PrefixIdentifierIndex::withPrefix);

  public static final RootSupplier EXACT_UNORDERED_ED_EXACT = new RootSupplier(
      NodeIndex::withUnordered,
      IdentifierIndex::withOnlyExact,
      ExternalDeclarationIndex::withOnlyExact);
  public static final RootSupplier PREFIX_UNORDERED_ED_EXACT = new RootSupplier(
      NodeIndex::withUnordered,
      PrefixIdentifierIndex::withPrefix,
      ExternalDeclarationIndex::withOnlyExact);
  public static final RootSupplier PREFIX_UNORDERED_ED_PREFIX = new RootSupplier(
      NodeIndex::withUnordered,
      PrefixIdentifierIndex::withPrefix,
      PrefixExternalDeclarationIndex::withPrefix);

  public static final RootSupplier EMPTY = new RootSupplier(supplier(null), supplier(null));
  public static final RootSupplier ONLY_NODE_INDEX = new RootSupplier(
      NodeIndex::withUnordered, supplier(null));
  public static final RootSupplier ONLY_IDENTIFIER_INDEX = new RootSupplier(
      supplier(null), IdentifierIndex::withOnlyExact);

  public static final RootSupplier DEFAULT = EXACT_UNORDERED;

  private static final <V> Supplier<V> supplier(V value) {
    return () -> value;
  }

  public static Root supplyDefault() {
    return DEFAULT.get();
  }

  private final Supplier<NodeIndex<?>> nodeIndexSupplier;
  private final Supplier<IdentifierIndex<?, ?>> identifierIndexSupplier;
  private final Supplier<ExternalDeclarationIndex<?, ?>> externalDeclarationIndexSupplier;

  public RootSupplier(
      Supplier<NodeIndex<?>> nodeIndexSupplier,
      Supplier<IdentifierIndex<?, ?>> identifierIndexSupplier,
      Supplier<ExternalDeclarationIndex<?, ?>> externalDeclarationIndexSupplier) {
    this.nodeIndexSupplier = nodeIndexSupplier;
    this.identifierIndexSupplier = identifierIndexSupplier;
    this.externalDeclarationIndexSupplier = externalDeclarationIndexSupplier;
  }

  public RootSupplier(
      Supplier<NodeIndex<?>> nodeIndexSupplier,
      Supplier<IdentifierIndex<?, ?>> identifierIndexSupplier) {
    this(nodeIndexSupplier, identifierIndexSupplier, supplier(null));
  }

  @Override
  public Root get() {
    return new Root(
        nodeIndexSupplier.get(),
        identifierIndexSupplier.get(),
        externalDeclarationIndexSupplier.get());
  }

  public RootSupplier setNodeIndex(Supplier<NodeIndex<?>> nodeIndexSupplier) {
    return new RootSupplier(nodeIndexSupplier, identifierIndexSupplier);
  }

  public RootSupplier setIdentifierIndex(
      Supplier<IdentifierIndex<?, ?>> identifierIndexSupplier) {
    return new RootSupplier(nodeIndexSupplier, identifierIndexSupplier);
  }
}
