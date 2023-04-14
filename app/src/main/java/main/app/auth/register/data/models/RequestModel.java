package main.app.auth.register.data.models;

public class RequestModel {
    public String firstName;
    public String lastName;
    public String username;
    public String email;
    public String password;
    public String confirmPassword;

    public RequestModel(String firstName, String lastName, String username, String email, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getConfirmPassword() {
        return this.confirmPassword;
    }
}