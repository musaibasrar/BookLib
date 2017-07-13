<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="javascript">
    var xmlhttp;
    function init() {
       // put more code here in case you are concerned about browsers that do not provide XMLHttpRequest object directly
       xmlhttp = new XMLHttpRequest();
    }
    function getdetails() {
        var empno = document.getElementById("empno");
        var url = "http://localhost:9099/Bookan/rest/entry/getAllBooks";
       
        xmlhttp.onreadystatechange = function() {

               var empname =  document.getElementById("empname");
               var age =  document.getElementById("age");
               if (xmlhttp.readyState == 4) {
                  if ( xmlhttp.status == 200) {
                	  alert(eval( "(" +  xmlhttp.responseText + ")"));
                       var det = eval( "(" +  xmlhttp.responseText + ")");
                       alert(det);
                       var Data = JSON.parse(xmlhttp.responseText);
                       
                       console.log(Data);
                          empname.value = det.author;
                          age.value = det.ISBN;
                       
                           
                      
                 }
                 else
                       alert("Error ->" + xmlhttp.responseText);
              }
        };
        
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
    }
  </script>
  </head>
  <body  onload="init()">
   <h1>Call Employee Service </h1>
   <table>
   <tr>
       <td>Enter Employee ID :  </td>
       <td><input type="text" id="empno" size="10"/>  <input type="button" value="Get Details" onclick="getdetails()"/>
   </tr>
   <tr>
       <td>Enter Name :  </td>
       <td><input type="text" readonly="true" id="empname" size="20"/> </td>
   </tr>

   <tr>
       <td>Employee Age : </td>
       <td><input type="text" readonly="true" id="age" size="10"/> </td>
   </tr>
   </table>
  </body>
</html>