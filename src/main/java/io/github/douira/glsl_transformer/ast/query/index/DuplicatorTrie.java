package io.github.douira.glsl_transformer.ast.query.index;

import repack.apache.commons.collections4.trie.PatriciaTrie;

import java.util.Map;
import java.util.SortedMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Base class for trie variants that insert more than one entry per key.
 */
public abstract class DuplicatorTrie<E> extends PatriciaTrie<E> {
  public static final char DEFAULT_MARKER = '$';
  protected final char marker;

  public static final class Holder<V> {
    public V value;

    public Holder(V value) {
      this.value = value;
    }

    public V getValue() {
      return value;
    }
  }

  public DuplicatorTrie() {
    super();
    marker = DEFAULT_MARKER;
  }

  public DuplicatorTrie(Map<? extends String, ? extends E> m) {
    super(m);
    marker = DEFAULT_MARKER;
  }

  public DuplicatorTrie(char marker) {
    this.marker = marker;
  }

  public DuplicatorTrie(Map<? extends String, ? extends E> m, char marker) {
    super(m);
    this.marker = marker;
  }

  protected abstract void iterateKeyVariations(String key, Consumer<String> consumer);

  protected String prepareKey(Object k) {
    return sanitizeKey(k.toString());
  }

  protected String sanitizeKey(String key) {
    if (key.indexOf(marker) >= 0) {
      throw new IllegalArgumentException("Key cannot contain marker");
    }
    return key;
  }

  @Override
  public boolean containsKey(Object k) {
    return super.containsKey(prepareKey(k));
  }

  @Override
  public E get(Object k) {
    return super.get(prepareKey(k));
  }

  @Override
  public SortedMap<String, E> headMap(String toKey) {
    return super.headMap(prepareKey(toKey));
  }

  @Override
  public String nextKey(String key) {
    return super.nextKey(prepareKey(key));
  }

  @Override
  public SortedMap<String, E> prefixMap(String key) {
    return super.prefixMap(prepareKey(key));
  }

  public SortedMap<String, E> prefixMapRaw(String key) {
    return super.prefixMap(key);
  }

  @Override
  public String previousKey(String key) {
    return super.previousKey(prepareKey(key));
  }

  @Override
  public E put(String key, E value) {
    var previous = get(key);
    iterateKeyVariations(key, k -> super.put(k, value));
    return previous;
  }

  @Override
  public E remove(Object k) {
    var previous = get(k);
    iterateKeyVariations((String) k, super::remove);
    return previous;
  }

  @Override
  public Entry<String, E> select(String key) {
    return super.select(prepareKey(key));
  }

  @Override
  public String selectKey(String key) {
    return super.selectKey(prepareKey(key));
  }

  @Override
  public SortedMap<String, E> subMap(String fromKey, String toKey) {
    return super.subMap(prepareKey(fromKey), prepareKey(toKey));
  }

  @Override
  public SortedMap<String, E> tailMap(String fromKey) {
    return super.tailMap(prepareKey(fromKey));
  }

  protected Stream<E> distinctPrefixQuery(String prefix) {
    return super.prefixMap(prefix).values().stream().unordered().distinct();
  }
}
