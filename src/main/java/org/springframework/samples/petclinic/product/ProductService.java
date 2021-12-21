package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
	
	@Transactional
    public List<ProductType> getAllProductType(){
        return productRepository.findAllProductTypes();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }
    @Transactional
    public ProductType getProductType(String typeName) {
        return productRepository.findProductTypesByName(typeName);
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }
    

    
}
