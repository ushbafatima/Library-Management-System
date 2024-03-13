CREATE TABLE `student` (
  `studentName` varchar(30) DEFAULT NULL,
  `studentID` varchar(20) NOT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `course` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
