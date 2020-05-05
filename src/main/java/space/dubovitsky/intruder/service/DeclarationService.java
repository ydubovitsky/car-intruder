package space.dubovitsky.intruder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import space.dubovitsky.intruder.model.Declaration;
import space.dubovitsky.intruder.model.Status;
import space.dubovitsky.intruder.repositories.DeclarationRepo;

import java.util.List;

@Service
public class DeclarationService {

    private DeclarationRepo declarationRepo;

    @Autowired
    public DeclarationService(DeclarationRepo declarationRepo) {
        this.declarationRepo = declarationRepo;
    }

    public List<Declaration> getAllDeclarations() {
        List<Declaration> all = declarationRepo.findAll(Sort.by("id"));
        return all;
    }

    public void saveDeclaration(Declaration declaration) {
        declarationRepo.save(declaration);
    }

    public List<Declaration> declarationsByStatus(Status status) {
        List<Declaration> byStatus = declarationRepo.findByStatus(status);
        return byStatus;
    }

}
