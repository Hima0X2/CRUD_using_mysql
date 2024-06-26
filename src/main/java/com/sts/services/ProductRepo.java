package com.sts.services;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;

import com.sts.model.Product;
@Repository
public interface ProductRepo extends CrudRepository<Product,Integer>{

}
