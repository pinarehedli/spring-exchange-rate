package com.pinarehedli.springexchangerate.controller;

import com.pinarehedli.springexchangerate.model.Currency;
import com.pinarehedli.springexchangerate.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/exchange-rate")
public class RestCurrencyController {

	private final CurrencyService currencyService;

	@GetMapping(path = {"/currencies/", "/currencies/{date}"})
	public List<Currency> getAllCurrencies(@PathVariable (name = "date", required = false) String date) {
		return currencyService.getAllCurrencies(date);
	}

	@GetMapping(path = {"/currency/{date}/{name}", "/currency/{name}"})
	public Currency getCurrencyByName(@PathVariable (name = "date", required = false) String date,
	                                  @PathVariable (name = "name") String name) {

		return currencyService.getCurrencyByName(date, name);
	}
}

