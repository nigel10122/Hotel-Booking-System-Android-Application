
<?php 

require_once '../includes/DbOperations.php';

$response = array(); 

if($_SERVER['REQUEST_METHOD']=='POST'){
	if(
		isset($_POST['username']) and 
			isset($_POST['email']) and 
				isset($_POST['password']) and
					isset($_POST['lastname']) and
						isset($_POST['firstname']) and
							isset($_POST['number']) and 
								isset($_POST['address']) and
									isset($_POST['creditcardtype']) and
										isset($_POST['creditcardnumber']) and
											isset($_POST['nameoncard']) and
												isset($_POST['expirydate']) and
													isset($_POST['billingaddress']))
		{
		//operate the data further 

		$db = new DbOperations(); 

		$result = $db->createUser( 	$_POST['username'],
									$_POST['password'],
									$_POST['email'],
									$_POST['lastname'],
									$_POST['firstname'],
									$_POST['number'],
									$_POST['address'],
									$_POST['creditcardtype'],
									$_POST['creditcardnumber'],
									$_POST['nameoncard'],
									$_POST['expirydate'],
									$_POST['billingaddress']

								);
		if($result == 1){
			$response['error'] = false; 
			$response['message'] = "User registered successfully";
		}elseif($result == 2){
			$response['error'] = true; 
			$response['message'] = "Some error occurred please try again";			
		}elseif($result == 0){
			$response['error'] = true; 
			$response['message'] = "It seems you are already registered, please choose a different email and username";						
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
