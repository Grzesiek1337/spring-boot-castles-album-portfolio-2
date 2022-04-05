package pl.gm.castlesmvc.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gm.castlesmvc.model.Castle;

import java.util.List;

@Service
@Transactional
public interface ICastleService {

    public List<Castle> listAll();

    public void save(Castle castleDTO);

    public Castle get(long id);

    public void update(Castle castleDTO);

    public void delete(long id);
}
