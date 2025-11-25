package cl.alexalvarez.pruebaTecnicaSupermercado.mapper;

import java.util.List;
import java.util.stream.Collectors;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BranchDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.dto.ProductDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.dto.SaleDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.dto.SaleDetailDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Branch;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Product;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Sale;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.SaleDetail;

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

  public static Sale toModel(SaleDTO s, Branch branch) {
    return Sale.builder()
        .id(s.getId())
        .date(s.getDate())
        .total(s.getTotal())
        .branch(branch)
        .build();
  }

  public static List<SaleDetail> toModel(SaleDTO s, Sale sale) {
    return s.getDetails().stream().map(
        d -> {
          var product = Product.builder()
              .id(d.getProduct().getId())
              .name(d.getProduct().getName())
              .price(d.getProduct().getPrice())
              .build();

          return SaleDetail.builder()
              .id(d.getId())
              .qty(d.getQty())
              .price(d.getPrice())
              .product(product)
              .sale(sale)
              .build();
        }).collect(Collectors.toList());
  }

  public static SaleDTO toDTO(Sale s) {
    var details = s.getDetails().stream().map(
        d -> {
          var product = ProductDTO.builder()
              .id(d.getProduct().getId())
              .name(d.getProduct().getName())
              .price(d.getProduct().getPrice())
              .build();

          return SaleDetailDTO.builder()
              .id(d.getId())
              .qty(d.getQty())
              .price(d.getPrice())
              .product(product)
              .build();
        }).collect(Collectors.toList());

    return SaleDTO.builder()
        .id(s.getId())
        .date(s.getDate())
        .total(s.getTotal())
        .branchId(s.getBranch().getId())
        .details(details)
        .build();
  }
}
