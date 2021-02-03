<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['username']) and isset($_POST['email'])){
		$db = new DbOperations(); 

		if($db->getuserprofile($_POST['username'], $_POST['email'])){
			$user = $db->getUserByUsername($_POST['username']);
			$response['error'] = false; 
			$response['id'] = $user['id'];
			$response['email'] = $user['email'];
			$response['username'] = $user['username'];
			$response['lastname'] = $user['lastname'];
			$response['firstname'] = $user['firstname'];
			$response['number'] = $user['number'];
			$response['address'] = $user['address'];
			$response['creditcardtype'] = $user['creditcardtype'];
			$response['creditcardnumber'] = $user['creditcardnumber'];
			$response['nameoncard'] = $user['nameoncard'];
			$response['expirydate'] = $user['expirydate'];
			$response['billingaddress'] = $user['billingaddress'];
			$response['role'] = $user['role'];
		}else{
			$response['error'] = true; 
			$response['message'] = "Invalid username or email";			
		}

	}else{
		$response['error'] = true; 
		$response['message'] = "Required fields are missing";
	}
}

echo json_encode($response);