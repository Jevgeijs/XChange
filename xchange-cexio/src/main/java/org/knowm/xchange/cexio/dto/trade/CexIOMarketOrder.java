package org.knowm.xchange.cexio.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Author: brox Since: 2/5/14 */
public class CexIOMarketOrder {

  private final long id;
  private final long time;
  private final Type type;
  private final long symbol2Amount;
  private final long symbol1Amount;
  private final String errorMessage;
  private final String symbol1;
  private final String symbol2;

  /**
   * Constructor
   *
   * @param id
   * @param time
   * @param type
   * @param symbol2Amount
   * @param symbol1Amount
   * @param symbol1
   * @param symbol2
   */
  public CexIOMarketOrder(
      @JsonProperty("id") long id,
      @JsonProperty("time") long time,
      @JsonProperty("type") Type type,
      @JsonProperty("symbol2Amount") long symbol2Amount,
      @JsonProperty("symbol1Amount") long symbol1Amount,
      @JsonProperty("symbol1") String symbol1,
      @JsonProperty("symbol2") String symbol2,
      @JsonProperty("error") String errorMessage) {

    this.id = id;
    this.time = time;
    this.type = type;
    this.symbol2Amount = symbol2Amount;
    this.symbol1Amount = symbol1Amount;
    this.symbol1 = symbol1;
    this.symbol2 = symbol2;
    this.errorMessage = errorMessage;
  }

  public long getId() {

    return id;
  }

  public long getTime() {

    return time;
  }

  public Type getType() {

    return type;
  }

  public Long getSymbol2Amount() {

    return symbol2Amount;
  }

  public Long getSymbol1Amount() {

    return symbol1Amount;
  }

  public String getErrorMessage() {

    return errorMessage;
  }

  public String getSymbol1() {

    return symbol1;
  }

  public String getSymbol2() {

    return symbol2;
  }

  @Override
  public String toString() {

    return errorMessage != null
        ? errorMessage
        : String.format(
            "Order{id=%s, time=%s, type=%s, symbol2Amount=%s, symbol1Amount=%s, symbol1=%s, symbol2=%s}",
            id, time, type, symbol2Amount, symbol1Amount, symbol1, symbol2);
  }

  public enum Type {
    buy,
    sell
  }
}
