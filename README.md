# EmployeeProject
# Project Overview
An application to read .csv files, remove invalid or duplicate entries using the employee id, and write it to an SQL database.

Project Overview
CSV2SQL implements several useful features. It reads entries from a .csv file into the program's memory, and can remove invalid or duplicate entries using the employee id. After this, it generates SQL statements to push this data to a local SQL database. Other features of the program include a console UI, where the user can enter the specific .csv file they want to convert. The program will inform the user at every stage of the application process as to what is happening. This includes useful information such as the location of the file being read, the location where invalid records are written to for checking, and the time taken for all operations in the program. When writing to the SQL database. The application has the ability to use multiple threads which needs to be implimented and a features which will be added in future.

Application Walkthrough
EmployeeProject includes a console UI. Upon launching the application. The user can add their own .csv files simply by placing them in the project's resources folder. After putting a .csv file, the program will perform the rest of the operations automatically. First, the .csv file is read in entirety. After this, the .csv file is cleaned and duplicate or invalid records are removed. The removed records are stored in the resources file as .csv files for the user to manually check if they desire. Next, the program checks the cleaned records to add against the records in the database. After this, the records are pushed to the database, and the program ends.
 # To run
 Add the files to your choice of IDE, and run the class called App.java. It will run on a deafult file allready added to the resourses folder which can be changed by the user.
