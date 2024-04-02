package io.github.douira.glsl_transformer.ast.query.index;

import io.github.douira.glsl_transformer.ast.node.Identifier;

import java.util.*;
import java.util.function.Supplier;

public class IdentifierIndex<S extends Set<Identifier>, I extends Map<String, S>>
    extends StringKeyedIndex<Identifier, Identifier, S, I> {
  public IdentifierIndex(I index, Supplier<S> setFactory) {
    super(index, setFactory);
  }

  @Override
  protected Identifier getNode(Identifier entry) {
    return entry;
  }

  @Override
  public void add(Identifier node) {
    var key = node.getName();
    var set = index.get(key);
    if (set == null) {
      set = setFactory.get();
      index.put(key, set);
    }
    set.add(node);
  }

  @Override
  public void remove(Identifier node) {
    var key = node.getName();
    var set = index.get(key);
    if (set == null) {
      return;
    }
    set.remove(node);
    if (set.isEmpty()) {
      index.remove(key);
    }
  }

  /**
   * Renames all identifiers with one name to have a new name. Since this deals
   * only with identifiers, this can be done by moving the set of identifiers
   * around as a whole.
   *
   * @param oldName the old name
   * @param newName the new name
   * @return Whether anything was renamed
   */
  public boolean rename(String oldName, String newName) {
    if (oldName.equals(newName)) {
      return false;
    }
    Identifier.validateContents(newName);
    var set = index.get(oldName);
    if (set == null) {
      return false;
    }
    index.remove(oldName);
    var existing = index.get(newName);
    if (existing == null) {
      index.put(newName, set);
    } else {
      existing.addAll(set);
    }
    for (var id : set) {
      id._setNameInternal(newName);
    }
    return true;
  }

  public static IdentifierIndex<HashSet<Identifier>, HashMap<String, HashSet<Identifier>>> withOnlyExact() {
    return new IdentifierIndex<>(new HashMap<>(), HashSet::new);
  }

  public static IdentifierIndex<LinkedHashSet<Identifier>, HashMap<String, LinkedHashSet<Identifier>>> withOnlyExactOrdered() {
    return new IdentifierIndex<>(new HashMap<>(), LinkedHashSet::new);
  }

  public static <R extends Set<Identifier>> IdentifierIndex<R, HashMap<String, R>> withOnlyExact(
      Supplier<R> setFactory) {
    return new IdentifierIndex<>(new HashMap<>(), setFactory);
  }
}
