<?php

$connection = mysqli_connect("localhost","root","","android");

$lastname = $_POST['lastname'];  



$result = array();
$result['manager'] = array();
$select= "SELECT * from manager where lastname like '%$lastname%' ";
$response = mysqli_query($connection,$select);

while($row = mysqli_fetch_array($response))
	{
		$index['id']	 = $row['0'];
		$index['username']	 = $row['1'];
		$index['email']	 = $row['2'];
		$index['lastname']= $row['4'];
		$index['firstname']= $row['5'];
		$index['number']= $row['6'];
		$index['address']= $row['7'];
		$index['role'] = $row['8'];


		array_push($result['manager'], $index);
	}
		$result["success"]="1";
		echo json_encode($result);
		mysqli_close($connection);
?>