package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BranchDTO;

public interface IBranchService {

  public List<BranchDTO> getAllBranches();

  public BranchDTO createBranch(BranchDTO branch);

  public BranchDTO updateBranch(Long id, BranchDTO branch);

  public void deleteBranch(Long id);
}
