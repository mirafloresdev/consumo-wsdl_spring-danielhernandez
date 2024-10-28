package com.davivienda.evaluacion.service;

import com.davivienda.evaluacion.model.NumberEntity;
import com.davivienda.evaluacion.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.davivienda.evaluacion.wsdl.NumberToDollars;


import java.math.BigDecimal;

@Service
public class NumberService {

    public String convertNumberToDollars(BigDecimal number) {
        NumberToDollars numberToDollars = new NumberToDollars();
        numberToDollars.setDNum(number);

        return "$" + numberToDollars.getDNum().toString();
    }
}
