package com.pinarehedli.springexchangerate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExchangeRateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringExchangeRateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String date = "01.01.2025";
        String strUrl = "https://www.cbar.az/currencies/" + date + ".xml";
        System.out.println(strUrl);
    }
}
