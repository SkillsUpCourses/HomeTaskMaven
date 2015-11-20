function Hello($scope, $http) {
    $http.get("http://localhost:8080/createbus").
        success(function(data) {
            $scope.createbus = data;
        });
        
        
    $scope.update = function() {
        $http.get('createbus', {params: {sid: $scope.sid, 
                                        busId: $scope.busId, 
                                        deparLogin : $scope.deparLogin,
                                        respPerson : $scope.respPerson,
                                        email : $scope.email,
                                        descr : $scope.descr
                                       }}).
	        success(function(data) {
	            $scope.createbus = data;
	        });
                
    }
        

        
   
}
