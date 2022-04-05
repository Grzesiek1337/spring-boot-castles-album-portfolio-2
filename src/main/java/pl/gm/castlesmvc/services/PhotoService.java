package pl.gm.castlesmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.castlesmvc.model.Photo;
import pl.gm.castlesmvc.repositories.PhotoRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class PhotoService implements  IPhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public void savePhotoImage(Photo photoDTO, MultipartFile imageFile) throws Exception {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photoDTO.setPath(absolutePath + "/src/main/resources/static/photos/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photoDTO.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    @Override
    public void save(Photo photoDTO) {
        photoRepository.save(photoDTO);
    }
}
