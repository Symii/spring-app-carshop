package me.symi.carshop.controller;

import me.symi.carshop.entity.ImageEntity;
import me.symi.carshop.repository.ImageRepository;
import me.symi.carshop.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private AppService appService;

    @GetMapping("/images")
    public String showImages(Model model) {
        List<ImageEntity> images = appService.findAllImages();
        model.addAttribute("images", images);
        return "image-upload";
    }

    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable("id") int id) {
        return appService.findImageById(id).getImageData();
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile file) {

        try {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setCar(appService.findCarById(1));
            imageEntity.setImageData(file.getBytes());
            System.out.println("Saving image to the database...");
            appService.saveImage(imageEntity);
            System.out.println("Done.");
            return "redirect:/images";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/images";
        }
    }

}
