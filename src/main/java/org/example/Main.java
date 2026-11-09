package org.example;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String cep = "60130-000";
        cep = "A98855899578A";

        // Remove tudo o que não for número (substitui o hífen por vazio)
        String cepLimpo = cep.replaceAll("[^0-9]", "");

        // Valida se o texto limpo tem exatamente 8 dígitos numéricos
        if (cepLimpo.matches("\\d{8}")) {
            System.out.println("O CEP " + cepLimpo + " é válido");
        } else {
            System.out.println("O CEP " + cepLimpo + " NÃO é válido");
        }

        String email = "email@email.com.br";
        boolean emailVerificado = Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email);

        System.out.println(emailVerificado);
    }
}