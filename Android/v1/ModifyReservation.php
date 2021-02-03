<?php

$connection = mysqli_connect("localhost","root","","android");



$hotel = $_POST['hotel']; 
$roomtype = $_POST['roomtype'];  
$numberofrooms = $_POST['numberofrooms'];  
$numberofadults = $_POST['numberofadults']; 
$checkindate = $_POST['checkindate']; 
$checkoutdate = $_POST['checkoutdate'];
$confirmationnumber = $_POST['confirmationnumber'];
$price = $_POST['price']; 
$amenities = $_POST['amenities']; 
$hotelmanagercontact = $_POST['hotelmanagercontact']; 




$select= "UPDATE reservation set roomtype = '$roomtype' , numberofrooms = '$numberofrooms', numberofadults = '$numberofadults', checkindate = '$checkindate', checkoutdate = '$checkoutdate', price = '$price', amenities = '$amenities', hotelmanagercontact = '$hotelmanagercontact' where confirmationnumber = '$confirmationnumber' and hotel = '$hotel' ";

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