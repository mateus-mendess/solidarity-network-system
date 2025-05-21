package com.mg.solidaritynetwork.dto.request;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public class VolunteerRequest extends AuthorRequest {
    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "\\d{3}.?\\d{3}.?\\d{3}-?\\d{2}", message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Sobrenome inválido")
    private String lastName;

    @Past(message = "Data informada precisa está no passado")
    private LocalDate birthDate;

    @NotBlank
    @Pattern(regexp = "Masculino|Feminino|Não-binário|Bigênero|Transgênero|Outro", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Gênero inválido")
    private String gender;

    private MultipartFile profilePicture;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Profissão inválida")
    private String profession;

    @NotNull(message = "Campo Obrigátorio!")
    private String permission;

    @NotEmpty(message = "Deve ser escolhido no mínimo um tipo de ação")
    private List<Long> idActionTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public MultipartFile getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(MultipartFile profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Long> getIdActionTypes() {
        return idActionTypes;
    }

    public void setIdActionTypes(List<Long> idActionTypes) {
        this.idActionTypes = idActionTypes;
    }
}