/**
 * Created by trainees on 1/30/2017.
 */

    angular.module('users').controller('UserController',UserController);

    function UserController( userService, $mdSidenav, $mdBottomSheet, $log) {
        let self = this;

        self.selected = null;
        self.users = [];
        self.selectUser = selectUser;
        self.toggleList = toggleUsersList;
        self.share = share;

        userService.loadAllUsers().then(function (users) {
           self.users = [].concat(users);
           self.selected = users[0];
        });

        function toggleUsersList() {
            $mdSidenav('left').toggle();
        }

        function selectUser(user) {
            self.selected = angular.isNumber(user) ? $scope.users[user] : user;
        }


        function share(selectedUser) {

            $mdBottomSheet.show({
                controller: UserSheetController,
                controllerAs: 'vm',
                templateUrl: '../../bottomSheet.html',
                parent: angular.element(document.querySelector('#content'))
            });

            function UserSheetController() {
                this.user = selectedUser;
                this.items = [
                    {name:'Phone', icon:'phone', icon_url:'svgs/phone.svg'},
                    {name:'Twitter', icon:'twitter', icon_url:'svgs/twitter.svg'},
                    {name:'Google+', icon:'google_plus', icon_url:'svgs/google_plus.svg'},
                    {name:'Hangout', icon:'hangouts', icon_url:'svgs/hangouts.svg'}
                ];
                this.performAction = function (action) {
                    $mdBottomSheet.hide();
                };
            }
            
        }
    }
