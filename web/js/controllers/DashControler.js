/**
 * Created by trainees on 2/14/2017.
 */
angular.module('dash').controller("DashController",DashController);

    function DashController(){

        this.dashItems = [
            {name: "Home", class: "glyphicon glyphicon-home", href: "#/Home", click:"#"},
            {name: "Pending Files", class: "glyphicon glyphicon-file", href:"#/FileList", click:"pf.fetchFiles()"},
            {name: "Saved Files", class: "glyphicon glyphicon-inbox", href:"#",click:"#"},
            {name: "Trash", class:"glyphicon glyphicon-trash", href:"#",click:"#"}
        ];

    }
    
    angular.module('dash').config(function ($routeProvider) {
        $routeProvider.when("/Home",{
            templateUrl : "homeCard.html"
        }).when("/FileList",{
            templateUrl: "docList.html"
        }).when("/",{
            templateUrl: "homeCard.html"
        }).otherwise({
            redirectTo: 'homeCard.html'
        });
    });

    angular.module('dash').controller("PFileController",PFileController);
    
    
    function PFileController($scope,$http,$sce) {

        let userData = window.sessionStorage.getItem("email");
        if(userData){
            userData = JSON.parse(userData);
        }else {
            console.log("Data not received");
        }

        function fetchFiles(){
            $http({
                url: '/DashServlet',
                method: 'POST',
                headers:{responseType:'arraybuffer'},
                data: {"email":userData}
            }).then(function (response) {
                let fileName = response.data.fileName;
                let file =  new Blob([response.data.file], {type: 'application/pdf'});
                let fileURL = window.URL.createObjectURL(file);
                $scope.content = $sce.trustAsResourceUrl(fileURL);
            });
        }
        
    }