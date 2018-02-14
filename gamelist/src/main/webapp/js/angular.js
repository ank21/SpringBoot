var app = angular.module("app", []);

app.controller("ctrl", function($scope, $http) {
	
	
	
	$scope.sort="none"
	$scope.fkey="none"
	$scope.refresh=function(){
		console.log("in rest")
		$http({

			url : "/gamelist/get" ,
			method : "GET",
			params: {
				"sort": $scope.sort,
				"fkey": $scope.fkey
			}
			}).then(function(response){
			$scope.dataset=response.data;
			},function(error){alert("eror"+error)});
	}
	
	$scope.sortMode=function(){
		
		if($scope.sortit=="ascending"){
			
			$scope.sort="ascending";
			$scope.refresh();
		}
		if($scope.sortit=="descending"){
			
			$scope.sort="descending"
				$scope.refresh();
		}
		}
	
	$scope.filter=function(fltkey){
		$scope.fkey=fltkey;
		$scope.refresh();
	}
	
	$scope.paginate=function(n){
		$scope.page=n;
		$scope.refresh();
	}
	
	
		
});