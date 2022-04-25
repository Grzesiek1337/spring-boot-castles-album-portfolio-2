package pl.gm.castlesmvc.mapper;

import pl.gm.castlesmvc.dto.PhotoDTO;
import pl.gm.castlesmvc.model.Photo;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoMapper {

    public static PhotoDTO mapPhotoToDto(Photo photo) {
        return new PhotoDTO(photo.getPhotoId(),
                photo.getPath(),
                photo.getFileName(),
                photo.getCastle());
    }

    public static List<String> mapToListOfPhotosNames(List<Photo> photos) {
        return photos.stream()
                .map(photo -> photo.getFileName())
                .collect(Collectors.toList());
    }
}
