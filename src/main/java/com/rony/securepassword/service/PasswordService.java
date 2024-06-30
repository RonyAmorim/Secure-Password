package com.rony.securepassword.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    public List<String> validatePassword(String password) {
        List<String> failures = new ArrayList<>();

        validateLenght(password, failures);
        validateUppercase(password, failures);
        validateLowercase(password, failures);
        validateNumbers(password, failures);
        validateSpecialCharacters(password, failures);

        return failures;
    }

    private void validateLenght(String password, List<String> failures) {
        if(password != null && password.length() < 8) {
            failures.add("A senha deve possuir no mínimo 08 caracteres.");
        }
    }

    private void validateUppercase(String password, List<String> failures) {
        if(!password.matches(".*[A-Z].*")) {
            failures.add("A senha deve possuir ao menos uma letra maiúscula.");
        }
    }

    private void validateLowercase(String password, List<String> failures) {
        if(!password.matches(".*[a-z].*")) {
            failures.add("A senha deve possuir ao menos uma letra minúscula.");
        }
    }

    private void validateNumbers(String password, List<String> failures) {
        if(!password.matches(".*[0-9].*")) {
            failures.add("A senha deve possuir ao menos um número.");
        }
    }

    private void validateSpecialCharacters(String password, List<String> failures) {
        if(!password.matches(".*[\\W].*")) {
            failures.add("A senha deve possuir ao menos um caractere especial (e.g, !@#$%).");
        }
    }
}
