CREATE TABLE IF NOT EXISTS campaigns (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200),
    sender_name VARCHAR(255),
    sender_email VARCHAR(255),
    body VARCHAR(255)
);
