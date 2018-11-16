package org.knowm.xchange.cexio.dto;

import org.knowm.xchange.cexio.dto.trade.CexIOOrder;

import java.math.BigDecimal;

public class PlaceMarketOrderRequest extends CexIORequest {
  public final CexIOOrder.Type type;
  public final BigDecimal amount;
  public final String order_type = "market";

  public PlaceMarketOrderRequest(CexIOOrder.Type type, BigDecimal amount) {
    this.type = type;
    this.amount = amount;
  }
}