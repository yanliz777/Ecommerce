package com.uniquindio.ecommerce.backend.infrastructure.rest;

import com.uniquindio.ecommerce.backend.application.ProductService;
import com.uniquindio.ecommerce.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
//para mostrar los logs:
@Slf4j
/*
@CrossOrigin(origins = "http://localhost:4200"), le estás diciendo al
backend que permita solicitudes CORS únicamente desde el origen
especificado (http://localhost:4200). Es decir, le indicamos a spring boot que cliente
va aconsumir esta API REST:
 */
@CrossOrigin(origins = "http://localhost:4200")
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
