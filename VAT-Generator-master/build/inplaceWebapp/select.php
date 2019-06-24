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

$sql = "SELECT * FROM `products`";
$result = mysqli_query($conn,$sql);

 echo "<p>";
 echo "<table cellpadding=\"4\" border=\"1\"><tr>";
 echo "<td><strong>ID</strong></td>";
 echo "<td><strong>Name</strong></td>";
 echo "<td><strong>Netto</strong></td>";
 echo "<td><strong>VAT</strong></td>";
 echo "</tr>";

 while ( $row = mysqli_fetch_array($result) ) {
    echo "</tr>";
    echo "<td>" . $row["id"] . "</td>";
    echo "<td>" . $row["name"] . "</td>";
    echo "<td>" . $row["netto"] . "</td>";
    echo "<td>" . $row["vat"] . "</td>";
    echo "</tr>";
 }
 echo "</table>";


$conn->close();
?>

