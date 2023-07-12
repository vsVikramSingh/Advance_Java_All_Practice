package com.cdac.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.training.model.Product;
import com.cdac.training.service.ProductService;

@Controller
public class ProductController {
	 @Autowired
	 private ProductService service;
	 
	 //1. implementing list of exist products
	 @RequestMapping("/")
	 public String viewHomePage(Model model) {
	     List<Product> products = service.listAll();
	     model.addAttribute("products", products);
	      
	     return "index";
	 }
	 
	 //2. implementing insert new product
	 @RequestMapping("/new")
	 public String showNewProductPage(Model model) {
	     Product product = new Product();
	     model.addAttribute("product", product);
	      
	     return "new_product";
	 }
	 
	 // 3. save inserted record in database
	 @RequestMapping(value = "/save", method = RequestMethod.POST)
	 public String saveProduct(@ModelAttribute("product") Product product) {
	     service.save(product);
	      
	     return "redirect:/";
	 }
	 
	 //4. edit ixisting record
	 @RequestMapping("/edit/{id}")
	 public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	     ModelAndView mav = new ModelAndView("edit_product");
	     Product product = service.get(id);
	     mav.addObject("product", product);
	      
	     return mav;
	 }
	 
	 //5. delete existing record
	 @RequestMapping("/delete/{id}")
	 public String deleteProduct(@PathVariable(name = "id") int id) {
	     service.delete(id);
	     return "redirect:/";       
	 }
	 
}
