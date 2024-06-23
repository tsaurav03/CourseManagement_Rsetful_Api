 Write a Spring Boot REST application which will provide following CRUD operations for 
“Student” and “Course” resource offered by Educational Institute. 
1. Add new Course 
2. Update Course Details (Start Date, End Date & Fee can be updated) 
3. Fetch all courses matched by given Course Name 
4. Fetch all students for given Course Name


   
 
Course has the following attributes:  
1. ID (unique identifier for each Course, auto generated, starts from 1) 
2. Name (Cannot be Blank, Example : JAVA01, JAVA02, WEBJAVA01, WEBJAVA02) 
3. Category (Enum, Example: JAVA-BEGINER, JAVA-ADVANCED) 
4. Start Date (Cannot be Blank) 
5. End Date (Cannot be Blank) 
6. Fee (Cannot be Blank) 
7. Grade to Pass (Cannot be Blank)

   
 
Student has the following attributes: (Enter Sample data in Database) 
1. Sid (unique identifier for each Student) 
2. Sname (Cannot be Blank) 
3. Email (Cannot be Blank) 
4. Password (Cannot be Blank) 
5. Cid (Course ID, FK)

   
 
• Use MySQL Relational Database to save resource. 
• Create payload will have fields like – Name, Category, Start Date, End Date, Fee 
• “ID (auto generated) & Grade to Pass” will be populated by the service layer. 
• There should be Validation on Create & Update Payload. 
For example:  
1) End Date cannot be before Start Date. 
2) Name should not be blank. 
3) None of the fields in Course table is Nullable. 
• Rest URL should be named as per REST best practices. 
• Response codes should be as per REST guidelines 
(201 for resource creation, 404 for not found, 200 for ok) 
• Error handling in case of failures. (Optional : Global Exceptional Handling) 
Note:- You have to test all API's on Postman/Swagger 
