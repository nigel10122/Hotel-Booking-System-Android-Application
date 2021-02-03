
<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
		isset($_POST['hotel']) and 
			isset($_POST['price']) and 
				isset($_POST['distance']) and
					isset($_POST['amenities']))
		{
		//operate the data further 

		$db = new DbOperations(); 

	    if($db->SearchRoom($_POST['hotel'],
								$_POST['price'],
								$_POST['distance'],
								$_POST['amenities']))
	    {

	    	$room = $db->SearchRoomGuest($_POST['hotel'],
								$_POST['price'],
								$_POST['distance'],
								$_POST['amenities']);

	    	$response['error'] = false; 
	    	$response['id'] = $room['id'];
			$response['hotel'] = $room['hotel'];
			$response['roomtype'] = $room['roomtype'];
			$response['numberofrooms'] = $room['numberofrooms'];
			$response['numberofadults'] = $room['numberofadults'];
			$response['numberofchildren'] = $room['numberofchildren'];
			$response['checkindate'] = $room['checkindate'];
			$response['checkoutdate'] = $room['checkoutdate'];
			$response['price'] = $room['price'];
			$response['distance'] = $room['distance'];
			$response['amenities'] = $room['amenities'];
			$response['hotelmanagercontact'] = $room['hotelmanagercontact'];
			$response['confirmationnumber'] = $room['confirmationnumber'];

		}else{
			$response['error'] = true; 
			$response['message'] = "No such room available";			
		}

	}else{
		$response['error'] = true; 
		$response['message'] = "Required fields are missing";
	}

}


echo json_encode($response);
