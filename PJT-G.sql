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
	`chnnelName`	varchar(255) NOT NULL,
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

