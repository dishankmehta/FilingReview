/**
 * Created by trainees on 2/14/2017.
 */
angular.module('dash').controller("DashController",DashController);

    function DashController(){

        this.dashItems = [
            {name: "Home", class: "glyphicon glyphicon-home"},
            {name: "Pending Files", class: "glyphicon glyphicon-file"},
            {name: "Saved Files", class: "glyphicon glyphicon-inbox"},
            {name: "Trash", class:"glyphicon glyphicon-trash"}
        ];

    }