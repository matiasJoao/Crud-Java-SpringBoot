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

}
