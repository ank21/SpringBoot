var app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {
	$scope.fkey = "normal"
	$scope.disfilter = false;
	$scope.refresh = function() {

		$http({

			url : "/todo/get",
			method : "GET",
			params : {
				"filter" : $scope.fkey
			}

		}).then(
				function(response) {

					var days = [ 'Sun', 'Mon', 'Tue', 'Wed',
							'Thur', 'Fri', 'Sat' ];
					var month=['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sept','Oct','Nov','Dec'];
					// var d = new Date(dateString);
					// var dayName = days[d.getDay()];
					var size = Object.keys(response.data).length;
					console.log("response length" + size)
					for ( var i=0;i<size;i++) {
						+"("+dayName+")"
						var dateString=response.data[i]["todoDate"];
						var d = new Date(dateString);
						var dayName = days[d.getDay()];
						var mon=month[d.getMonth()];
						var da=d.getDate();
						var yr=d.getFullYear();
						response.data[i]["todoDate"]=mon+"  "+dayName+"  "+da+"  "+yr;
					}

					$scope.todoItem = response.data;
					console.log($scope.todoItem);

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

		$http.post("/todo/pdata", data).then(

		function(response) {

			$scope.refresh();
		}, function(err) {
			alert("error")
		})
	}

	$(document).on('click', 'body .table .update', function() {

		var t = $('#se').click().val()
		var a = $(this).closest("tr").find("td:eq(2)").html(t);
		var id = $(this).closest("tr").find("td:eq(4) button").attr('id');

		$http({

			url : "/todo/update",
			method : "GET",
			params : {
				"id" : id,
				"value" : t
			}
		}).then(function(response) {
			console.log(t);
			$scope.refresh();

		}, function(error) {
			alert("Please edit")
		});

	})

	$scope.rmfilter = function() {

		if ($scope.disfilter == false) {
			$scope.disfilter = true;
		} else if ($scope.disfilter == true) {
			$scope.fkey = "normal"
			$scope.refresh()
			$scope.disfilter = false;
		}
	}

});
