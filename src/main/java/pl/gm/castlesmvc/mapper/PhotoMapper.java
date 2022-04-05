package pl.gm.castlesmvc.mapper;

import pl.gm.castlesmvc.dto.PhotoDTO;
import pl.gm.castlesmvc.model.Photo;

public class PhotoMapper {

    public static PhotoDTO mapPhotoToDto(Photo photo) {
        return new PhotoDTO(photo.getPhotoId(),
                photo.getPath(),
                photo.getFileName(),
                photo.getCastle());
    }
}
