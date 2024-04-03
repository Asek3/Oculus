package io.github.douira.glsl_transformer.parser;

import io.github.douira.glsl_transformer.ast.data.TypedTreeCache;
import io.github.douira.glsl_transformer.ast.transform.ASTBuilder;
import io.github.douira.glsl_transformer.token_filter.TokenFilter;
import repack.antlr.v4.runtime.BufferedTokenStream;
import repack.antlr.v4.runtime.ParserRuleContext;

/**
 * The caching parser extends the enhanced parser and returns previous parse
 * trees if they are available. This can't be used if the parse tree is
 * modified after parsing since then the contents of the cache would be modified
 * too. The {@link ASTBuilder} does not modify the parse tree, and therefore it
 * is safe to use this.
 */
public class CachingParser extends EnhancedParser {
  record CacheContents(ParserRuleContext parseTree, BufferedTokenStream tokenStream) {
  }

  private TypedTreeCache<CacheContents> parseCache;

  public CachingParser(boolean throwParseErrors, int cacheSize) {
    super(throwParseErrors);
    parseCache = new TypedTreeCache<>(cacheSize);
  }

  public CachingParser(int cacheSize) {
    parseCache = new TypedTreeCache<>(cacheSize);
  }

  public CachingParser(boolean throwParseErrors) {
    super(throwParseErrors);
    parseCache = new TypedTreeCache<>();
  }

  public CachingParser() {
    parseCache = new TypedTreeCache<>();
  }

  public void setParseCacheSizeAndClear(int size) {
    parseCache = new TypedTreeCache<>(size);
  }

  @Override
  public <C extends ParserRuleContext> C parse(
      String str,
      ParseShape<C, ?> parseShape) {
    return parse(str, null, parseShape);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <C extends ParserRuleContext> C parse(
      String str,
      ParserRuleContext parent,
      ParseShape<C, ?> parseShape) {
    var result = parseCache.cachedGet(str, parseShape.ruleType,
        () -> {
          var node = parse(str, parent, parseShape.parseMethod);
          return new CacheContents(node, getTokenStream());
        });
    if (result != null) {
      // so that when a cache hit happens, the getTokenStream method returns the
      // correct token stream 
      tokenStream = result.tokenStream;
      return (C) result.parseTree;
    } else {
      return null;
    }
  }

  @Override
  public void setTokenFilter(TokenFilter<?> tokenFilter) {
    super.setTokenFilter(tokenFilter);
    parseCache.clear();
  }
}
