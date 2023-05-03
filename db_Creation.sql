CREATE DATABASE productbacklog;
SHOW DATABASES;
USE productbacklog;
CREATE TABLE EPICs (
Id INT(10) PRIMARY KEY,
ProjectCode INT(10),
SprintId INT(10),
Name VARCHAR(50) NOT NULL,
CreatedOn DATE,
CompletedOn DATE,
Status VARCHAR(20) DEFAULT 'InProgress' CHECK (Status IN ('InProgress', 'Done'))
);
CREATE TABLE UserStories (
Id INT(10) PRIMARY KEY, 
Title VARCHAR(100) NOT NULL,
UserStoryDetails VARCHAR(1000) NOT NULL,
AcceptanceCriteria VARCHAR(1000),
Priority VARCHAR(2),
CreatedOn DATE,
DoneOn DATE,
AssignedToDeveloperId VARCHAR(6),
StoryPoints INT(10) CHECK (StoryPoints BETWEEN 1 AND 20),
Status VARCHAR(20) DEFAULT 'New' CHECK (Status IN ('New', 'Planning', 'Coding', 'Testing', 'Done')),
EpicId INT(10),
FOREIGN KEY (EpicId) REFERENCES EPICs(Id)
);
SELECT * FROM productbacklog.epic;
SELECT * FROM productbacklog.user_story;