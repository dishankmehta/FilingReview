/**
 * Created by trainees on 1/31/2017.
 */
angular.module('login').controller('LoginController',LoginController);

    function LoginController($scope, $http) {

        var self = this;
        
        self.checkUser = checkUser;
        
        
        function checkUser() {
            $http({
                url: 'LoginServlet',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                data: {
                    'userName': $scope.userName,
                    'password': $scope.password
                }
            }).success(function (data) {
                window.location.href = "mainPanel.html";
            });
        }

    }