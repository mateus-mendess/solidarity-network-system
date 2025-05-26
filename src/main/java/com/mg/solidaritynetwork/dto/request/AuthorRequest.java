package com.mg.solidaritynetwork.dto.request;

import com.mg.solidaritynetwork.validation.constraints.PasswordMatches;
import com.mg.solidaritynetwork.validation.group.AuthorValidation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@PasswordMatches(message = "Confirmação de senha precisa está igual a senha digitada anteriormente.", groups = AuthorValidation.class)
public class AuthorRequest {
    @NotBlank(message = "Campo Obrigatório", groups = AuthorValidation.class)
    @Pattern(regexp = "^[A-Za-zÀ-ÿ]+(\\s[A-Za-zÀ-ÿ]+)*$", message = "Nome inválido. Use apenas letras e espaços.", groups = AuthorValidation.class)
    private String name;

    @NotBlank(message = "Campo Obrigatório", groups = AuthorValidation.class)
    @Pattern(regexp = "^\\(?(\\d{2})\\)?\\s?9?\\d{4}-?\\d{4}$", message = "Telefone inválido. Informe um número válido com DDD.", groups = AuthorValidation.class)
    private String phone;

    @NotBlank(message = "Campo Obrigatório", groups = AuthorValidation.class)
    @Email(regexp = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", message = "Email inválido", groups = AuthorValidation.class)
    private String email;

    @NotBlank(message = "Campo Obrigatório", groups = AuthorValidation.class)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Senha inválida", groups = AuthorValidation.class)
    private String password;

    @NotBlank(message = "Campo Obrigatório", groups = AuthorValidation.class)
    private String confirmPassword;

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
}
