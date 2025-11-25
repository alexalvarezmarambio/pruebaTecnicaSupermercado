package cl.alexalvarez.pruebaTecnicaSupermercado.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.SaleDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.service.ISaleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/sales")
public class SaleController {
  @Autowired
  ISaleService saleService;

  @PostMapping
  public ResponseEntity<?> createSale(@RequestBody SaleDTO dto) {
    SaleDTO sale = saleService.createSale(dto);
    return ResponseEntity.ok(sale);
  }

  @GetMapping
  public ResponseEntity<?> getAllSales() {
    List<SaleDTO> sales = saleService.getAllSales();

    return ResponseEntity.ok(sales);
  }

}
