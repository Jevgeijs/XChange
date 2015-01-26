package com.xeiam.xchange.btce.v3;

import si.mazi.rescu.SynchronizedValueFactory;

import com.xeiam.xchange.BaseExchange;
import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.btce.v3.service.polling.BTCEAccountService;
import com.xeiam.xchange.btce.v3.service.polling.BTCEMarketDataService;
import com.xeiam.xchange.btce.v3.service.polling.BTCETradeService;
import com.xeiam.xchange.utils.nonce.IntTimeNonceFactory;

public class BTCEExchange extends BaseExchange implements Exchange {

  private final SynchronizedValueFactory<Integer> nonceFactory = new IntTimeNonceFactory();

  @Override
  public void applySpecification(ExchangeSpecification exchangeSpecification) {

    super.applySpecification(exchangeSpecification);

    this.pollingMarketDataService = new BTCEMarketDataService(this);
    // TODO look at this
    this.pollingAccountService = new BTCEAccountService(this, nonceFactory);
    this.pollingTradeService = new BTCETradeService(this, nonceFactory);
  }

  @Override
  public ExchangeSpecification getDefaultExchangeSpecification() {

    ExchangeSpecification exchangeSpecification = new ExchangeSpecification(this.getClass().getCanonicalName());
    exchangeSpecification.setSslUri("https://btc-e.com");
    exchangeSpecification.setHost("btc-e.com");
    exchangeSpecification.setPort(80);
    exchangeSpecification.setExchangeName("BTC-e");
    exchangeSpecification.setExchangeDescription("BTC-e is a Bitcoin exchange registered in Russia.");

    return exchangeSpecification;
  }

}
