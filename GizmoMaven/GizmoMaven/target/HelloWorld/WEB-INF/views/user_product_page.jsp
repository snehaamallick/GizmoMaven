<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USER PRODUCT PAGE</title>
</head>

<body>
<h1>User Product Page!</h1>
<table id="myTable">  
        <thead>  
          <tr>  
            <th>ENO</th>  
            <th>EMPName</th>  
            <th>Country</th>  
            <th>Salary</th>  
          </tr>  
        </thead>  
        <tbody>  
          <tr>  
            <td>001</td>  
            <td>Anusha</td>  
            <td>India</td>  
            <td>10000</td>  
          </tr>  
          <tr>  
            <td>002</td>  
            <td>Charles</td>  
            <td>United Kingdom</td>  
            <td>28000</td>  
          </tr>  
          <tr>  
            <td>003</td>  
            <td>Sravani</td>  
            <td>Australia</td>  
            <td>7000</td>  
          </tr>  
           <tr>  
            <td>004</td>  
            <td>Amar</td>  
            <td>India</td>  
            <td>18000</td>  
          </tr>  
          <tr>  
            <td>005</td>  
            <td>Lakshmi</td>  
            <td>India</td>  
            <td>12000</td>  
          </tr>  
          <tr>  
            <td>006</td>  
            <td>James</td>  
            <td>Canada</td>  
            <td>50000</td>  
          </tr>  
          
           <tr>  
            <td>007</td>  
            <td>Ronald</td>  
            <td>US</td>  
            <td>75000</td>  
          </tr>  
          <tr>  
            <td>008</td>  
            <td>Mike</td>  
            <td>Belgium</td>  
            <td>100000</td>  
          </tr>  
          <tr>  
            <td>009</td>  
            <td>Andrew</td>  
            <td>Argentina</td>  
            <td>45000</td>  
          </tr>  
          
            <tr>  
            <td>010</td>  
            <td>Stephen</td>  
            <td>Austria</td>  
            <td>30000</td>  
          </tr>  
          <tr>  
            <td>011</td>  
            <td>Sara</td>  
            <td>China</td>  
            <td>750000</td>  
          </tr>  
          <tr>  
            <td>012</td>  
            <td>JonRoot</td>  
            <td>Argentina</td>  
            <td>65000</td>  
          </tr>  
        </tbody>  
      </table>  
      <script>
$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>
<table id="myTable" class="table table-striped" ></table>
</body>
</html>