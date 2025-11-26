package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BestSellingProductDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.mapper.Mapper;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Sale;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.SaleDetail;
import cl.alexalvarez.pruebaTecnicaSupermercado.repository.SaleRepository;

@Service
public class StatisticsService implements IStatisticsService {

  @Autowired
  SaleRepository repoSale;

  @Override
  public BestSellingProductDTO getBestSellingPRoduct() {

    List<Sale> sales = repoSale.findAll();

    var aux = sales.stream()
        .flatMap(sale -> sale.getDetails().stream())
        .collect(Collectors.groupingBy(
            d -> Mapper.toDTO(d.getProduct()),
            Collectors.summingInt(SaleDetail::getQty)))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue());

    BestSellingProductDTO dto = new BestSellingProductDTO(aux.get().getKey(), aux.get().getValue());
    return dto;
  }

}
