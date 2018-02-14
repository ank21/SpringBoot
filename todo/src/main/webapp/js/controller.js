
var app = angular.module("app", []);



app.controller("ctrl", function($scope, $http) {
	$scope.fkey = "normal"
	$scope.refresh = function() {
		
		
		$http({

			url : "/todo/get",
			method : "GET",
			params : {
				"filter" : $scope.fkey
			}

		}).then(function(response) {
			
			$scope.todoItem = response.data;
			
			
		}, function(error) {
			alert("error")
		});
		
		
		
	}
	
	
	$scope.filter = function(fil) {

		$scope.fkey = fil;
		$scope.refresh();
	}
	$scope.add = function() {

		var todo = $("#datepicker1").datepicker({
			dateFormat : 'yyyy/mm/dd'
		}).val();
		var duedate = $("#datepicker2").datepicker({
			dateFormat : 'yyyy/mm/dd'
		}).val();
		var data = JSON.stringify({
			todoList : [ {
				taskName : $scope.task,
				dueDate : duedate,
				status : $scope.status,
				todoType : $scope.type
			} ],
			todoDate : todo
		});

		console.log(data);
		$http.post("/todo/pdata", data).then(

		function(response) {

			$scope.refresh();
		}, function(err) {
			alert("error")
		})
	}

});
