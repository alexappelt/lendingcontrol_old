package edu.unoesc.project.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProdutoController {
	
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		
		
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "produtos/index";
	}
	
	@RequestMapping(value = "/cadastroproduto", method = RequestMethod.POST)
	public String cadastro(Locale locale, Model model) {
		System.out.println("Passou aqui");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		
		
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "produtos/index";
	}

}
