package com.example.shuhistory.entity;

public class HallOfFameWithBLOBs extends HallOfFame {
    private String title;

    private String picture;

    private String label;

    private String deeds;

    private String deedsPicture;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getDeeds() {
        return deeds;
    }

    public void setDeeds(String deeds) {
        this.deeds = deeds == null ? null : deeds.trim();
    }

    public String getDeedsPicture() {
        return deedsPicture;
    }

    public void setDeedsPicture(String deedsPicture) {
        this.deedsPicture = deedsPicture == null ? null : deedsPicture.trim();
    }
}