INSERT INTO account (id, email) VALUES (1, 'andrei@test.com');
INSERT INTO account (id, email) VALUES (2, 'andrei@test.com');
INSERT INTO account (id, email) VALUES (3, 'andrei@test.com');


INSERT INTO activity (id, name) VALUES (1, 'chores');

INSERT INTO task (id, activity_id, name) VALUES (1, 1,  'take out the trash');
INSERT INTO task (id, activity_id, name) VALUES (2, 1,  'walk the dog');
INSERT INTO task (id, activity_id, name) VALUES (3, 1,  'do the dishes');

INSERT INTO account_task (id, account_id, task_id, done, importance) VALUES (1, 1, 1, true, 2);
INSERT INTO account_task (id, account_id, task_id, done, importance) VALUES (2, 1, 2, true, 2);
INSERT INTO account_task (id, account_id, task_id, done, importance) VALUES (3, 1, 3, true, 2);



COMMIT;
