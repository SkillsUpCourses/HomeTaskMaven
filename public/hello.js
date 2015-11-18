function Hello($scope, $http) {
    $http.get("http://localhost:8080/greeting").
        success(function(data) {
            $scope.greeting = data;
        });
        
        
    $scope.update = function() {
        $http.get('greeting', {params: {sid: $scope.sid, 
                                        busId: $scope.busId, 
                                        deparLogin : $scope.deparLogin,
                                        respPerson : $scope.respPerson,
                                        email : $scope.email,
                                        descr : $scope.descr
                                       }}).
	        success(function(data) {
	            $scope.greeting = data;
	        });
                
        $http.get("http://localhost:8080/createbusid").
        success(function(data) {
            $scope.createbusid = data;
        });

    }
        

        
   
}
