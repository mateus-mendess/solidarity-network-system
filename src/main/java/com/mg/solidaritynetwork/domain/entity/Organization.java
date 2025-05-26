package com.mg.solidaritynetwork.domain.entity;

import org.springframework.web.multipart.MultipartFile;

public class Organization extends Author {

    private Long id;
    private String cnpj;
    private String corporateName;
    private String about;
    private MultipartFile profilePicture;
    private MultipartFile coverPhoto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }

    public MultipartFile getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(MultipartFile coverPhoto) {
        this.coverPhoto = coverPhoto;
    }
}
