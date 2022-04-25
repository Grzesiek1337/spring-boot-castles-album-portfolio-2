package pl.gm.castlesmvc.services;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.castlesmvc.model.Photo;
import java.util.List;


public interface IPhotoService {

    List<Photo> listAll();

    void save(Photo photo);

    Photo get(long id);

    void update(Photo photo);

    void delete(long id);

    void savePhotoImage(Photo photoDTO, MultipartFile imageFile) throws Exception;
}
