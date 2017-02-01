/**
 * Created by Dishank on 1/29/2017.
 */
    'use strict';

    angular.module('users').service('userService', UserService);


    function UserService($q) {
        var users = [
            {
                name: 'Dishank Mehta',
                avatar: 'svg-1',
                content: 'I am Dishank Mehta and I am developing this app using Angular with MVC architecture.'
            },
            {
                name: 'Mishal Mehta',
                avatar: 'svg-2',
                content: 'I am Mishal Mehta and I am developing this app using Angular with MVC architecture.'
            },
            {
                name: 'Satish Shah',
                avatar: 'svg-3',
                content: 'I am Satish Shah and I am developing this app using Angular with MVC architecture.'
            },
            {
                name: 'Sunil Mehra',
                avatar: 'svg-4',
                content: 'I am Sunil Mehra and I am developing this app using Angular with MVC architecture.'
            }
        ];

        return{
            loadAllUsers: function () {
                return $q.when(users);
            }
        };
    }