var app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {
	$scope.type="none"
	$scope.refresh = function() {

		
		$http({

			url : "/battlelist",
			method : "GET",
			params : {"filter" : $scope.type}
		}).then(function(response) {

			$scope.list = response.data;
			console.log($scope.list);

		}, function(error) {
			alert("error")
		});

	}

	$scope.refreshkings = function() {

		$http({

			url : "/kingslist",
			method : "GET",
		}).then(function(response) {

			$scope.king = response.data;
			console.log($scope.king);

		}, function(error) {
			alert("error")
		});

	}
	$scope.detail = function(king) {
		$http({

			url : "/findking",
			method : "GET",
			params : {
				"king" : king
			}
		}).then(function(response) {

			$scope.name = response.data.name;
			$scope.battle_won = response.data.battle_won;
			$scope.battle_lost = response.data.battle_lose;
			$scope.ratting = response.data.ratting;
			//$scope.king= response.data;
			console.log(response.data);

		}, function(error) {
			alert("error")
		});
	}
	
	$scope.filter=function(fkey){
		console.log("in the filter"+fkey)
		$scope.type=fkey;
		$scope.refresh();
		
	}

})