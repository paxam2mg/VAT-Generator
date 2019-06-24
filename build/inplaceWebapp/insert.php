<?php
$servername = "remotemysql.com";
$username = "psM5g6VQz2";
$password = "JOmGCCh5HB";
$dbname = "psM5g6VQz2";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


$name = $_POST['name'];
$netto = isset($_POST['netto']) ? $_POST['netto'] : '';
$vat = isset($_POST['vat']) ? $_POST['vat'] : '';

$sql = "INSERT INTO products (name, netto, vat) VALUES ('$name', '$netto', '$vat')";
if(mysqli_query($conn, $sql)){
    echo "Dodano produkt.";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);
}

$conn->close();
?>
