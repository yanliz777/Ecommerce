package com.uniquindio.ecommerce.backend.infrastructure.rest;

import com.uniquindio.ecommerce.backend.application.ProductService;
import com.uniquindio.ecommerce.backend.domain.model.Category;
import com.uniquindio.ecommerce.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Slf4j//para mostrar los logs
@RequestMapping("/api/v1/admin/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/saveProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        log.info("Nombre producto: {}", product.getName());
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping("/findAllProducts")
    public ResponseEntity<Iterable<Product>> findAllProducts() {
        return new ResponseEntity(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.ok().build();//retorna un código 200
    }

}
