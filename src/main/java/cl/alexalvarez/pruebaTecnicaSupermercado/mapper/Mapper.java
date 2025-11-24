package cl.alexalvarez.pruebaTecnicaSupermercado.mapper;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BranchDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.dto.ProductDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Branch;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Product;

public class Mapper {

  public static BranchDTO toDTO(Branch b) {
    return BranchDTO.builder()
        .id(b.getId())
        .name(b.getName())
        .build();
  }

  public static Branch toModel(BranchDTO b) {
    return Branch.builder()
        .id(b.getId())
        .name(b.getName())
        .build();
  }

  public static ProductDTO toDTO(Product p) {
    return ProductDTO.builder()
        .id(p.getId())
        .name(p.getName())
        .price(p.getPrice())
        .build();
  }

  public static Product toModel(ProductDTO p) {
    return Product.builder()
        .id(p.getId())
        .name(p.getName())
        .price(p.getPrice())
        .build();
  }
}
