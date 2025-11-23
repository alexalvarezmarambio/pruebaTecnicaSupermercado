package cl.alexalvarez.pruebaTecnicaSupermercado.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BranchDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.exception.NotFoundException;
import cl.alexalvarez.pruebaTecnicaSupermercado.mapper.Mapper;
import cl.alexalvarez.pruebaTecnicaSupermercado.model.Branch;
import cl.alexalvarez.pruebaTecnicaSupermercado.repository.BranchRepository;

@Service
public class BranchService implements IBranchService {

  @Autowired
  BranchRepository repo;

  @Override
  public List<BranchDTO> getAllBranches() {
    List<Branch> branches = repo.findAll();

    List<BranchDTO> branchDTOs = branches.stream().map(b -> Mapper.toDTO(b)).collect(Collectors.toList());

    return branchDTOs;
  }

  @Override
  public BranchDTO createBranch(BranchDTO branch) {
    Branch newBranch = Mapper.toModel(branch);
    return Mapper.toDTO(repo.save(newBranch));
  }

  @Override
  public BranchDTO updateBranch(Long id, BranchDTO dto) {
    Branch branch = repo.findById(id)
        .orElseThrow(() -> new NotFoundException("No existe."));

    branch.setName(dto.getName());

    return Mapper.toDTO(repo.save(branch));
  }

  @Override
  public void deleteBranch(Long id) {
    Branch branch = repo.findById(id).orElseThrow(() -> new NotFoundException("No Existe."));

    repo.delete(branch);
  }

}
