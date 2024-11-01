drop database if EXISTS ssafit;
create database ssafit;
use ssafit;

CREATE TABLE `User` (
	`userId` varchar(50) primary key NOT NULL,
	`userPassword`	varchar(255) NOT NULL
);

CREATE TABLE `Video` (
	`videoId` int AUTO_INCREMENT primary key NOT NULL,
	`title`	varchar(255) NOT NULL,
	`part`	varchar(255),
	`channelName`	varchar(255) NOT NULL,
	`viewCnt`	int	DEFAULT 0,
	`regDate`	timestamp default now(),
	`url`	varchar(255) NOT NULL
);

CREATE TABLE `Review` (
	`reviewId`	int	AUTO_INCREMENT primary key NOT NULL,
	`userId`	varchar(50) NOT NULL,
	`videoId`	int	NOT NULL,
	`content`	varchar(255) NOT NULL,
	`regDate`	timestamp default now(),
    FOREIGN KEY (userId) REFERENCES User(userId) ON UPDATE CASCADE,
    FOREIGN KEY (videoId) REFERENCES Video(videoId) ON UPDATE CASCADE
);

INSERT INTO Video (title, part, channelName, viewCnt, url)
VALUES 
    ('Introduction to Java', 'Java Basics', 'CodeAcademy', 150, 'https://www.example.com/video1'),
    ('Spring Boot Tutorial', 'Spring Framework', 'TechSavvy', 230, 'https://www.example.com/video2'),
    ('Understanding Databases', 'Database', 'DBMaster', 90, 'https://www.example.com/video3'),
    ('JavaScript for Beginners', 'JavaScript Basics', 'WebDev101', 500, 'https://www.example.com/video4'),
    ('Python Data Analysis', 'Python', 'DataWiz', 320, 'https://www.example.com/video5'),
    ('React Crash Course', 'Frontend', 'FrontendExpert', 670, 'https://www.example.com/video6'),
    ('Machine Learning Basics', 'AI/ML', 'AIBuddy', 400, 'https://www.example.com/video7'),
    ('CSS Flexbox Guide', 'CSS', 'DesignSchool', 240, 'https://www.example.com/video8'),
    ('REST API with Spring', 'Spring Boot', 'CodeAcademy', 190, 'https://www.example.com/video9'),
    ('Docker for Developers', 'DevOps', 'DevOpsHub', 310, 'https://www.example.com/video10');

 

