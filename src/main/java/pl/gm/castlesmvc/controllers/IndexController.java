package pl.gm.castlesmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.gm.castlesmvc.mapper.CastleMapper;
import pl.gm.castlesmvc.services.CastleService;

@Controller
public class IndexController {

    @Autowired
    private CastleService castleService;

    @GetMapping("/")
    public String allAlbumsOfCastles(Model model) {
        model.addAttribute("castles", CastleMapper.mapCastlesListToDtoListLimit3(castleService.listAll()));
        return "index";
    }


}
