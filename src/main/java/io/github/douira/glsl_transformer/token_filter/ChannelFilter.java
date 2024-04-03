package io.github.douira.glsl_transformer.token_filter;

import io.github.douira.glsl_transformer.ast.transform.JobParameters;
import repack.antlr.v4.runtime.Token;

import java.util.EnumSet;

/**
 * The channel filter accepts all tokens that are not from a lexer channel that
 * is on the given list of disallowed channels.
 */
public class ChannelFilter<J extends JobParameters> extends TokenFilter<J> {
  private final EnumSet<TokenChannel> disallowedChannels;

  /**
   * Creates a new channel filter with the given disallowed channels.
   *
   * @param disallowedChannels The disallowed channels
   */
  public ChannelFilter(EnumSet<TokenChannel> disallowedChannels) {
    this.disallowedChannels = disallowedChannels;
  }

  /**
   * Creates a new channel filter with a single disallowed channel.
   *
   * @param disallowedChannel The disallowed channel
   */
  public ChannelFilter(TokenChannel disallowedChannel) {
    this(EnumSet.of(disallowedChannel));
  }

  @Override
  public boolean isTokenAllowed(Token token) {
    return !disallowedChannels.contains(TokenChannel.getTokenChannel(token));
  }
}
