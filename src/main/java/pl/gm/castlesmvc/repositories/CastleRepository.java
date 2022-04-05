package pl.gm.castlesmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gm.castlesmvc.model.Castle;

public interface CastleRepository extends JpaRepository<Castle, Long> {

}
