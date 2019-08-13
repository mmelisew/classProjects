<?php
	include ('includes/session.php');
	include ('includes/header.html');

// Check for form submission:
if ($_SERVER['REQUEST_METHOD'] == 'POST') {

	require ('mysqli_connect.php'); // Connect to the db.
		
	$errors = array(); // Initialize an error array.
	
	//Check for Customer Username

	if (empty($_POST['user_name'])) {
		$errors[] = 'You forgot to enter your user name.';
	} else {
		$un = mysqli_real_escape_string($dbc, trim($_POST['Customer_username']));
	}

	// Check for a password and match against the confirmed password:
	if (!empty($_POST['pass1'])) {
		if ($_POST['pass1'] != $_POST['pass2']) {
			$errors[] = 'Your password did not match the confirmed password.';
		} else {
			$p = mysqli_real_escape_string($dbc, trim($_POST['Customer_password']));
		}
	} else {
		$errors[] = 'You forgot to enter your password.';
	}

	// Check for a first name:
	if (empty($_POST['first_name'])) {
		$errors[] = 'You forgot to enter your first name.';
	} else {
		$fn = mysqli_real_escape_string($dbc, trim($_POST['Customer_fName']));
	}
	
	// Check for a last name:
	if (empty($_POST['last_name'])) {
		$errors[] = 'You forgot to enter your last name.';
	} else {
		$ln = mysqli_real_escape_string($dbc, trim($_POST['Customer_lName']));
	}

	// Check for a phone number:
	if (empty($_POST['phone_number'])) {
		$errors[] = 'You forgot to enter your phone number.';
	} else {
		$pn = mysqli_real_escape_string($dbc, trim($_POST['Customer_phone']));
	}
	
	// Check for an email address:
	if (empty($_POST['email'])) {
		$errors[] = 'You forgot to enter your email address.';
	} else {
		$e = mysqli_real_escape_string($dbc, trim($_POST['Customer_email']));
	}

	//Check for Customer Address
	if (empty($_POST['address'])) {
		$errors[] = 'You forgot to enter your address.';
	} else {
		$a = mysqli_real_escape_string($dbc, trim($_POST['Customer_address']));
	}

	//Check for Customer City
	if (empty($_POST['city'])) {
		$errors[] = 'You forgot to enter your city.';
	} else {
		$c = mysqli_real_escape_string($dbc, trim($_POST['Customer_city']));
	}

	//Check for Customer State
	if (empty($_POST['state'])) {
		$errors[] = 'You forgot to enter your state.';
	} else {
		$s = mysqli_real_escape_string($dbc, trim($_POST['Customer_state']));
	}

	//Check for Customer Zip Code
	if (empty($_POST['zip_code'])) {
		$errors[] = 'You forgot to enter your zip code.';
	} else {
		$zc = mysqli_real_escape_string($dbc, trim($_POST['Customer_username']));
	}
	
	if (empty($errors)) { // If everything's OK.
	
		// Register the user in the database...
		
		// Make the query:
		$q = "INSERT INTO Customers (Customer_username, Customer_password, Customer_fName, Customer_lName, Customer_phone, Customer_email, Customer_address, Customer_city, Customer_state, Customer_zipcode) VALUES ('$un', SHA1('$p'), '$fn', '$ln', '$pn', '$e', '$a', '$c', '$s', '$zc' )";		
		$r = @mysqli_query ($dbc, $q); // Run the query.
		if ($r) { // If it ran OK.
		
		/* Extracted after "Customers" - */

			// Print a message:
			echo '<h1>Thank you!</h1>
		<p>You are now registered.</p><p><br /></p>';	
		
		} else { // If it did not run OK.
			
			// Public message:
			echo '<h1>System Error</h1>
			<p class="error">You could not be registered due to a system error. We apologize for any inconvenience.</p>'; 
			
			// Debugging message:
			echo '<p>' . mysqli_error($dbc) . '<br /><br />Query: ' . $q . '</p>';
						
		} // End of if ($r) IF.
		
		mysqli_close($dbc); // Close the database connection.

		// Include the footer and quit the script:
		include ('includes/footer.html'); 
		exit();
		
	} else { // Report the errors.
	
		echo '<h1>Error!</h1>
		<p class="error">The following error(s) occurred:<br />';
		foreach ($errors as $msg) { // Print each error.
			echo " - $msg<br />\n";
		}
		echo '</p><p>Please try again.</p><p><br /></p>';
		
	} // End of if (empty($errors)) IF.
	
	mysqli_close($dbc); // Close the database connection.

}

?>
<div class="content">
	<h1>Register</h1>
	<form action="register.php" method="post">
		<p>User Name: <input type="text" name="user_name" size="15" maxlength="20" value="<?php if (isset($_POST['user_name'])) echo $_POST['user_name']; ?>" /></p>
		<p>Password: <input type="password" name="pass1" size="10" maxlength="20" value="<?php if (isset($_POST['pass1'])) echo $_POST['pass1']; ?>"  /></p>
		<p>Confirm Password: <input type="password" name="pass2" size="10" maxlength="20" value="<?php if (isset($_POST['pass2'])) echo $_POST['pass2']; ?>"  /></p>
		<p>First Name: <input type="text" name="first_name" size="15" maxlength="20" value="<?php if (isset($_POST['first_name'])) echo $_POST['first_name']; ?>" /></p>
		<p>Last Name: <input type="text" name="last_name" size="15" maxlength="40" value="<?php if (isset($_POST['last_name'])) echo $_POST['last_name']; ?>" /></p>
		<p>Phone Number: <input type="text" name="phone_number" size="20" maxlength="14" value="<?php if (isset($_POST['phone_number'])) echo $_POST['phone_number']; ?>" /></p>
		<p>Email Address: <input type="text" name="email" size="20" maxlength="60" value="<?php if (isset($_POST['email'])) echo $_POST['email']; ?>"  /> </p>
		<p>Address: <input type="text" name="address" size="20" maxlength="30" value="<?php if (isset($_POST['address'])) echo $_POST['address']; ?>"  /> </p>
		<p>City: <input type="text" name="city" size="20" maxlength="30" value="<?php if (isset($_POST['city'])) echo $_POST['city']; ?>"  /> </p>
		<p>State: <input type="text" name="state" size="20" maxlength="2" value="<?php if (isset($_POST['state'])) echo $_POST['state']; ?>"  /> </p>
		<p>Zip Code: <input type="number" name="zip_code" size="20" maxlength="5" value="<?php if (isset($_POST['zip_code'])) echo $_POST['zip_code']; ?>"  /> </p>
		<p><input type="submit" name="submit" value="Register" /></p>
	</form>
</div>
<?php include ('includes/footer.html'); ?>