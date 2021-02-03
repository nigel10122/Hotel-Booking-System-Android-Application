
<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
		isset($_POST['username']))
		{
		//operate the data further 

		$db = new DbOperations(); 

		$result = $db->updateUser( 	$_POST['username'],
									$_POST['email'],
									$_POST['lastname'],
									$_POST['firstname'],
									$_POST['number'],
									$_POST['address'],
									$_POST['creditcardtype'],
									$_POST['creditcardnumber'],
									$_POST['nameoncard'],
									$_POST['expirydate'],
									$_POST['billingaddress'],

								);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "User updated successfully";
		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "Some error occurred please try again";			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "It seems you are already updated, please choose a different email and username";						
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
