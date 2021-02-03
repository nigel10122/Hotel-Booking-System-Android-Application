<?php

$connection = mysqli_connect("localhost","root","","android");




$result = array();
$result['reservation'] = array();
$select= "SELECT * from reservation";
$response = mysqli_query($connection,$select);

while($row = mysqli_fetch_array($response))
	{
		$index['id']	 = $row['0'];
		$index['hotel']	 = $row['1'];
		$index['roomtype']	 = $row['2'];
		$index['numberofrooms']= $row['3'];
		$index['numberofadults']= $row['4'];
		$index['checkindate']= $row['5'];
		$index['checkoutdate']= $row['6'];
		$index['price']= $row['7'];
		$index['amenities']= $row['8'];
		$index['hotelmanagercontact']= $row['9'];
		$index['confirmationnumber']= $row['10'];
		$index['lastname']= $row['11'];
		$index['firstname']= $row['12'];

		array_push($result['reservation'], $index);
	}
		$result["success"]="1";
		echo json_encode($result);
		mysqli_close($connection);
?>
