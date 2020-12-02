package Model;

public class Customer {
    private int customerID;
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String birthDay;
    private String phoneNumber;
    private String address;
    private String email;
    private int typeAccountId;

    public Customer() {
    }

    public Customer(String username, String password, String firstname, String surname, String birthDay, String phoneNumber, String address, String email, int typeAccountId) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.typeAccountId = typeAccountId;
    }

    public Customer(int customerID, String username, String password, String firstname, String surname, String birthDay, String phoneNumber, String address, String email, int typeAccountId) {
        this.customerID = customerID;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.typeAccountId = typeAccountId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeAccountId() {
        return typeAccountId;
    }

    public void setTypeAccountId(int typeAccountId) {
        this.typeAccountId = typeAccountId;
    }
}