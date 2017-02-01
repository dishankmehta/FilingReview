/**
 * Created by trainees on 1/31/2017.
 */
angular.module('reg').controller('RegController',RegController).directive("compareTo",compareTo);


    function RegController($scope,$http) {
        console.log('Register called.');
        $scope.submitRegForm = function () {
            $http({
                url: 'RegisterServlet',
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                data: {
                    'firstName': $scope.firstName,
                    'lastName': $scope.lastName,
                    'gender': $scope.gender,
                    'contact': $scope.contact,
                    'userName': $scope.userName,
                    'email': $scope.email,
                    'password': $scope.password
                }
            }).success(function (data,status,headers,config) {
                console.log(data);
                window.location.href = "index.html";
                window.alert("You have been successfully registered..!!");
            });
        };

    }


    function compareTo() {
        return {
            require: "ngModel",
            scope: {
                otherModelValue: "=compareTo"
            },
            link: function (scope,element,attributes, ngModel) {

                ngModel.$validators.compareTo = function(modelValue){
                    return modelValue == scope.otherModelValue;
                };

                scope.$watch("otherModelValue", function () {
                    ngModel.$validate();
                });
            }
        };
    }