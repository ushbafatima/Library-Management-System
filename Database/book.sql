CREATE TABLE `book` (
  `bookTitle` varchar(50) DEFAULT NULL,
  `bookID` varchar(20) NOT NULL,
  `author` varchar(50) DEFAULT NULL,
  `genre` varchar(30) DEFAULT NULL,
  `availability` varchar(20) DEFAULT NULL,
  `issueDate` varchar(60) DEFAULT NULL,
  `dueDate` varchar(60) DEFAULT NULL,
  `studentID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
