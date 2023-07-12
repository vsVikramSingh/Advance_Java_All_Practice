package com.cdac.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cdac.training.bean.Product;
import com.cdac.training.dao.ProductManagerImpl;

@Controller
//@RequestMapping("/product")
public class ProductController {
	private static int id=0;
	@Autowired
	private ProductManagerImpl manager;
	
	private int generateProdId() {
		return ++id;
	}
	
	@GetMapping("/")
	//@RequestMapping(value="/", method=RequestMethod.GET)
	public String getAllProducts(Model model) {
		model.addAttribute("products",manager.getProducts());
		return "index";
	}
	
	@GetMapping("/add")
	//@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddForm(Model model) {
		model.addAttribute("product",new Product());
		return "add";
	}
	
	@PostMapping("/add")
	public String addNewProduct(@ModelAttribute("product") Product product) {
		product.setProdId(generateProdId());
		manager.addProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") int id,Model model) {
		System.out.println("data shown for modification");
		Product product=manager.getProductById(id);
		System.out.println("data found:"+product);
		model.addAttribute("product",product);
		return "edit";
	}
	
	@PostMapping("/update/{id}")
	public String updateProduct(@PathVariable("id") int id, @ModelAttribute("product") Product product) {
		System.out.println("called for updata in collection after updating in form"+product);
		manager.modProduct(product);
		System.out.println("going back to index page..");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		manager.delProductById(id);
		return "redirect:/";
	}
}