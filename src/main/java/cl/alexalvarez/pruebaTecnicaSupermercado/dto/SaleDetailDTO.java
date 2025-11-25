package cl.alexalvarez.pruebaTecnicaSupermercado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaleDetailDTO {
  Long id;
  ProductDTO product;
  Integer qty;
  Double price;
}
