package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.ProductDTO;
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllProducts'");
  }

  @Override
  public ProductDTO updateProduct(Long id, ProductDTO product) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
  }

  @Override
  public void deleteProduct(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
  }
}
