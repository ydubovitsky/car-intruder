package space.dubovitsky.intruder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.dubovitsky.intruder.model.Declaration;
import space.dubovitsky.intruder.model.Status;

import java.util.List;

@Repository
public interface DeclarationRepo extends JpaRepository<Declaration, Long> {

    List<Declaration> findByStatus(Status status);

}
