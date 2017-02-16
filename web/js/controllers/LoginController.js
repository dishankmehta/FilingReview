/**
 * Created by trainees on 1/31/2017.
 */
angular.module('login').controller('LoginController',LoginController);

    function LoginController($scope, $http) {

        let self = this;
        self.checkUser = checkUser;
        self.isValid = false;
        $scope.showModal = false;

        function checkUser() {
            $http({
                url: '/LoginServlet',
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                data: {
                    'userName': $scope.userName,
                    'password': $scope.password
                }
            }).then(function (response) {
                console.log(response.data);
                self.isValid = response.data;
                switch (self.isValid){
                    case "true":    $scope.showModal = false;
                                    console.log("true case");
                                    console.log(self.isValid);
                                    window.location.href = "mainPanel.html";
                                    break;
                    case "false":   $scope.showModal = true;
                                    console.log("false case");
                                    self.isValid = response.data;
                                    console.log(self.isValid);
                                    break;
                }
            });
        }

    }

