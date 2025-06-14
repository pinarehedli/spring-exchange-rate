package com.pinarehedli.springexchangerate.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Setter;

import java.util.List;

@Setter
public class CurrencyType {
    private String type;
    private List<Currency> currencies;

    @XmlAttribute(name = "Type")
    public String getType() {
        return type;
    }

	@XmlElement(name = "Valute")
    public List<Currency> getCurrencies() {
        return currencies;
    }

}
