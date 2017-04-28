package technancy.javatraining.dao;

import technancy.javatraining.dto.Product;

import java.util.List;

public interface ProductDao {
    List<Product> findAll();
}
