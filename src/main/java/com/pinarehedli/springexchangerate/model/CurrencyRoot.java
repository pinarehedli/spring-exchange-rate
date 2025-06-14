package com.pinarehedli.springexchangerate.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Setter;

import java.util.List;

@Setter
@XmlRootElement(name = "ValCurs")
public class CurrencyRoot {
    private String date;
    private String name;
    private List<CurrencyType> types;

    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }

	@XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

	@XmlElement(name = "ValType")
    public List<CurrencyType> getTypes() {
        return types;
    }

}
