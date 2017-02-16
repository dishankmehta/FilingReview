/**
 * Created by trainees on 2/14/2017.
 */
angular.module('dash').controller("DashController",DashController);

    function DashController(){

        this.dashItems = [
            {name: "Home", class: "glyphicon glyphicon-home", href: "dashBoard.html"},
            {name: "Pending Files", class: "glyphicon glyphicon-file", href:"docList.html"},
            {name: "Saved Files", class: "glyphicon glyphicon-inbox", href:"#"},
            {name: "Trash", class:"glyphicon glyphicon-trash", href:"#"}
        ];

    }
    
    /*angular.module('dash').config(function ($routeProvider) {
        $routeProvider.when("dashBoard.html",{
            templateUrl : "dashBoard.html"
        }).when("/docList",{
            templateUrl: "docList.html"
        }).otherwise({
            redirectTo: 'dashBoard.html'
        });
    });*/