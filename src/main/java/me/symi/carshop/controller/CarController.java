package me.symi.carshop.controller;

import me.symi.carshop.entity.Car;
import me.symi.carshop.entity.Customer;
import me.symi.carshop.entity.ImageEntity;
import me.symi.carshop.service.AppService;
import me.symi.carshop.utils.TwoWayEncryption;
import me.symi.carshop.utils.UrlGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private AppService appService;

    /*@GetMapping("/car/{carId}")
    public String showImages(Model model, @PathVariable("carId") int carId) {
        Car theCar = appService.findCarById(carId);
       // List<ImageEntity> images = appService.findAllImagesByCar(carList.getFirst());
       // model.addAttribute("images", images);

        model.addAttribute("theCar", theCar);
        return "car-details";
    }*/

    @GetMapping("/")
    public String showImages(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        List<Car> randomCars = appService.getTwentyRandomCars();
        for(int i = 1; i <= 12; i++) {
            Car tempCar = randomCars.get(i - 1);
            model.addAttribute("car" + i, tempCar);
            model.addAttribute("carUrl" + i, UrlGenerator.getCarUrl(tempCar));
        }
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(userDetails != null) {
            String email = authentication.getName();
            Customer customer = appService.findCustomerByEmail(email);
            model.addAttribute("email", customer.getEmail());
        }*/

        return "car-list";
    }

    @GetMapping("/osobowe/nowe-ogloszenie")
    public String showNewCarForm() {
        return "car-form";
    }


    @GetMapping("/osobowe/oferta/{marka}-{carModel}-{rok}-{mocKM}-{idHash}.html")
    public String getCarOffer(
            Model model,
            @PathVariable String marka,
            @PathVariable String carModel,
            @PathVariable int rok,
            @PathVariable int mocKM,
            @PathVariable String idHash
    ) {
        Car theCar = null;
        try {
            theCar = appService.findCarById(TwoWayEncryption.decrypt(idHash));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("theCar", theCar);
        return "car-details";
    }

    /*@GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
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
            return "redirect:/cars";
        }
    }

     */


    @GetMapping("/uploadImage")
    public String uploadImage() {
        return "image-upload-form";
    }


}
