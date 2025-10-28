package com.hello_user.hello_user;

public class Members {
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private String BirthDate;
    private String Role;
    private String MemberID;
    public Members(String firstName, String lastName, String email, String phoneNumber, String birthDate, String role, String memberID) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
        BirthDate = birthDate;
        Role = role;
        MemberID = memberID;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public String getBirthDate() {
        return BirthDate;
    }
    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }
    public String getRole() {
        return Role;
    }
    public void setRole(String role) {
        Role = role;
    }
    public String getMemberID() {
        return MemberID;
    }
    public void setMemberID(String memberID) {
        MemberID = memberID;
    }
    
}
