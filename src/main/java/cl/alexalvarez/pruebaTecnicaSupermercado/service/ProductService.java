package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.ProductDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.exception.NotFoundException;
import cl.alexalvarez.pruebaTecnicaSupermercado.mapper.Mapper;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Product;
import cl.alexalvarez.pruebaTecnicaSupermercado.repository.ProductoRepository;

@Service
public class ProductService implements IProductService {

  @Autowired
  ProductoRepository repo;

  @Override
  public ProductDTO createProduct(ProductDTO dto) {
    Product product = Mapper.toModel(dto);
    return Mapper.toDTO(repo.save(product));
  }

  @Override
  public List<ProductDTO> getAllProducts() {
    List<Product> products = repo.findAll();
    return products.stream().map(p -> Mapper.toDTO(p)).collect(Collectors.toList());
  }

  @Override
  public ProductDTO updateProduct(Long id, ProductDTO dto) {
    Product product = repo.findById(id)
        .orElseThrow(() -> new NotFoundException("No existe."));

    product.setName(dto.getName());
    product.setPrice(dto.getPrice());

    return Mapper.toDTO(repo.save(product));
  }

  @Override
  public void deleteProduct(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
  }
}
