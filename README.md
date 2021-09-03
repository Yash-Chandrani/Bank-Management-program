# Bank-Management-program
I made a bank management system in core java for my end semester project for the subject of Core Java Programming(CJP).

How to run the project:

Extract the zip file and open it in your ide.

Run the following query in you MySQL in a database named test(create a test named database):

CREATE TABLE BankingUsers (
    id int(6) auto_increment primary key not null,
    email varchar(30) NOT NULL,
    password varchar(30) NOT NULL,
    balance float(15,5) NOT NULL,
    Name varchar(30) NOT NULL
);

Now you can run the program
