/**
 * Created by trainees on 2/14/2017.
 */
angular.module('dash').controller("DashController",DashController);

    function DashController(){

        this.dashItems = [
            {name: "Home"},
            {name: "Pending Files"},
            {name: "Saved Files"},
            {name: "Trash"}
        ];

    }