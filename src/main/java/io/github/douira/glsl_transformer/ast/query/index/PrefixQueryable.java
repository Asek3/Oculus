package io.github.douira.glsl_transformer.ast.query.index;

import java.util.Set;
import java.util.stream.Stream;

public interface PrefixQueryable<S extends Set<E>, E> {
  /**
   * Returns a stream of all results that are keyed with the given prefix. Note
   * that if the index is a special type of suffix/infix trie (like permuterm)
   * then this won't make any sense.
   * 
   * @param prefix the prefix to search for
   * @return a map of all entries with keys that start with the given key
   */
  Stream<S> prefixQuery(String prefix);

  /**
   * Returns a stream of all results, but unwrapped from their sets, that are
   * keyed with the given prefix. Note that if the index is a special type of
   * suffix/infix trie (like permuterm) then this won't make any sense.
   * 
   * @param prefix the prefix to search for
   * @return a map of all entries with keys that start with the given key
   */
  default Stream<E> prefixQueryFlat(String prefix) {
    return prefixQuery(prefix).flatMap(Set::stream);
  }
}
