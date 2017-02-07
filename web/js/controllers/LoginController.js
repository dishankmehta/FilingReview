/**
 * Created by trainees on 1/31/2017.
 */
angular.module('login').controller('LoginController',LoginController);

    function LoginController($scope, $http) {

        var self = this;
        
        self.checkUser = checkUser;
        self.isValid = false;
        
        function checkUser() {
            $http({
                url: 'LoginServlet',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                data: {
                    'userName': $scope.userName,
                    'password': $scope.password
                }
            }).success(function (data,status,headers,config) {
                /*window.location.href = "mainPanel.html";*/
                $scope.isValid = data;
            }).error(function (data,status,headers,config) {
                console.log(data);
                $scope.isValid = data;
                console.log($scope.isValid);
            });
        }

    }