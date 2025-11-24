package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.ProductDTO;

public interface IProductService {

  public ProductDTO createProduct(ProductDTO product);

  public List<ProductDTO> getAllProducts();

  public ProductDTO updateProduct(Long id, ProductDTO product);

  public void deleteProduct(Long id);
}
