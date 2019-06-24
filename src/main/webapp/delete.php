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


$id = $_POST['id'];


$sql = "DELETE FROM products WHERE id='$id'";
if(mysqli_query($conn, $sql)){
    echo "Usunięto produkt.";
} else{
    echo "ERROR: Could not able to execute $sql. " . mysqli_error($conn);
}

$conn->close();
?>