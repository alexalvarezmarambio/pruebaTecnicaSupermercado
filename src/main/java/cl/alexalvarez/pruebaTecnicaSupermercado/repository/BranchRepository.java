package cl.alexalvarez.pruebaTecnicaSupermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.alexalvarez.pruebaTecnicaSupermercado.model.Branch;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
