package com.company.stockclock;

public class ModelClass {

    private String imageName;
    private String categoryName;
    private String prevClose;

    public ModelClass(String imageName, String categoryName, String prevClose) {
        this.imageName = imageName;
        this.categoryName = categoryName;
        this.prevClose = prevClose;
    }

    public String getImageName() {
        return imageName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getPrevClose(){ return prevClose;}
}
