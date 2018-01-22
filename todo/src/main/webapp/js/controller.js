var app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {

	$scope.refresh = function(fil) {
		$http.get("/todo/get/" + fil).success(function(data) {
			$scope.todoItem = data
		}).error(function() {
			alert("error")
		})
	}
	$scope.filter = function(fil) {
		$scope.refresh(fil);
	}
	$scope.add = function() {

		var todo = $("#datepicker1").datepicker({
			dateFormat : 'dd/mm/yyyy'
		}).val();
		var duedate = $("#datepicker2").datepicker({
			dateFormat : 'dd/mm/yyyy'
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

			$scope.refresh("normal");
		}, function(err) {
			alert("error")
		})
	}

});