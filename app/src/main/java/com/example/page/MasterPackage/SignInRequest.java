package com.example.page.MasterPackage;

public class SignInRequest {

    String email;
    String password;
    boolean isWebLogin;

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

    public boolean isWebLogin() {
        return isWebLogin;
    }

    public void setWebLogin(boolean webLogin) {
        isWebLogin = webLogin;
    }


    public SignInRequest(String email, String password, boolean isWebLogin) {
        this.email = email;
        this.password = password;
        this.isWebLogin = isWebLogin;
    }
}
