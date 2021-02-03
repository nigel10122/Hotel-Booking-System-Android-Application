
<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['lastname']) and 
		 isset($_POST['firstname']) and 
			isset($_POST['hotel']) and 
				isset($_POST['roomtype']) and 
					isset($_POST['price']) and 
						isset($_POST['amenities']) and 
							isset($_POST['numberofrooms']) and
								isset($_POST['numberofadults']) and
									isset($_POST['checkindate']) and
										isset($_POST['checkoutdate']) and 
											isset($_POST['hotelmanagercontact']) and 
												isset($_POST['confirmationnumber']))
		{
		//operate the data further 

		$db = new DbOperations(); 

		$result = $db->makereservation( $_POST['lastname'],
										$_POST['firstname'],
										$_POST['hotel'],
										$_POST['roomtype'],
										$_POST['price'],
										$_POST['amenities'],
										$_POST['numberofrooms'],
										$_POST['numberofadults'],
										$_POST['checkindate'],
										$_POST['checkoutdate'],
										$_POST['hotelmanagercontact'],
										$_POST['confirmationnumber'],
								);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "Reservation Blocked, Make payment to confirm reservation";
		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "Some error occurred please try again";			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "It seems you have already reserved a room under this hotel, please choose a different hotel and reserve";						
		}

	}else{
		$response['error'] = true; 
		$response['message'] = "Required fields are missing";
	}
}else{
	$response['error'] = true; 
	$response['message'] = "Invalid Request";
}

echo json_encode($response);
