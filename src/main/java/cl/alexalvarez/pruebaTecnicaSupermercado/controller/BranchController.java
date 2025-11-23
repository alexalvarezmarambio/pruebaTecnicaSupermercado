package cl.alexalvarez.pruebaTecnicaSupermercado.controller;

import org.springframework.web.bind.annotation.RestController;

import cl.alexalvarez.pruebaTecnicaSupermercado.dto.BranchDTO;
import cl.alexalvarez.pruebaTecnicaSupermercado.service.IBranchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

  @Autowired
  private IBranchService branchService;

  @GetMapping
  public ResponseEntity<?> getAllBranches() {
    List<BranchDTO> branches = branchService.getAllBranches();
    return ResponseEntity.ok(branches);
  }

  @PostMapping
  public ResponseEntity<?> createBranch(@RequestBody BranchDTO branch) {
    BranchDTO newBrach = branchService.createBranch(branch);
    return ResponseEntity.ok(newBrach);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateBranch(@PathVariable Long id, @RequestBody BranchDTO dto) {
    BranchDTO branch = branchService.updateBranch(id, dto);
    return ResponseEntity.ok(branch);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteBranch(@PathVariable Long id) {
    branchService.deleteBranch(id);
    return ResponseEntity.ok("ok");
  }
}
