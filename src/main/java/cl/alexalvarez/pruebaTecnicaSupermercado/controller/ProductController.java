package cl.alexalvarez.pruebaTecnicaSupermercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.ProductDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  IProductService productService;

  @PostMapping
  public ResponseEntity<?> createProduct(@RequestBody ProductDTO product) {
    ProductDTO newProduct = productService.createProduct(product);
    return ResponseEntity.ok(newProduct);
  }
}
