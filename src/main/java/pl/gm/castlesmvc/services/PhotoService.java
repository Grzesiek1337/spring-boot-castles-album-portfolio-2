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
import java.util.List;

@Service
@Transactional
public class PhotoService implements IPhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public void savePhotoImage(Photo photo, MultipartFile imageFile) throws Exception {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photo.setPath(absolutePath + "/src/main/resources/static/photos/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photo.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }

    @Override
    public List<Photo> listAll() {
        return photoRepository.findAll();
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public Photo get(long id) {
        return photoRepository.getById(id);
    }

    @Override
    public void update(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void delete(long id) {
        photoRepository.deleteById(id);
    }

    public Photo getPhotoByFileName(String fileName) {
        return photoRepository.getPhotoByFileName(fileName);
    }
}
