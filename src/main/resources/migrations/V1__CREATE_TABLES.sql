-- Create the Book table
CREATE TABLE Book (
    ID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255) NOT NULL,
    ISBN INT NOT NULL,
    PublishedDate DATE,
    Genre VARCHAR(100),
    Quantity INT NOT NULL
);

-- Create the Member table
CREATE TABLE Member (
    ID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    MembershipDate DATE NOT NULL
);

-- Create the Loan table
CREATE TABLE Loan (
    ID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    BookID UUID NOT NULL,
    MemberID UUID NOT NULL,
    LoanDate DATE NOT NULL,
    ReturnDate DATE,
    Status VARCHAR(20) NOT NULL,
    FOREIGN KEY (BookID) REFERENCES Book(ID),
    FOREIGN KEY (MemberID) REFERENCES Member(ID)
);