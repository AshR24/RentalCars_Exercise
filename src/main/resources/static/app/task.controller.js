(
    function()
    {
        'use strict';

        angular
            .module('app')
            .controller('TaskController', TaskController);

        TaskController.$inject = ['$http'];

        function TaskController($http)
        {
            var vm = this;

            vm.taskToGet = "";
            vm.tasks = [];
            vm.doTask = doTask;


            function doTask()
            {
                var url = "/tasks/" + vm.taskToGet;

                $http.get(url).then(function(response)
                {
                    vm.tasks = response.data;
                });
            }
        }
    }
)();