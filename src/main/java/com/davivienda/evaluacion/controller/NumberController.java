package com.davivienda.evaluacion.controller;

import com.davivienda.evaluacion.service.NumberService;
import com.davivienda.evaluacion.wsdl.NumberToWords;
import com.davivienda.evaluacion.wsdl.NumberToWordsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
public class NumberController {

    @Autowired
    private NumberService conversionService;

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    private final String serviceUri = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";

    @GetMapping("/numberToWords")
    public String convertNumberToWords(@RequestParam("number") long number) {
        NumberToWords request = new NumberToWords();
        request.setUbiNum(BigInteger.valueOf(number));
        NumberToWordsResponse response = (NumberToWordsResponse) webServiceTemplate.marshalSendAndReceive(serviceUri, request);
        return response.getNumberToWordsResult();
    }

    @GetMapping("/convertToDollars")
    public String convertToDollars(@RequestParam BigDecimal number) {
        return conversionService.convertNumberToDollars(number);
    }

}
