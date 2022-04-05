package pl.gm.castlesmvc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.castlesmvc.model.Castle;
import pl.gm.castlesmvc.model.Photo;
import pl.gm.castlesmvc.repositories.CastleRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CastleService implements  ICastleService {


    private final CastleRepository castleRepository;
    private final PhotoService photoService;

    public List<Castle> listAll() {
        return castleRepository.findAll();
    }

    public void save(Castle castleDTO) {
        castleRepository.save(castleDTO);
    }

    public Castle get(long id) {
        return castleRepository.findById(id).get();
    }

    public void update(Castle castleDTO) {
        castleRepository.save(castleDTO);
    }

    public void delete(long id) {
        castleRepository.deleteById(id);
    }

    public void saveImage(MultipartFile imageFile, Photo photo) throws Exception {
        photoService.savePhotoImage(photo, imageFile);
        photoService.save(photo);
    }
}
