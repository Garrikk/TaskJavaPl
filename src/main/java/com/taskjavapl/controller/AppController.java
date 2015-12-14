package com.taskjavapl.controller;

import com.taskjavapl.model.Product;
import com.taskjavapl.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	ProductService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * This method will list all existing product.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listProduct(ModelMap model) {

		List<Product> product = service.findAllProduct();
		model.addAttribute("product", product);
		return "allproduct";
	}

	/*
	 * This method will provide the medium to add a new product.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("edit", false);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving product in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isProductSsnUnique(product.getId(), product.getSsn())){
			FieldError ssnError =new FieldError("product","ssn",messageSource.getMessage("non.unique.ssn", new String[]{product.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}

		service.saveProduct(product);

		model.addAttribute("success", "Product " + product.getName() + " registered successfully");
		return "success";
	}


	/*
	 * This method will provide the medium to update an existing product.
	 */
	@RequestMapping(value = { "/edit{ssn}" }, method = RequestMethod.GET)
	public String editProduct(@PathVariable String ssn, ModelMap model) {
		Product product = service.findProductBySsn(ssn);
		model.addAttribute("product", product);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating product in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit{ssn}" }, method = RequestMethod.POST)
	public String updateProduct(@Valid Product product, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isProductSsnUnique(product.getId(), product.getSsn())){
			FieldError ssnError =new FieldError("product","ssn",messageSource.getMessage("non.unique.ssn", new String[]{product.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}

		service.updateProduct(product);

		model.addAttribute("success", "Product " + product.getName()	+ " updated successfully");
		return "success";
	}

	/*
	 * This method will delete an product by it's SSN value.
	 */
	@RequestMapping(value = { "/delete{ssn}" }, method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String ssn) {
		service.deleteProductBySsn(ssn);
		return "redirect:/list";
	}

}
