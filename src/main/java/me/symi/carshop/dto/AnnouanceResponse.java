package me.symi.carshop.dto;

public class AnnouanceResponse {

    private String annouanceLink;

    public AnnouanceResponse(String annouanceLink) {
        this.annouanceLink = annouanceLink;
    }

    public String getAnnouanceLink() {
        return annouanceLink;
    }

    public void setAnnouanceLink(String annouanceLink) {
        this.annouanceLink = annouanceLink;
    }
}
