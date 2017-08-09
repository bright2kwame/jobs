package com.jobsapp.app.item;

/**
 * Created by Monarchy on 09/08/2017.
 */

public class Applicant {
    public String id;
    public String name;
    public String speciality;
    public String coverPhoto;
    public String video;
    public String bio;

    public Applicant() {
    }

    public Applicant(String id, String name, String speciality, String coverPhoto, String video, String bio) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.coverPhoto = coverPhoto;
        this.video = video;
        this.bio = bio;
    }
}
