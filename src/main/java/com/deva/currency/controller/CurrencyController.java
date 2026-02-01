package com.deva.currency.controller;
import com.deva.currency.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CurrencyController {

    @Autowired
    private ConverterService converterService;

    @GetMapping("/convert")
    public String convertCurrency(
        @RequestParam String from,
        @RequestParam String to,
        @RequestParam double amount,
        Model model
    )
    {
        double result=converterService.convert(from,to,amount);
        model.addAttribute("result",amount + " " + from + " = " + result + " " + to);

        return "result.html";
    }

}
