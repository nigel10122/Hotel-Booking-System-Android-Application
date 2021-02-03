<?php

$connection = mysqli_connect("localhost","root","","android");

$confirmationnumber = $_POST['confirmationnumber'];  


$select= "DELETE from reservation where confirmationnumber = '$confirmationnumber'";
$response = mysqli_query($connection,$select);

if($response)
{
	echo "Deleted Succesfully";

}
else
{
	echo "Delete Failed";
}





?>