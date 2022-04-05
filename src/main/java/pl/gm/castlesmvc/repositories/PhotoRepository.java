package pl.gm.castlesmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.gm.castlesmvc.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
