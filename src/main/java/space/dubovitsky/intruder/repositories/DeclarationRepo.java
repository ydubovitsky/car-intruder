package space.dubovitsky.intruder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.dubovitsky.intruder.model.Declaration;

@Repository
public interface DeclarationRepo extends JpaRepository<Declaration, Long> {
}
