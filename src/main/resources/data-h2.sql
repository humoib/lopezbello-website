select 'HELLLOOOOO';

-- thing types
INSERT INTO THING_TYPE_SCHEMA (TTS_ID, TTS_NAME, TTS_DESCRIPTION) VALUES (1, 'Boxes with Things', 'desc');
INSERT INTO THING_TYPE_SCHEMA (TTS_ID, TTS_NAME, TTS_DESCRIPTION) VALUES (2, 'Software Development', 'desc');
INSERT INTO THING_TYPE_SCHEMA (TTS_ID, TTS_NAME, TTS_DESCRIPTION) VALUES (3, 'ITSM - Service Management', 'desc');
INSERT INTO THING_TYPE_SCHEMA (TTS_ID, TTS_NAME, TTS_DESCRIPTION) VALUES (4, 'Photo Box', 'desc');
INSERT INTO THING_TYPE_SCHEMA (TTS_ID, TTS_NAME, TTS_DESCRIPTION) VALUES (5, 'Green Dodo Guides', 'desc');
INSERT INTO THING_TYPE_SCHEMA (TTS_ID, TTS_NAME, TTS_DESCRIPTION) VALUES (6, 'My world', 'desc');

-- thing types
INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (1, 'Whatever');
INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (6, 'Person');
		
INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (2, 'Issue');
INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (3, 'Task');
INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (4, 'Incident');
INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (5, 'Service Request');

INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (7, 'Album');
INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (8, 'Photo');

INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (9, 'Place');

INSERT INTO THING_TYPE (TTY_ID, TTY_NAME) VALUES (10, 'Entity');


INSERT INTO THING_TYPE_SCHEMA_THINGTYPE (THINGTYPESCHEMA_TTS_ID, THINGTYPE_TTY_ID) VALUES (1, 1);
INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (1, 2);
INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (2, 3);
INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (3, 4);
INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (3, 5);
INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (1, 6); -- person

INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (4, 7); -- album
INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (4, 8); -- photo

INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (5, 9); -- photo

INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (6, 6); -- person
INSERT INTO THING_TYPE_SCHEMA_THINGTYPE VALUES  (6, 10); -- entity

-- status
INSERT INTO STATUS (STA_ID, STA_CATEGORY, STA_CREATED_DATETIME, STA_NAME)
	VALUES (1, 1, NOW(), 'Open');  
INSERT INTO STATUS (STA_ID, STA_CATEGORY, STA_CREATED_DATETIME, STA_NAME)
	VALUES (2, 1, NOW(), 'Pending');
INSERT INTO STATUS (STA_ID, STA_CATEGORY, STA_CREATED_DATETIME, STA_NAME)
	VALUES (3, 2, NOW(), 'In Progress');
INSERT INTO STATUS (STA_ID, STA_CATEGORY, STA_CREATED_DATETIME, STA_NAME)
	VALUES (4, 3, NOW(), 'Closed');

-- boxes
INSERT INTO BOX (BOX_ID, BOX_KEY, BOX_NAME, BOX_TYPE, BOX_VIEW, BOX_CREATED_DATETIME, BOX_LAST_KEY, BOX_THINGTYPE_SCHEMA ) 
	VALUES (1, 'POO', 'My secret things (DEMO)', 1, 'cards', NOW(), 23, 1); 
INSERT INTO BOX (BOX_ID, BOX_KEY, BOX_NAME, BOX_TYPE, BOX_VIEW, BOX_CREATED_DATETIME, BOX_LAST_KEY, BOX_THINGTYPE_SCHEMA ) 
	VALUES (2, 'PROJECT', 'Project Management (DEMO)', 3, 'sprints', NOW(), 0, 2); 
INSERT INTO BOX (BOX_ID, BOX_KEY, BOX_NAME, BOX_TYPE, BOX_VIEW, BOX_CREATED_DATETIME, BOX_LAST_KEY, BOX_THINGTYPE_SCHEMA ) 
	VALUES (3, 'SCRUM', 'Developing with agile methodologies (DEMO)', 4, 'kanban', NOW(), 2, 2); 
INSERT INTO BOX (BOX_ID, BOX_KEY, BOX_NAME, BOX_TYPE, BOX_VIEW, BOX_CREATED_DATETIME, BOX_LAST_KEY, BOX_THINGTYPE_SCHEMA ) 
	VALUES (4, 'DESK', 'Service Desk Box (DEMO)', 5, 'queues', NOW(), 2, 3); 
INSERT INTO BOX (BOX_ID, BOX_KEY, BOX_NAME, BOX_TYPE, BOX_VIEW, BOX_CREATED_DATETIME, BOX_LAST_KEY, BOX_THINGTYPE_SCHEMA ) 
	VALUES (5, 'PHOTO', 'Photo Box', 6, 'photo', NOW(), 1, 4); 
INSERT INTO BOX (BOX_ID, BOX_KEY, BOX_NAME, BOX_TYPE, BOX_VIEW, BOX_CREATED_DATETIME, BOX_LAST_KEY, BOX_THINGTYPE_SCHEMA ) 
	VALUES (6, 'GUIDE', 'The Green Dodo Guides', 99, 'guide', NOW(), 0, 5); 
INSERT INTO BOX (BOX_ID, BOX_KEY, BOX_NAME, BOX_TYPE, BOX_VIEW, BOX_CREATED_DATETIME, BOX_LAST_KEY, BOX_THINGTYPE_SCHEMA ) 
	VALUES (7, 'MYWORLD', 'My World', 7, 'cards', NOW(), 0, 6); 

-- custom fields
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 1, 'Text','es.excentia.cf.text', 'text');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 2, 'Text large','es.excentia.cf.text-large', 'text-large');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 3, 'Select','es.excentia.cf.select', 'select');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 4, 'Radio','es.excentia.cf.radio', 'radio');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 5, 'Date','es.excentia.cf.date', 'date');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 6, 'Datetime','es.excentia.cf.datetime', 'datetime');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 7, 'Time','es.excentia.cf.time', 'time');

INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 8, 'Description','es.excentia.cf.text-large', 'text-large');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values ( 9, 'campo1','es.excentia.campo1', 'text');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values (10, 'campo2','es.excentia.campo2', 'text');
	
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values (20000, 'Name','es.excentia.cf.name', 'text');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values (20001, 'email','es.excentia.cf.email', 'text');
INSERT INTO CUSTOM_FIELD ( CFI_ID, CFI_NAME, CFI_KEY, CFI_TYPE ) values (20002, 'Mobile','es.excentia.cf.mobile', 'text');	

-- custom field values - options for select
INSERT INTO CUSTOM_FIELD_SELECT_OPTIONS ( CFO_ID, CFO_VALUE, CUSTOMFIELD_CFI_ID) values (1, 'opcion 1', 3);
INSERT INTO CUSTOM_FIELD_SELECT_OPTIONS ( CFO_ID, CFO_VALUE, CUSTOMFIELD_CFI_ID) values (2, 'opcion 2', 3);
INSERT INTO CUSTOM_FIELD_SELECT_OPTIONS ( CFO_ID, CFO_VALUE, CUSTOMFIELD_CFI_ID) values (3, 'opcion 3', 3);

-- Custom fields
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 1);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 2);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 3);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 4);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 5);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 6);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 7);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 8);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1, 9);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (1,10);

insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (2,1);
-- person
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (6,20000);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (6,20001);
insert into THING_TYPE_CUSTOMFIELD (THINGTYPE_TTY_ID, CUSTOMFIELD_CFI_ID) values (6,20002);

--https://www.browserling.com/tools/bcrypt
INSERT INTO USERS (ID, USERNAME, FULLNAME, EMAIL, PASSWORD) VALUES (1, 'admin', 'Admin User', 'admin@th1ngs.net', '$2a$10$hxnQfyiiTeR/E6w0tqFwCuRIKi06RIKvSSK5YEseC2V8j.Q6xFj.y');
INSERT INTO USERS (ID, USERNAME, FULLNAME, EMAIL, PASSWORD) VALUES (2, 'bruno', 'Bruno Lomas', 'setitup@yourdomain.com', '$2a$10$0/XuWB5ifzZasgwEz.NaJOXbqwPIm2A9JAmy6xQOPcHfzRVWwLXfC');  -- t0ledo

-- Things
--insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) 
--	values (NEXT VALUE FOR SEQ_THI_ID, 1, '1', 'Whatever you need', parsedatetime('13-10-2021 10:35:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);

insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) 
	values (next value for SEQ_THI_ID, 2, '1', 'Software bug', parsedatetime('13-10-2021 10:35:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 2, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) 
	values (next value for SEQ_THI_ID, 2, '2', 'New feature', parsedatetime('13-10-2021 10:35:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 3, 2);

insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) 
	values (next value for SEQ_THI_ID, 3, '1', 'Problem with report', parsedatetime('24-10-2021 10:35:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 4, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) 
	values (next value for SEQ_THI_ID, 3, '2', 'Need another laptop', parsedatetime('23-10-2021 10:35:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 5, 2);

insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '2', 'abc', parsedatetime('23-12-2021 10:35:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '3', 'def', parsedatetime('23-12-2021 10:36:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '4', 'ghi', parsedatetime('23-12-2021 10:37:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '5', 'jkl', parsedatetime('23-12-2021 10:38:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '6', 'mnñ', parsedatetime('23-12-2021 10:39:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '7', 'opq', parsedatetime('23-12-2021 10:40:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '8', 'rst', parsedatetime('23-12-2021 10:41:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '9', 'uwx', parsedatetime('23-12-2021 10:42:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '10', 'yz1', parsedatetime('23-12-2021 10:43:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '11', '234', parsedatetime('23-12-2021 10:44:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '12', '567', parsedatetime('23-12-2021 10:45:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '13', '890', parsedatetime('23-12-2021 10:46:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);

insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '14', cast (RANDOM_UUID() as VARCHAR), parsedatetime('24-12-2021 11:35:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '15', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:36:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '16', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:37:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '17', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:38:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '18', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:39:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '19', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:40:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '29', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:41:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '21', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:42:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '22', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:43:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);
insert into THING (THI_ID, BOX_BOX_ID, THI_KEY, THI_SUMMARY, THI_CREATED_DATETIME, THINGTYPE_TTY_ID,THI_CREATOR) values (next value for SEQ_THI_ID, 1, '23', cast (rand() as VARCHAR), parsedatetime('24-12-2021 11:44:24.00', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 2);


