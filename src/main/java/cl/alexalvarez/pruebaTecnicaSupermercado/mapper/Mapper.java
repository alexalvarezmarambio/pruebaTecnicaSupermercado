package cl.alexalvarez.pruebaTecnicaSupermercado.mapper;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BranchDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Branch;

public class Mapper {

  public static BranchDTO toDTO(Branch b) {
    return BranchDTO.builder()
        .id(b.getId())
        .name(b.getName())
        .build();
  }

  public static Branch toModel(BranchDTO b) {
    return Branch.builder()
        .id(b.getId())
        .name(b.getName())
        .build();
  }
}
