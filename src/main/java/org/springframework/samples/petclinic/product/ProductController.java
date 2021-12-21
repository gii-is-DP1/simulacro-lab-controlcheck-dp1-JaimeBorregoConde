package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    
	private final ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
		
	}
	
	@ModelAttribute("productTypes")
	public List<ProductType> populateProductTypes() {
		return this.productService.getAllProductType();
	}
	
	@GetMapping(value = "/product/create")
	public String initCreationForm(Map<String, Object> model) {
		String view="products/createOrUpdateProductForm"
				+ "";
		Product product = new Product();
		model.put("product", product);
		
		return view;
	}
	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {
		String view="products/createOrUpdateProductForm";
		if (result.hasErrors()) {
			return view;
		}
		else {
			//creating owner, user and authorities
			this.productService.save(product);
			
			return view;
		}
	}
	
	
}
