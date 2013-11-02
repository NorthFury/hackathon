define(['jquery', 'underscore', 'settings', 'text!task.html!strip'], function($, _, settings, taskTemplateString) {
    var taskTemplate = _.template(taskTemplateString);

    var buildDoItOnClick = function(userId, taskId) {
        return function() {
            $.ajax({
                url: 'account/' + userId + '/task/' + taskId + '/markDone',
                type: 'PUT',
                dataType: 'json',
                success: function(data) {
                    console.log(data);
                }
            });
        };
    };

    var updateTasksContainer = function(tasksContainer) {
        var userId = settings.login.account.id;

        $.getJSON('/account/' + userId + '/tasks', function(data) {
            data.push({
                id: 1,
                name: "Task 1",
                activity: {
                    id: 1,
                    name: "Sports"
                }
            });
            data.push({
                id: 2,
                name: "Task 2",
                activity: {
                    id: 1,
                    name: "House"
                }
            });

            for (var i = 0; i < data.length; i++) {
                var taskObject = {
                    activity: data[i].activity.name,
                    name: data[i].name
                };

                var taskElement = $(taskTemplate(taskObject));

                taskElement.find('.doIt').on('click', buildDoItOnClick(userId, data[i].id));
                tasksContainer.append(taskElement);
            }
        });
    };

    return function(container) {
        var tasksContainer = $('<div/>');

        updateTasksContainer(tasksContainer);

        container.html('');
        container.append(tasksContainer);
    };
});
