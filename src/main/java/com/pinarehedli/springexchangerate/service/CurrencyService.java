package com.pinarehedli.springexchangerate.service;

import com.pinarehedli.springexchangerate.model.Currency;
import com.pinarehedli.springexchangerate.model.CurrencyRoot;
import com.pinarehedli.springexchangerate.model.CurrencyType;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

	public List<Currency> getAllCurrencies(String date) {
		String address = "https://www.cbar.az/currencies/";

		List<Currency> allCurrencies = new ArrayList<>();

		try {
			JAXBContext context = JAXBContext.newInstance(CurrencyRoot.class);

			// Process of converting a Java object into a format such as XML or JSON
			Unmarshaller unmarshaller = context.createUnmarshaller();

			if (date == null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

				String currentDay = dateFormat.format(new Date());

				URL url = new URL(address + currentDay + ".xml");

				CurrencyRoot data = (CurrencyRoot) unmarshaller.unmarshal(url);

				for (CurrencyType type : data.getTypes()) {
					allCurrencies.addAll(type.getCurrencies());
				}
			} else {
				URL url = new URL(address + date + ".xml");

				CurrencyRoot data = (CurrencyRoot) unmarshaller.unmarshal(url);

				for (CurrencyType type : data.getTypes()) {
					allCurrencies.addAll(type.getCurrencies());
				}
			}
		} catch (JAXBException | MalformedURLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return allCurrencies;
	}

	public Currency getCurrencyByName(String date, String name) {
		List<Currency> allCurrencies = getAllCurrencies(date);

		for (Currency currency : allCurrencies) {
			if (currency.getCode().equals(name)) {
				return currency;
			}
		}

		return null;
	}
}
