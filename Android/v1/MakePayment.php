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




$select= "INSERT INTO reservation (column1,column2,column3)
				SELECT column1, column2, column3 FROM  table_name
				WHERE column1 = 'some_value' ";

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