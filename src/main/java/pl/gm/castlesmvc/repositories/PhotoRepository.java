package pl.gm.castlesmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.gm.castlesmvc.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("SELECT p FROM Photo p WHERE p.fileName = :fileName")
    Photo getPhotoByFileName(@Param("fileName") String fileName);
}
