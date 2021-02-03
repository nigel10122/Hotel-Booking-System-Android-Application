<?php

$connection = mysqli_connect("localhost","root","","android");

$lastname = $_POST['lastname'];  



$result = array();
$result['users'] = array();
$select= "SELECT * from users where lastname like '%$lastname%' ";
$response = mysqli_query($connection,$select);

while($row = mysqli_fetch_array($response))
	{
		$index['id']	 = $row['0'];
		$index['username']	 = $row['1'];
		$index['email']	 = $row['3'];
		$index['lastname']= $row['4'];
		$index['firstname']= $row['5'];
		$index['number']= $row['6'];
		$index['address']= $row['7'];
		$index['role'] = $row['13'];


		array_push($result['users'], $index);
	}
		$result["success"]="1";
		echo json_encode($result);
		mysqli_close($connection);
?>