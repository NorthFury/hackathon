define(['jquery', 'underscore', 'settings', 'text!task.html!strip'], function($, _, settings, taskTemplateString) {
    var taskTemplate = _.template(taskTemplateString);
    var tasksArray = [];

    return function(container) {
        var userId = settings.login.account.id;
        var tasksContainer = $('<div/>');

        $.getJSON('/account/' + userId + '/tasks', function(data) {
            data.push({
            	id : 1,
                name: "Task 1",
                activity: {
                    id: 1,
                    name: "Sports"
                }
            });
            data.push({
            	id:2,
                name: "Task 2",
                activity: {
                    id: 1,
                    name: "House"
                }
            });

            for (var i = 0; i < data.length; i++) {
                var taskObject = {
                    activity: data[i].activity.name,
                    name: data[i].name,
                    id : i
                };
                
                tasksArray.push(taskObject);
                
                // tasksContainer.append(taskTemplate(taskObject));
            }
            
            var taskListObject = {
                    taskList: tasksArray
                };
            
            tasksContainer.append(taskTemplate(taskListObject));
        });
        container.html('');
        container.append(tasksContainer);
    };
});