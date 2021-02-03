<?php

$connection = mysqli_connect("localhost","root","","android");



$hotel = $_POST['hotel']; 
$roomtype = $_POST['roomtype'];  
$checkindate = $_POST['checkindate']; 
$checkoutdate = $_POST['checkoutdate'];
$price = $_POST['price']; 
$amenities = $_POST['amenities']; 
$totalnumberofrooms = $_POST['totalnumberofrooms']; 
$hotelmanagercontact = $_POST['hotelmanagercontact'];
$availablerooms = $_POST['availablerooms'];
$unavailablerooms = $_POST['unavailablerooms'];
$availability = $_POST['availability'];
$weekendprice = $_POST['weekendprice'];
$roomnumber = $_POST['roomnumber'];




$select= "UPDATE rooms set price = '$price', amenities = '$amenities' , roomtype = '$roomtype', hotelmanagercontact = '$hotelmanagercontact', totalnumberofrooms = '$totalnumberofrooms', availablerooms = '$availablerooms', unavailablerooms = '$unavailablerooms', availability = '$availability', weekendprice = '$weekendprice' where roomnumber = '$roomnumber' and hotel = '$hotel'";

$response = mysqli_query($connection,$select);

if($response)
{
	echo "Data Updated Succesfully";
}
else
{
	echo "Failed";
}
?>