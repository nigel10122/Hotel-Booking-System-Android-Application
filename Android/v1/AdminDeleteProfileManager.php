<?php

$connection = mysqli_connect("localhost","root","","android");

$username = $_POST['username'];  



$result = array();
$result['manager'] = array();
$select= "DELETE FROM manager WHERE username = '$username'";
$response = mysqli_query($connection,$select);

$response = mysqli_query($connection,$select);

if($response)
{
	echo "Data Deleted Succesfully";
}
else
{
	echo "Failed";
}

?>