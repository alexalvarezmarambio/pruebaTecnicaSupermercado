package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.SaleDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.exception.NotFoundException;
import cl.alexalvarez.pruebaTecnicaSupermercado.mapper.Mapper;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Branch;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Sale;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.SaleDetail;
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
    List<SaleDetail> details = Mapper.toModel(dto, sale);
    sale.setDetails(details);
    return Mapper.toDTO(repo.save(sale));
  }

  @Override
  public List<SaleDTO> getAllSales() {
    List<Sale> sales = repo.findAll();
    List<SaleDTO> dtos = sales.stream().map(
        s -> Mapper.toDTO(s)).collect(Collectors.toList());

    return dtos;
  }

  @Override
  public SaleDTO updateSale(Long id, SaleDTO dto) {
    Sale sale = repo.findById(id).orElseThrow(() -> new NotFoundException("No existe"));

    if (dto.getBranchId() != null) {
      Branch branch = repoBranch.findById(dto.getBranchId()).orElse(null);
      if (branch != null) {
        sale.setBranch(branch);
      }
    }

    if (dto.getTotal() != null) {
      sale.setTotal(dto.getTotal());
    }

    return Mapper.toDTO(repo.save(sale));
  }

  @Override
  public void deleteSale(Long id) {
    Sale sale = repo.findById(id).orElseThrow(() -> new NotFoundException("No existe."));

    repo.delete(sale);
  }

}
