package io.github.douira.glsl_transformer.ast.query.index;

import io.github.douira.glsl_transformer.ast.query.index.ExternalDeclarationIndex.DeclarationEntry;
import repack.apache.commons.collections4.trie.PatriciaTrie;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PrefixExternalDeclarationIndex<S extends Set<DeclarationEntry>, I extends PatriciaTrie<S>>
    extends ExternalDeclarationIndex<S, I> implements PrefixQueryable<S, DeclarationEntry> {

  public PrefixExternalDeclarationIndex(I index, Supplier<S> setFactory) {
    super(index, setFactory);
  }

  /**
   * Returns a map of all entries with keys that start with the given key. Note
   * that if the index is a special type of suffix/infix trie (like permuterm)
   * then this won't make any sense.
   *
   * @param key the key to search for
   * @return a map of all entries with keys that start with the given key
   */
  public SortedMap<String, S> prefixMap(String key) {
    return index.prefixMap(key);
  }

  @Override
  public Stream<S> prefixQuery(String key) {
    return index.prefixMap(key).values().stream();
  }

  public static PrefixExternalDeclarationIndex<HashSet<DeclarationEntry>, PrefixTrie<HashSet<DeclarationEntry>, DeclarationEntry>> withPrefix() {
    return new PrefixExternalDeclarationIndex<>(new PrefixTrie<>(), HashSet::new);
  }

  public static PrefixExternalDeclarationIndex<HashSet<DeclarationEntry>, PrefixSuffixTrie<HashSet<DeclarationEntry>, DeclarationEntry>> withPrefixSuffix() {
    return new PrefixExternalDeclarationIndex<>(new PrefixSuffixTrie<>(), HashSet::new);
  }

  public static PrefixExternalDeclarationIndex<HashSet<DeclarationEntry>, PermutermTrie<HashSet<DeclarationEntry>, DeclarationEntry>> withPermuterm() {
    return new PrefixExternalDeclarationIndex<>(new PermutermTrie<>(), HashSet::new);
  }

  public static <R extends Set<DeclarationEntry>> PrefixExternalDeclarationIndex<R, PrefixTrie<R, DeclarationEntry>> withPrefix(
      Supplier<R> setFactory) {
    return new PrefixExternalDeclarationIndex<>(new PrefixTrie<>(), setFactory);
  }

  public static <R extends Set<DeclarationEntry>> PrefixExternalDeclarationIndex<R, PrefixSuffixTrie<R, DeclarationEntry>> withPrefixSuffix(
      Supplier<R> setFactory) {
    return new PrefixExternalDeclarationIndex<>(new PrefixSuffixTrie<>(), setFactory);
  }

  public static <R extends Set<DeclarationEntry>> PrefixExternalDeclarationIndex<R, PermutermTrie<R, DeclarationEntry>> withPermuterm(
      Supplier<R> setFactory) {
    return new PrefixExternalDeclarationIndex<>(new PermutermTrie<>(), setFactory);
  }
}
