
-- let's insert some data

insert into developer values ('Nick');
insert into developer values ('John');
insert into developer values ('Frank');
insert into developer values ('Mark');

-- BUGS
insert into issue(ISSUE_ID, TYPE, TITLE, DESCRIPTION, CREATION_DATE, DEVELOPER_NAME) values(0, 'B', 'ui problem', 'user interface has a big problem', CURRENT_TIMESTAMP, 'John'); 
insert into bug values(0, 'MAJOR', 'NEW');  

insert into issue(ISSUE_ID, TYPE, TITLE, DESCRIPTION, CREATION_DATE, DEVELOPER_NAME) values(1, 'B', 'interaction', 'controlo xyz does not respond properly', CURRENT_TIMESTAMP, 'Mark');
insert into bug values(1, 'CRITICAL', 'VERIFIED');

insert into issue(ISSUE_ID, TYPE, TITLE, DESCRIPTION, CREATION_DATE, DEVELOPER_NAME) values(2, 'B', 'corrupted data', 'data retrieved is not correct', CURRENT_TIMESTAMP, 'Nick');
insert into bug values(2, 'MINOR', 'RESOLVED');

-- STORIES
insert into issue(ISSUE_ID, TYPE, TITLE, DESCRIPTION, CREATION_DATE, DEVELOPER_NAME) values(3, 'S', 'ui stroy', 'stuff to do on UI', CURRENT_TIMESTAMP, 'Nick');
insert into story values(3, 40, 'NEW');

insert into issue(ISSUE_ID, TYPE, TITLE, DESCRIPTION, CREATION_DATE, DEVELOPER_NAME) values(4, 'S', 'interaction story', 'stuff to do to interaction', CURRENT_TIMESTAMP, 'Frank');
insert into story values(4, 38, 'ESTIMATED');

insert into issue(ISSUE_ID, TYPE, TITLE, DESCRIPTION, CREATION_DATE, DEVELOPER_NAME) values(5, 'S', 'data story', 'stuff to do to the data layer', CURRENT_TIMESTAMP, 'Frank');
insert into story values(5, 56, 'COMPLETED');