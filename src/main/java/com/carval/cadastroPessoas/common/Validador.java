package com.carval.cadastroPessoas.common;

import java.util.regex.*;

public class Validador {


    public static boolean ValidaEmail(String email) {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
