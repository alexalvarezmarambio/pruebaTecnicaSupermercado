package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.SaleDTO;

public interface ISaleService {

  public SaleDTO createSale(SaleDTO dto);

  public List<SaleDTO> getAllSales();

  public SaleDTO updateSale(Long id, SaleDTO dto);

  public void deleteSale(Long id);
}
