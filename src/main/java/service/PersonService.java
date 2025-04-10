package service;

import dto.PersonDTO;

public class PersonService {
    public static void cpfValidate(String cpf) throws Exception {
        if (!cpf.matches("^\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}-\\\\d{2}$|^\\\\d{11}$\n")) {
            throw new Exception();
        }
    }
    public static void nameValidate(String name) throws Exception{
        if (!name.matches("^[A-Za-zÀ-ÿ]+(\\\\s[A-Za-zÀ-ÿ]+)*$")) {
            throw new Exception();
        }
    }

    public static void surnameValidate(String surname) throws Exception {
        if (!surname.matches("^[A-Za-zÀ-ÿ]+(\\\\s[A-Za-zÀ-ÿ]+)*$")) {
            throw new Exception();
        }
    }
    public static void ageValidate(String age) throws Exception {
        if (!age.matches("^(?:1[01][0-9]|120|\\\\d{1,2})$\n")) {
            throw new Exception();
        }
    }

    public static void emailValidate(String email) throws Exception {
        if (!email.matches("^[\\\\w.-]+@[\\\\w.-]+\\\\.\\\\w{2,}$\n")) {
            throw new Exception();
        }
    }

    public static void phoneValidate(String phone) throws Exception {
        if (!phone.matches("^\\(?(\\d{2})\\)?\\s?9?\\d{4}-?\\d{4}$")) {
            throw new Exception();
        }
    }

    public static void ganderValidate(String gander) throws Exception {
        if (!gander.matches("(?i)^(Masculino|Feminino|Outro)$")) {
            throw new Exception();
        }
    }
}
