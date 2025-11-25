package cl.alexalvarez.pruebaTecnicaSupermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.alexalvarez.pruebaTecnicaSupermercado.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
