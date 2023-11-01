CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       budget DECIMAL(10,2) NOT NULL
);

CREATE TABLE pet (
                      pet_id SERIAL PRIMARY KEY,
                      owner_id INT REFERENCES users(user_id),
                      name VARCHAR(255) NOT NULL,
                      type VARCHAR(255) NOT NULL,
                      description TEXT,
                      date_of_birth DATE NOT NULL,
                      price DECIMAL(10,2),
                      rating INT
);

CREATE TABLE buy_history (
                            history_log_id SERIAL PRIMARY KEY,
                            execution_date TIMESTAMP,
                            successful_buys INT,
                            unsuccessful_buys INT
);