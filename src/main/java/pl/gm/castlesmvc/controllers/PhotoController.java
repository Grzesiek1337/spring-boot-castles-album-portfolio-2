package pl.gm.castlesmvc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.gm.castlesmvc.mapper.CastleMapper;
import pl.gm.castlesmvc.mapper.PhotoMapper;
import pl.gm.castlesmvc.services.PhotoService;

@Controller
@RequestMapping("/photos")
@RequiredArgsConstructor

public class PhotoController {

    private final PhotoService photoService;

    @GetMapping("/list")
    public String allPhotos(Model model) {
        model.addAttribute("photosFileNames", PhotoMapper.mapToListOfPhotosNames(photoService.listAll()));
        return "photos/photo-list";
    }


}
