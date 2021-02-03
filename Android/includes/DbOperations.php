<?php 

	class DbOperations{

		private $con; 

		function __construct(){

			require_once dirname(__FILE__).'/DbConnect.php';

			$db = new DbConnect();

			$this->con = $db->connect();

		}

		/*CRUD -> C -> CREATE */

		public function createUser($username, $pass, $email, $lastname, $firstname,$number,$address,$creditcardtype,$creditcardnumber,$nameoncard,$expirydate,$billingaddress){
			if($this->isUserExist($username,$email)){
				return 0; 
			}else{
				$password = md5($pass);
				$stmt = $this->con->prepare("INSERT INTO `users` (`id`, `username`, `password`, `email`, `lastname`, `firstname`, `number`, `address`,`creditcardtype`,`creditcardnumber`,`nameoncard`,`expirydate`,`billingaddress`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
				$stmt->bind_param("ssssssssssss", $username, $password, $email, $lastname, $firstname,$number,$address,$creditcardtype,$creditcardnumber,$nameoncard,$expirydate,$billingaddress);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}

		public function makereservation($lastname,$firstname,$hotel, $roomtype,$price,$amenities, $numberofrooms, $numberofadults, $checkindate,$checkoutdate,$hotelmanagercontact,$confirmationnumber){
			if($this->isReservationExist($confirmationnumber)){
				return 0; 
			}else{
				$stmt = $this->con->prepare("INSERT INTO `reservation` (`id`,`lastname`,`firstname`, `hotel`, `roomtype`,`price`,`amenities`, `numberofrooms`, `numberofadults`, `checkindate`, `checkoutdate`,`hotelmanagercontact`,`confirmationnumber`) VALUES (NULL,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
				$stmt->bind_param("ssssssssssss", $lastname,$firstname,$hotel, $roomtype, $price,$amenities, $numberofrooms, $numberofadults,$checkindate,$checkoutdate,$hotelmanagercontact,$confirmationnumber);

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}
			}
		}


		public function updateUser($username,  $email, $lastname, $firstname,$number,$address,$creditcardtype,$creditcardnumber,$nameoncard,$expirydate,$billingaddress)
		{
			$stmt = $this->con->prepare("UPDATE users SET email='$email', lastname='$lastname', firstname='$firstname', number='$number',address='$address',creditcardtype = '$creditcardtype', creditcardnumber = '$creditcardnumber', nameoncard = '$nameoncard', expirydate = '$expirydate', billingaddress = '$billingaddress' WHERE username ='$username'");


				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}

		}

		public function deleteUser($username)
		{
			$stmt = $this->con->prepare("DELETE FROM users WHERE username='$username'");
			

				if($stmt->execute()){
					return 1; 
				}else{
					return 2; 
				}


		}

		public function userLogin($username, $pass){
			$password = md5($pass);
			$stmt = $this->con->prepare("SELECT id FROM users WHERE username = ? AND password = ?");
			$stmt->bind_param("ss",$username,$password);
			$stmt->execute();
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}


		public function getuserprofile($username, $email){
			$stmt = $this->con->prepare("SELECT id FROM users WHERE username = ? AND email = ?");
			$stmt->bind_param("ss",$username,$email);
			$stmt->execute();
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}	


		public function getUserByUsername($username){
			$stmt = $this->con->prepare("SELECT * FROM users WHERE username = ?");
			$stmt->bind_param("s",$username);
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}


		public function SearchRoom($hotel,$price,$distance,$amenities){
			$stmt = $this->con->prepare("SELECT * FROM rooms WHERE hotel = '$hotel'and price = '$price'and distance = '$distance'and amenities = '$amenities'");
			/*$stmt->bind_param("ssssss",$hotel,$price,$distance,$amenities,$checkindate,$checkintime);*/
			$stmt->execute();
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

		public function SearchRoomGuest($hotel,$price,$distance,$amenities){
			$stmt = $this->con->prepare("SELECT * FROM rooms WHERE hotel = '$hotel'and price = '$price'and distance = '$distance'and amenities = '$amenities'");
			/*$stmt->bind_param("ssssss",$hotel,$price,$distance,$amenities,$checkindate,$checkintime);*/
			$stmt->execute();
			return $stmt->get_result()->fetch_assoc();
		}
		
		
		private function isReservationExist($confirmationnumber){
			$stmt = $this->con->prepare("SELECT id FROM reservation WHERE confirmationnumber = ?");
			$stmt->bind_param("s", $confirmationnumber);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

		private function isUserExist($username, $email){
			$stmt = $this->con->prepare("SELECT id FROM users WHERE username = ? OR email = ?");
			$stmt->bind_param("ss", $username, $email);
			$stmt->execute(); 
			$stmt->store_result(); 
			return $stmt->num_rows > 0; 
		}

	}