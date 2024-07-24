-- Create the Book table
CREATE TABLE Book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn INT NOT NULL,
    published_date DATE,
    genre VARCHAR(100),
    quantity INT NOT NULL
);

-- Create the Member table
CREATE TABLE Member (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    member_ship DATE NOT NULL
);

-- Create the Loan table
CREATE TABLE Loan (
    ID SERIAL PRIMARY KEY,
    book_id UUID NOT NULL,
    member_id UUID NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (book_id) REFERENCES Book(id),
    FOREIGN KEY (member_id) REFERENCES Member(id)
);