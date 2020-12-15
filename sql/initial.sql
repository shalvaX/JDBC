CREATE TABLE employee (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100),
    surname VARCHAR(100),
    gender VARCHAR(100),
    alive BOOLEAN DEFAULT true,
    p_id VARCHAR(11) NOT NULL
);
