package io.github.douira.glsl_transformer.ast.query.index;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import repack.apache.commons.collections4.trie.PatriciaTrie;

import io.github.douira.glsl_transformer.ast.node.Identifier;

public class PrefixIdentifierIndex<S extends Set<Identifier>, I extends PatriciaTrie<S>> extends IdentifierIndex<S, I>
    implements PrefixQueryable<S, Identifier> {

  public PrefixIdentifierIndex(I index, Supplier<S> setFactory) {
    super(index, setFactory);
  }

  public SortedMap<String, S> prefixMap(String key) {
    return index.prefixMap(key);
  }

  @Override
  public Stream<S> prefixQuery(String key) {
    return index.prefixMap(key).values().stream();
  }

  public static PrefixIdentifierIndex<HashSet<Identifier>, PrefixTrie<HashSet<Identifier>, Identifier>> withPrefix() {
    return new PrefixIdentifierIndex<>(new PrefixTrie<>(), HashSet::new);
  }

  public static PrefixIdentifierIndex<HashSet<Identifier>, PrefixSuffixTrie<HashSet<Identifier>, Identifier>> withPrefixSuffix() {
    return new PrefixIdentifierIndex<>(new PrefixSuffixTrie<>(), HashSet::new);
  }

  public static PrefixIdentifierIndex<HashSet<Identifier>, PermutermTrie<HashSet<Identifier>, Identifier>> withPermuterm() {
    return new PrefixIdentifierIndex<>(new PermutermTrie<>(), HashSet::new);
  }

  public static <R extends Set<Identifier>> PrefixIdentifierIndex<R, PrefixTrie<R, Identifier>> withPrefix(
      Supplier<R> setFactory) {
    return new PrefixIdentifierIndex<>(new PrefixTrie<>(), setFactory);
  }

  public static <R extends Set<Identifier>> PrefixIdentifierIndex<R, PrefixSuffixTrie<R, Identifier>> withPrefixSuffix(
      Supplier<R> setFactory) {
    return new PrefixIdentifierIndex<>(new PrefixSuffixTrie<>(), setFactory);
  }

  public static <R extends Set<Identifier>> PrefixIdentifierIndex<R, PermutermTrie<R, Identifier>> withPermuterm(
      Supplier<R> setFactory) {
    return new PrefixIdentifierIndex<>(new PermutermTrie<>(), setFactory);
  }
}
