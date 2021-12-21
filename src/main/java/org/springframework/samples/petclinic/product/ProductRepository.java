package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Query("SELECT p from Product p")
    List<Product> findAll();
	@Query("SELECT p from ProductType p")
    List<ProductType> findAllProductTypes();
	@Query("SELECT p from ProductType p WHERE p.name LIKE :name%")
    ProductType findProductTypesByName(@Param("name") String name);
	
	@Query("SELECT p from Product p WHERE p.price<:coste")
	List<Product> findByPriceLessThan(@Param("coste") Double coste);
//    Optional<Product> findById(int id);
//    Product save(Product p);
	 Product findByName(String name);
    
}
