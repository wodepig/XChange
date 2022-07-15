package org.knowm.xchange.ascendex.service;

import java.io.IOException;
import java.util.List;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ascendex.AscendexException;
import org.knowm.xchange.ascendex.dto.AscendexResponse;
import org.knowm.xchange.ascendex.dto.account.AscendexAccountInfoDto;
import org.knowm.xchange.ascendex.dto.account.AscendexCashAccountBalanceDto;

public class AscendexAccountServiceRaw extends AscendexBaseService {

  public AscendexAccountServiceRaw(Exchange exchange) {
    super(exchange);
  }

  public AscendexAccountInfoDto getAscendexAccountInfo() throws AscendexException, IOException {
    return checkResult(
            ascendexAuthenticated.getAccountInfo(
                    exchange.getExchangeSpecification().getApiKey(),
                    exchange.getNonceFactory().createValue(),
                    signatureCreator
            )
    );

  }

  public List<AscendexCashAccountBalanceDto> getAscendexCashAccountBalance()
      throws AscendexException, IOException {
    return checkResult(
        ascendexAuthenticated.getCashAccountBalance(
            exchange.getExchangeSpecification().getApiKey(),
            exchange.getNonceFactory().createValue(),
            signatureCreator));
  }
}
