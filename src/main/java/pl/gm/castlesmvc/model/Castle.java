package pl.gm.castlesmvc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Column(unique = true)
    @NotEmpty(message = "Castle name should not be empty.")
    @Size(min = 3,max=20, message = "Castle name length is not enough.")
    private String castleName;

    @OneToOne
    private Photo castleMainPhoto;

    @NotEmpty(message = "Castle description should not be empty.")
    @Size(min = 15,max=255,message = "Castle description length is not enough.")
    private String castleDescription;


    @Min(message = "Castle year of build must be greater than or equal to -2000", value = -2000)
    @Max(message = "Castle year of build must be less than or equal to 2029", value = 2029)
    private int castleYearOfBuild;

    @NotEmpty(message = "Castle location should not be empty.")
    @Size(min = 3,max=20,message = "Castle location length is not enough.")
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