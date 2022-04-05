package pl.gm.castlesmvc.dto;

import pl.gm.castlesmvc.model.Photo;

import java.util.List;

public record CastleDTO(Long id, String castleName,Photo castleMainPhoto, String castleDescription, int castleYearOfBuild, String castleLocation,
                        List<Photo> photos) {
}
