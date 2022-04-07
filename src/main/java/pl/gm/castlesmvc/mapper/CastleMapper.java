package pl.gm.castlesmvc.mapper;

import pl.gm.castlesmvc.dto.CastleDTO;
import pl.gm.castlesmvc.model.Castle;

import java.util.List;
import java.util.stream.Collectors;

public class CastleMapper {

    public static CastleDTO mapCastleToDto(Castle castle) {
        return new CastleDTO(castle.getId(),
                castle.getCastleName(),
                castle.getCastleMainPhoto(),
                castle.getCastleDescription(),
                castle.getCastleYearOfBuild(),
                castle.getCastleLocation(),
                castle.getPhotos());
    }

    public static Castle mapDtoToCastle(CastleDTO castleDTO) {
        Castle castle = new Castle();
        castle.setCastleName(castleDTO.castleName());
        castle.setCastleDescription(castleDTO.castleDescription());
        castle.setCastleYearOfBuild(castleDTO.castleYearOfBuild());
        return castle;
    }

    public static List<CastleDTO> mapCastlesListToDtoList(List<Castle> castles) {
        return castles.stream()
                .map(castle -> new CastleDTO(castle.getId(),
                        castle.getCastleName(),
                        castle.getCastleMainPhoto(),
                        castle.getCastleDescription(),
                        castle.getCastleYearOfBuild(),
                        castle.getCastleLocation(),
                        castle.getPhotos()))
                .collect(Collectors.toList());
    }

    public static List<CastleDTO> mapCastlesListToDtoListLimit3(List<Castle> castles) {
        return castles.stream()
                .map(castle -> new CastleDTO(castle.getId(),
                        castle.getCastleName(),
                        castle.getCastleMainPhoto(),
                        castle.getCastleDescription(),
                        castle.getCastleYearOfBuild(),
                        castle.getCastleLocation(),
                        castle.getPhotos()))
                .limit(3)
                .collect(Collectors.toList());
    }

}
