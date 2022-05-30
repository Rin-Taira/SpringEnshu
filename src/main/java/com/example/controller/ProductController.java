package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.controller.form.ProductForm;
import com.example.controller.form.UserForm;
import com.example.entity.Product;

@Controller
public class ProductController {

    @RequestMapping(value="/index")
    public String index(@ModelAttribute("index") ProductForm form, Model model) {
    	
    	List<Product> productList = new ArrayList<>();
        productList.add(new Product(101, "鉛筆", 50));
        productList.add(new Product(102, "消しゴム", 100));
        
        model.addAttribute("productList", productList);
        
        return "index";
    }

    @RequestMapping(value="/result", method=RequestMethod.POST)
    public String post(@ModelAttribute("test") ProductForm productForm, UserForm userForm, Model model) {
    	
    	int id = productForm.getProductId();
    	String name = userForm.getName();
    	
    	Product product = null;
    	switch (id) {
    	case 101:
    		product = new Product(101, "鉛筆", 50);
    		break;
    	case 102:
    		product = new Product(102, "消しゴム", 100);
    		break;
    	}
    	
        model.addAttribute("product", product);
        model.addAttribute("user", name);
        
        return "result";
    }

}
