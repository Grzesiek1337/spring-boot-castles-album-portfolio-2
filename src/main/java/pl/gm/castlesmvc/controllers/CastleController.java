package pl.gm.castlesmvc.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.castlesmvc.mapper.CastleMapper;
import pl.gm.castlesmvc.model.Castle;
import pl.gm.castlesmvc.model.Photo;
import pl.gm.castlesmvc.services.CastleService;

import javax.validation.Valid;

@Controller
@RequestMapping("/castle")
@RequiredArgsConstructor
public class CastleController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final CastleService castleService;

    @ResponseBody
    @RequestMapping("/testing")
    public String responseTest() {
        return castleService.listAll().toString();
    }

    @GetMapping("/list")
    public String allCastleAlbums(Model model) {
        model.addAttribute("castles", CastleMapper.mapCastlesListToDtoList(castleService.listAll()));
        return "castles/castle-list";
    }

    @GetMapping("/show-details/{id}")
    public String inspectCastle(@PathVariable(name = "id") int id, Model model) {
        model.addAttribute("castleDTO", CastleMapper.mapCastleToDto(castleService.get(id)));
        return "/castles/castle-inspection";
    }

    @GetMapping("/add")
    public String addCastle(Model model) {
        model.addAttribute("castle", new Castle());
        return "/castles/castle-add";
    }

    @PostMapping("/add")
    public String saveCastle(@Valid Castle castle, BindingResult bindingResult, @RequestParam("imageFile") MultipartFile imageFile, Model model) {
        if (bindingResult.hasErrors()) {
            return "/castles/castle-add";
        } else if (imageFile.getOriginalFilename().isEmpty()) {
            model.addAttribute("emptyPhotoMessage", "Main photo is needed.");
            return "/castles/castle-add";
        }
        try {
            castleService.save(castle);
        } catch (Exception e) {
            log.error("unable to save castle", e);
            e.printStackTrace();
            return "error";
        }
        Photo photo = new Photo();
        photo.setFileName(castle.getCastleName() + imageFile.getOriginalFilename());
        photo.setPath("/static/");
        photo.setCastle(castle);
        try {
            castle.setCastleMainPhoto(photo);
            castleService.saveImage(imageFile, photo);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error saving photo", e);
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCastle(@PathVariable(name = "id") int id, Model model) {
        Castle castle = castleService.get(id);
        model.addAttribute("castle", castle);
        return "/castles/castle_edit";
    }

    @PostMapping("/edit")
    public String updateCastle(Castle castle) {
        castleService.update(castle);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String getRemoveFormForAlbum(@PathVariable int id, Model model) {
        model.addAttribute("castleId", id);
        return "/castles/castle-delete";
    }

    @GetMapping("/delete/{id}")
    public String removeAlbum(@PathVariable long id, Model model) throws Exception {
        castleService.removeMainImage(castleService.get(id));
        castleService.delete(id);
        model.addAttribute("castleId", null);
        return "redirect:/";
    }
}
