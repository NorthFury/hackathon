define(['jquery', 'underscore', 'settings', 'text!task.html!strip'], function($, _, settings, taskTemplateString) {
    var taskTemplate = _.template(taskTemplateString);

    var buildDoItOnClick = function(userId, taskId, tasksContainer) {
        return function() {
            $.ajax({
                url: 'account/' + userId + '/task/' + taskId + '/markDone',
                type: 'PUT',
                dataType: 'json',
                success: function(data) {
                    console.log(data);
                    updateTasksContainer(tasksContainer);
                }
            });
        };
    };

    var updateTasksContainer = function(tasksContainer) {
        tasksContainer.html('');
        tasksContainer.append('<thead><tr><th>Activity</th><th>Task</th><th>Importance</th><th>Done</th><th>Achievement</th></tr></thead>');
        var tbodyContainer = $('<tbody/>');
        tasksContainer.append(tbodyContainer);

        var userId = settings.login.account.id;

        $.getJSON('/account/' + userId + '/tasks', function(data) {
            data.push({
                task: {
                    id: 1,
                    name: "Task 1"
                },
                activity: {
                    id: 1,
                    name: "Sports"
                },
                done: true,
                importance: 5
            });
            data.push({
                task: {
                    id: 1,
                    name: "Task 1"
                },
                activity: {
                    id: 1,
                    name: "Sports"
                },
                done: false,
                importance: 4
            });

            for (var i = 0; i < data.length; i++) {
                var taskElement = $(taskTemplate(data[i]));

                taskElement.find('.doIt').on('click', buildDoItOnClick(userId, data[i].id));
                tbodyContainer.append(taskElement);
            }
        });
    };

    return function(container) {
        var tasksContainer = $('<table class="table"/>');

        updateTasksContainer(tasksContainer);

        container.html('');
        container.append(tasksContainer);
    };
});
