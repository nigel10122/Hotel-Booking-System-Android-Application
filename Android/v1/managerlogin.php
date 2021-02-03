<?php 

require_once '../includes/DbOperationsManager.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(isset($_POST['username']) and isset($_POST['password'])){
		$db = new DbOperationsManager(); 

		if($db->userLogin($_POST['username'], $_POST['password'])){
			$user = $db->getUserByUsername($_POST['username']);
			$response['error'] = false; 
			$response['id'] = $user['id'];
			$response['email'] = $user['email'];
			$response['username'] = $user['username'];
			$response['lastname'] = $user['lastname'];
			$response['firstname'] = $user['firstname'];
			$response['number'] = $user['number'];
			$response['address'] = $user['address'];
		}else{
			$response['error'] = true; 
			$response['message'] = "Invalid username or password";			
		}

	}else{
		$response['error'] = true; 
		$response['message'] = "Required fields are missing";
	}
}

echo json_encode($response);