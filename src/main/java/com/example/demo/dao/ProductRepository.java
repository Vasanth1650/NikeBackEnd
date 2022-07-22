/**
 * ProductRepository Data Access Object Which Used To Manipulate Certain Methods Defined In Jpa Which Is Rest Operation
 * 
 */

package com.example.demo.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

	//The Are Multiple Gender Which Helps To Retrive Multiple Object According To The Gender Type
	List<Product> findByGender(String gender);

	List<Product> findByCategory1(String category1);

	Product save(ProductDto product);


}
