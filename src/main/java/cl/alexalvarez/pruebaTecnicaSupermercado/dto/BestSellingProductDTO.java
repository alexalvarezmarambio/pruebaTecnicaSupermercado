package cl.alexalvarez.pruebaTecnicaSupermercado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BestSellingProductDTO {
  ProductDTO product;
  Integer qty;
}
