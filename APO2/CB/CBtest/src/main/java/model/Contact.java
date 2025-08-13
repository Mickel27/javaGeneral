package model;

public class Contact {

    String name;
    String email;
    String phone;

    public Contact(String name, String email, String phone) {
        /*
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            throw new IllegalArgumentException();
        }
         */
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
