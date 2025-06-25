CREATE TABLE branch (
  branchId INT PRIMARY KEY,
  b_name VARCHAR(50),
  b_city VARCHAR(50),
  b_assets DECIMAL(15, 2)
);

CREATE TABLE account (
  accountNo INT PRIMARY KEY,
  balance DECIMAL(12, 2),
  branchId INT,
  FOREIGN KEY (branchId) REFERENCES branch(branchId)
);

CREATE TABLE customer (
  customerId INT PRIMARY KEY,
  c_name VARCHAR(50),
  c_city VARCHAR(50),
  c_street VARCHAR(100)
);

CREATE TABLE deposit (
  customerId INT,
  accountNo INT,
  PRIMARY KEY (customerId, accountNo),
  FOREIGN KEY (customerId) REFERENCES customer(customerId),
  FOREIGN KEY (accountNo) REFERENCES account(accountNo)
);

CREATE TABLE loan (
  loanNo INT PRIMARY KEY,
  amount DECIMAL(12, 2),
  branchId INT,
  FOREIGN KEY (branchId) REFERENCES branch(branchId)
);

CREATE TABLE borrower (
  customerId INT,
  loanNo INT,
  PRIMARY KEY (customerId, loanNo),
  FOREIGN KEY (customerId) REFERENCES customer(customerId),
  FOREIGN KEY (loanNo) REFERENCES loan(loanNo)
);
