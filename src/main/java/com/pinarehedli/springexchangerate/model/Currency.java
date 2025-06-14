package com.pinarehedli.springexchangerate.model;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
public class Currency {
    private String code;
    private String nominal;
    private String name;
    private BigDecimal value;

    @XmlAttribute(name = "Code")
    public String getCode() {
        return code;
    }

	@XmlElement(name = "Nominal")
    public String getNominal() {
        return nominal;
    }

	@XmlElement(name = "Name")
    public String getName() {
        return name;
    }

	@XmlElement(name = "Value")
    public BigDecimal getValue() {
        return value;
    }

}
