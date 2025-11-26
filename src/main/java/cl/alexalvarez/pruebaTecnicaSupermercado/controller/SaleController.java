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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

  @PutMapping("{id}")
  public ResponseEntity<?> updateSale(@PathVariable Long id, @RequestBody SaleDTO dto) {
    SaleDTO sale = saleService.updateSale(id, dto);
    return ResponseEntity.ok(sale);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<?> deleteSale(@PathVariable Long id) {
    saleService.deleteSale(id);
    return ResponseEntity.ok("Ok");
  }
}
