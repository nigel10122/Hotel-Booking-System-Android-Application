package com.example.hotelbooking2;

public class Reservations {
    private String id, hotel, roomtype, numberofrooms, numberofadults,  checkindate, checkoutdate, price,  amenities, hotelmanagercontact, confirmationnumber, lastname, firstname;

    public Reservations() {
    }

    public Reservations(String id, String hotel, String roomtype, String numberofrooms, String numberofadults,  String checkindate, String checkoutdate, String price,  String amenities, String hotelmanagercontact, String confirmationnumber,String lastname, String firstname) {
        this.id = id;
        this.hotel = hotel;
        this.roomtype = roomtype;
        this.numberofrooms = numberofrooms;
        this.numberofadults = numberofadults;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.price = price;
        this.amenities = amenities;
        this.hotelmanagercontact = hotelmanagercontact;
        this.confirmationnumber = confirmationnumber;
        this.lastname = lastname;
        this.firstname = firstname;


        
    }

    public String getRoomId() {
        return id;
    }

    public void setRoomId(String id) {
        this.id = id;
    }

    public String gethotel() {
        return hotel;
    }

    public void sethotel(String hotel) {
        this.hotel = hotel;
    }

    public String getroomtype() {
        return roomtype;
    }

    public void setroomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getnumberofrooms() {
        return numberofrooms;
    }

    public void setnumberofrooms(String numberofrooms) {
        this.numberofrooms = numberofrooms;
    }

    public String getnumberofadults() {
        return numberofadults;
    }

    public void setnumberofadults(String numberofadults) {
        this.numberofadults = numberofadults;
    }




    public String getcheckindate() {
        return checkindate;
    }

    public void setcheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getcheckoutdate() {
        return checkoutdate;
    }

    public void setcheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }
    

    
    public String getamenities() {
        return amenities;
    }

    public void setamenities(String amenities) {
        this.amenities = amenities;
    }

    public String gethotelmanagercontact() {
        return hotelmanagercontact;
    }

    public void sethotelmanagercontact(String hotelmanagercontact) {
        this.hotelmanagercontact = hotelmanagercontact;
    }

    public String getconfirmationnumber() {
        return confirmationnumber;
    }

    public void setconfirmationnumber(String confirmationnumber) {
        this.confirmationnumber = confirmationnumber;
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
    
    

}