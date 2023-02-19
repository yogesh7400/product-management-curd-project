package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.product.modal.Products;
import com.product.repositiory.ProductRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class Mycontroller {
	@Autowired
	private ProductRepository service;
	@GetMapping("/")
	public String home(Model model)
	{
	List<Products>list=service.findAll();
	model.addAttribute("all",list);
		
		return "index";
	}
	@GetMapping("/new")
	public String loadForm()
	{
		return "add";
	}
	@GetMapping("/edit_form/{id}")
	public String editForm(@PathVariable(value = "id") long id,Model model)
	{
		Optional<Products> product= service.findById(id);
		Products pro=product.get();
		model.addAttribute("product",pro);
		return "edit";
	}
	@PostMapping("/save_Products")
	public String saveProducts(@ModelAttribute Products products)
	{
		service.save(products);
		return "redirect:/new";
	}
	@PostMapping("/update_Products")
	public String updateProducts(@ModelAttribute Products products)
	{
		service.save(products);
	
		return "redirect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(value = "id")long id)
	{
		service.deleteById(id);
		
		return "redirect:/";
	}

}
