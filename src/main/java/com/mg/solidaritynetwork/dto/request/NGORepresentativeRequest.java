package com.mg.solidaritynetwork.dto.request;

import com.mg.solidaritynetwork.validation.group.NGORepresentativeValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;

public class NGORepresentativeRequest {

    private Long id;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = NGORepresentativeValidation.class)
    @Pattern(regexp = "\\d{3}.?\\d{3}.?\\d{3}-?\\d{2}", message = "CPF inválido. Verifique se está com 11 dígitos no formato correto.", groups = NGORepresentativeValidation.class)
    private String cpf;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = NGORepresentativeValidation.class)
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Nome inválido. Use apenas letras e espaços.", groups = NGORepresentativeValidation.class)
    private String name;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = NGORepresentativeValidation.class)
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Sobrenome inválido. Use apenas letras e espaços.", groups = NGORepresentativeValidation.class)
    private String lastname;

    @Past(message = "Data de nascimento inválida. Verifique a data.", groups = NGORepresentativeValidation.class)
    private LocalDate birthdate;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = NGORepresentativeValidation.class)
    @Pattern(regexp = "Masculino|Feminino|Não-binário|Bigênero|Transgênero|Outro", message = "Gênero inválido. Escolha uma opção válida.", groups = NGORepresentativeValidation.class)
    private String gender;

    @NotBlank(message = "Campo obrigatório. Este campo não pode ficar em branco.", groups = NGORepresentativeValidation.class)
    @Pattern(regexp = "^\\(?(\\d{2})\\)?\\s?9?\\d{4}-?\\d{4}$", message = "Telefone inválido. Informe um número válido com DDD.", groups = NGORepresentativeValidation.class)
    private String phone;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
