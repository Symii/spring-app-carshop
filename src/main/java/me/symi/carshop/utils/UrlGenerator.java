package me.symi.carshop.utils;

import me.symi.carshop.entity.Car;


public class UrlGenerator {

    public static String getCarUrl(Car theCar) {
        String brand = theCar.getBrand();
        String model = theCar.getModel();
        int yearProduced = theCar.getYearProduced();
        int horsePower = theCar.getCarEngine().getHorsePower();
        String idHash = null;
        try {
            idHash = TwoWayEncryption.encrypt(String.valueOf(theCar.getId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        model = model.replaceAll(" ", "%20");
        String url = "/osobowe/oferta/" + brand + "-" + model + "-" + yearProduced + "-" + horsePower + "-" + idHash + ".html";
        return  url;
    }
}
