package at.htl.restaurant.model;

public class PersonDTO {
    private String ssn;
    private String phone;
    private String email;

    public PersonDTO() {
    }

    public PersonDTO(String ssn, String phone, String email) {
        this.ssn = ssn;
        this.phone = phone;
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}