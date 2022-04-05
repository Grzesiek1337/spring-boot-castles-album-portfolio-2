package pl.gm.castlesmvc.dto;

import pl.gm.castlesmvc.model.Castle;

public record PhotoDTO(Long photoId, String path, String fileName, Castle castle) {
}
