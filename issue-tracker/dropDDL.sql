ALTER TABLE BUG DROP CONSTRAINT FK_BUG_ISSUE_ID;
ALTER TABLE STORY DROP CONSTRAINT FK_STORY_ISSUE_ID;
DROP TABLE DEVELOPER;
DROP TABLE ISSUE;
DROP TABLE BUG;
DROP TABLE STORY;
DROP TABLE SEQUENCE;