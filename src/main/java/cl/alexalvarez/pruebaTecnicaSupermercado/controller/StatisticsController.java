package cl.alexalvarez.pruebaTecnicaSupermercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BestSellingProductDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.service.IStatisticsService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

  @Autowired
  IStatisticsService statisticsService;

  @GetMapping("/best-selling-product")
  public ResponseEntity<?> getMethodName() {
    BestSellingProductDTO dto = statisticsService.getBestSellingPRoduct();
    return ResponseEntity.ok(dto);
  }

}
