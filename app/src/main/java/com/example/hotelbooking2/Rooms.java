package com.example.hotelbooking2;

public class Rooms {
    private String id, hotel, roomtype, numberofrooms, numberofadults, numberofchildren, checkindate, checkoutdate, price, distance, amenities, hotelmanagercontact, confirmationnumber,totalnumberofrooms,availablerooms,unavailablerooms,availability,weekendprice,roomnumber;

    public Rooms() {
    }

    public  Rooms(String id, String hotel, String roomtype, String numberofrooms, String numberofadults, String numberofchildren, String checkindate, String checkoutdate, String price, String distance, String amenities, String hotelmanagercontact, String confirmationnumber, String totalnumberofrooms, String availablerooms, String unavailablerooms, String availability, String weekendprice, String roomnumber) {
        this.id = id;
        this.hotel = hotel;
        this.roomtype = roomtype;
        this.numberofrooms = numberofrooms;
        this.numberofadults = numberofadults;
        this.numberofchildren = numberofchildren;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.price = price;
        this.distance = distance;
        this.amenities = amenities;
        this.confirmationnumber = confirmationnumber;
        this.hotelmanagercontact = hotelmanagercontact;
        this.totalnumberofrooms = totalnumberofrooms;
        this.availablerooms = availablerooms;
        this.unavailablerooms = unavailablerooms;
        this.availability = availability;
        this.weekendprice = weekendprice;
        this.roomnumber = roomnumber;
    



        
    }

    public String getRoomId() {
        return id;
    }

    public void setRoomid(String id) {
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

    public String getnumberofchildren() {
        return numberofchildren;
    }

    public void setnumberofchildren(String numberofchildren) {
        this.numberofchildren = numberofchildren;
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
    
    public String getdistance() {
        return distance;
    }

    public void setdistance(String distance) {
        this.distance = distance;
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

    public String gettotalnumberofrooms() {
        return totalnumberofrooms;
    }

    public void settotalnumberofrooms(String totalnumberofrooms) {
        this.totalnumberofrooms = totalnumberofrooms;
    }

    public String getavailablerooms() {
        return availablerooms;
    }

    public void setavailablerooms(String availablerooms) {
        this.availablerooms = availablerooms;
    }

    public String getunavailablerooms() {
        return unavailablerooms;
    }

    public void setunavailablerooms(String unavailablerooms) {
        this.unavailablerooms = unavailablerooms;
    }

    public String getavailability() {
        return availability;
    }

    public void setavailability(String availability) {
        this.availability = availability;
    }

    public String getweekendprice() {
        return weekendprice;
    }

    public void setweekendprice(String weekendprice) {
        this.weekendprice = weekendprice;
    }

    public String getconfirmationnumber() {
        return confirmationnumber;
    }

    public void setconfirmationnumber(String confirmationnumber) {
        this.confirmationnumber = confirmationnumber;
    }

    public String getroomnumber() {
        return roomnumber;
    }

    public void setroomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }
    

}