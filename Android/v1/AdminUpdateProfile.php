<?php

$connection = mysqli_connect("localhost","root","","android");

$username = $_POST['username'];  
$lastname = $_POST['lastname'];  
$firstname = $_POST['firstname'];  
$email = $_POST['email'];  
$number = $_POST['number'];  
$address = $_POST['address'];  




$result = array();
$result['users'] = array();
$select= "UPDATE users SET email ='$email',lastname = '$lastname',firstname = '$firstname',number = '$number',address = '$address' WHERE username = '$username'";
$response = mysqli_query($connection,$select);

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