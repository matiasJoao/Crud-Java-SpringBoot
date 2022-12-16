package com.Crud.demo.helpers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexHelper {

    public Boolean email(String email){
        Pattern pattern = Pattern.compile( "^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);
        boolean verify;
        if(matcher.matches()){
            verify = true;
        }
        else{
          verify = false;
        }
        return verify;

    }
    public Boolean cpfValidation(String cpf){
        Pattern pattern = Pattern.compile("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)");
        Matcher matcher = pattern.matcher(cpf);
        Boolean verify;
        if(matcher.matches()){
            verify = true;
        }
        else{
            verify = false;
        }
        return verify;
    }

    public Boolean nomeValidation(String name){
        Pattern pattern = Pattern.compile("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$");
        Matcher matcher = pattern.matcher(name);
        Boolean verify;
        if(matcher.matches()){
            verify = true;
        }
        else{
            verify = false;
        }
        return verify;
    }

}
