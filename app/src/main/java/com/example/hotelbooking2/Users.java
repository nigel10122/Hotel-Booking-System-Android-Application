package com.example.hotelbooking2;

public class Users {
    private String id, username, email, lastname, firstname, number, address,role;

    public Users() {
    }

    public Users(String id, String username, String email, String lastname, String firstname, String number, String address,String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.number = number;
        this.address = address;
        this.role = role;



        
    }

    public String getUserID() {
        return id;
    }

    public void setUserID(String id) {
        this.id = id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String hotel) {
        this.username = username;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getnumber() {
        return number;
    }

    public void setnumber(String number) {
        this.number = number;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getrole() {
        return role;
    }

    public void setrole(String role) {
        this.role = role;
    }




    
    

}