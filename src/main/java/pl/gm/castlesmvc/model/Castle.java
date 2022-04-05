package pl.gm.castlesmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="castles")
public class Castle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String castleName;

    @OneToOne
    private Photo castleMainPhoto;

    @Size(max = 1000)
    private String castleDescription;
    private int castleYearOfBuild;
    private String castleLocation;

    @OneToMany(mappedBy="castle")
    private List<Photo> photos;

    public Castle(String castleName, String castleDescription, int castleYearOfBuild, String castleLocation) {
        this.castleName = castleName;
        this.castleDescription = castleDescription;
        this.castleYearOfBuild = castleYearOfBuild;
        this.castleLocation = castleLocation;
    }
}
