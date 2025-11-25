package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.SaleDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.mapper.Mapper;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Branch;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Sale;
import cl.alexalvarez.pruebaTecnicaSupermercado.repository.BranchRepository;
import cl.alexalvarez.pruebaTecnicaSupermercado.repository.SaleRepository;

@Service
public class SaleService implements ISaleService {

  @Autowired
  SaleRepository repo;
  @Autowired
  BranchRepository repoBranch;

  @Override
  public SaleDTO createSale(SaleDTO dto) {
    Branch branch = repoBranch.findById(dto.getBranchId())
        .orElseThrow();
    Sale sale = Mapper.toModel(dto, branch);
    return Mapper.toDTO(repo.save(sale));
  }

  @Override
  public List<SaleDTO> getAllSales() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAllSales'");
  }

  @Override
  public SaleDTO updateSale(Long id, SaleDTO dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateSale'");
  }

  @Override
  public void deleteSale(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteSale'");
  }

}
