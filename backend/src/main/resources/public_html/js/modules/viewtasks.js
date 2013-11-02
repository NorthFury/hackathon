define(['jquery', 'underscore', 'settings', 'text!task.html!strip'], function($, _, settings, taskTemplateString) {
    var taskTemplate = _.template(taskTemplateString);

    return function(container) {
        var userId = settings.login.account.id;
        var tasksContainer = $('<div/>');

        $.getJSON('/account/' + userId + '/tasks', function(data) {
            data.push({
                name: "Task 1",
                activity: {
                    id: 1,
                    name: "Sports"
                }
            });
            data.push({
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
                tasksContainer.append(taskTemplate(taskObject));
            }
        });
        container.html('');
        container.append(tasksContainer);
    };
});