package pl.gm.castlesmvc.services;


import org.springframework.web.multipart.MultipartFile;
import pl.gm.castlesmvc.model.Photo;


public interface IPhotoService {

    void savePhotoImage(Photo photoDTO, MultipartFile imageFile) throws Exception;

    void save(Photo photoDTO);

}
