package com.mg.solidaritynetwork.dto.request;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public class VolunteerRequest {
    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Nome inválido")
    private String name;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^\\(?(\\d{2})\\)?\\s?9?\\d{4}-?\\d{4}$", message = "Telefone inválido")
    private String phone;

    @NotBlank(message = "Campo Obrigatório")
    @Email(regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido")
    private String email;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "")
    private String password;

    @NotBlank(message = "Campo Obrigatório")
    private String confirmPassword;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "\\d{3}.?\\d{3}.?\\d{3}-?\\d{2}", message = "CPF inválido")
    private String cpf;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Sobrenome inválido")
    private String lastName;

    @NotBlank(message = "Campo Obrigatório")
    @Past(message = "Data informada precisa está no passado")
    private LocalDate birthDate;

    @NotNull
    private String gender;

    @Pattern(regexp = "^(?!.*(\\.\\.|//|\\|:))[a-zA-Z0-9/_-]+\\.(jpg|jpeg|png)$", message = "Caminho Inválido")
    private String profilePicture;

    @NotBlank(message = "Campo Obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Profissão inválida")
    private String profession;

    @NotNull
    private String permission;

    @NotEmpty(message = "Deve ser escolhido no mínimo um tipo de ação")
    private List<Long> idActionTypes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
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
