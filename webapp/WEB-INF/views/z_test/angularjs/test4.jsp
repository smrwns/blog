<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="countryApp">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AngularJs Test Page 4</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.0-rc.4/angular.min.js"></script>
    <script> 
      var countryApp = angular.module('countryApp', []); 
      countryApp.controller('CountryCtrl', function ($scope){ 
        $scope.countries = [ 
           {"name": "China", "population": 1359821000}, 
           {"name": "India", "population": 1205625000}, 
           {"name": "United States of America","population": 312247000} 
         ]; 
       }); 
     </script> 
   </head> 
   <body ng-controller="CountryCtrl"> 
     <table> 
       <tr> 
         <th>Country</th> 
         <th>Population</th> 
       </tr> 
       <tr ng-repeat="country in countries"> 
         <td>{{country.name}}</td> 
         <td>{{country.population}}</td> 
       </tr> 
     </table> 
   </body> 
</html> 
