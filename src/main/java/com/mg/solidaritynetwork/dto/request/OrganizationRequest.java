package com.mg.solidaritynetwork.dto.request;

import com.mg.solidaritynetwork.validation.group.OrganizationValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class OrganizationRequest extends AuthorRequest{

    @NotNull(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = OrganizationValidation.class)
    private Long id;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = OrganizationValidation.class)
    @Pattern(regexp = "^(\\d{2}\\.?\\d{3}\\.?\\d{3}/?\\d{4}-?\\d{2})$", message = "CNPJ inválido. Verifique se está no formato correto, com 14 dígitos.", groups = OrganizationValidation.class)
    private String cnpj;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = OrganizationValidation.class)
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Nome da corporação inválido. Utilize apenas letras, números e espaços.", groups = OrganizationValidation.class)
    private String corporateName;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = OrganizationValidation.class)
    @Size(message = " Descrição muito curta. Por favor, forneça mais informações sobre a organização.", min = 20, groups = OrganizationValidation.class)
    private String about;

    @NotNull(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = OrganizationValidation.class)
    private MultipartFile profilePicture;

    @NotNull(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = OrganizationValidation.class)
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
