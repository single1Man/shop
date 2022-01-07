package com.utils;

import com.pojo.User;

import java.util.regex.Pattern;

public class checkUserUtils {
    public Boolean checkUser(User user,String confirmPassword){
        boolean flag;
        String username=user.getUsername();
        String password=user.getPassword();
        String name=user.getName();
        String email=user.getEmail();
        String telephone=user.getTelephone();
        String usernameReg="^[a-zA-Z_]{6,18}$";
        String passwordReg="^(?=.*\\d)(?=.*[a-zA-Z])[\\da-zA-Z]{6,}$";
        String nameReg="^[\\u4E00-\\u9FA5A-Za-z\\s]+(·[\\u4E00-\\u9FA5A-Za-z]+)*$";
        String emailReg="[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\\.[a-zA-Z0-9]{1,5}";
        String telephoneReg="^1\\d{10}$";
        flag= Pattern.matches(usernameReg, username) && Pattern.matches(passwordReg, password) && Pattern.matches(nameReg, name)
              && Pattern.matches(emailReg, email) && Pattern.matches(telephoneReg, telephone) && password.equals(confirmPassword);
        return flag;
    }
}
