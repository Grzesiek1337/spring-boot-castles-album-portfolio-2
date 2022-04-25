package pl.gm.castlesmvc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gm.castlesmvc.model.Castle;

import java.util.List;

@Service
@Transactional
public interface ICastleService {

    List<Castle> listAll();

    void save(Castle castleDTO);

    Castle get(long id);

    void update(Castle castleDTO);

    void delete(long id);
}
