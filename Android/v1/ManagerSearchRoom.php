<?php

$connection = mysqli_connect("localhost","root","","android");

$hotel = $_POST['hotel'];
$roomtype = $_POST['roomtype'];  
$checkindate = $_POST['checkindate']; 
$checkoutdate = $_POST['checkoutdate'];



$result = array();
$result['rooms'] = array();
$select= "SELECT * from rooms where hotel like '%$hotel%' and roomtype like '%$roomtype%' and checkindate = '$checkindate'and checkoutdate = '$checkoutdate' ";
$response = mysqli_query($connection,$select);

while($row = mysqli_fetch_array($response))
	{
		$index['id']	 = $row['0'];
		$index['hotel']	 = $row['1'];
		$index['roomtype']	 = $row['2'];
		$index['numberofrooms']= $row['3'];
		$index['numberofadults']= $row['4'];
		$index['numberofchildren']= $row['5'];
		$index['checkindate']= $row['6'];
		$index['checkoutdate']= $row['7'];
		$index['price']= $row['8'];
		$index['distance']= $row['9'];
		$index['amenities']= $row['10'];
		$index['hotelmanagercontact']= $row['11'];
		$index['confirmationnumber']= $row['12'];
		$index['totalnumberofrooms']= $row['13'];
		$index['availablerooms']= $row['14'];
		$index['unavailablerooms']= $row['15'];
		$index['availability']= $row['16'];
		$index['weekendprice']= $row['17'];
		$index['roomnumber']= $row['18'];

		array_push($result['rooms'], $index);
	}
		$result["success"]="1";
		echo json_encode($result);
		mysqli_close($connection);
?>
