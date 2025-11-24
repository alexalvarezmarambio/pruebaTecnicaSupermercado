package cl.alexalvarez.pruebaTecnicaSupermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.alexalvarez.pruebaTecnicaSupermercado.model.Product;

public interface ProductoRepository extends JpaRepository<Product, Long> {
}
