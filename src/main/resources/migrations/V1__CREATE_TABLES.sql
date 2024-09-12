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
    book_id bigint NOT NULL,
    member_id bigint NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    status VARCHAR(20) NOT NULL
--    FOREIGN KEY (book_id) REFERENCES Book(id),
--    FOREIGN KEY (member_id) REFERENCES Member(id)
);

CREATE TABLE Reservation (
    id SERIAL PRIMARY KEY,
    book_id bigint NOT NULL,
    member_id bigint NOT NULL,
    reservation_date DATE,
    status VARCHAR(20) NOT NULL
--    FOREIGN KEY (book_id) REFERENCES Book(id),
--    FOREIGN KEY (member_id) REFERENCES Member(id)
);

CREATE TABLE User (
    ID SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role VARCHAR(10) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    endereco VARCHAR(30) NOT NULL,
    telefone VARCHAR(20),
    estado VARCHAR(2)
);

CREATE TABLE Roles (
    ID SERIAL PRIMARY KEY,
    role VARCHAR(20)
);