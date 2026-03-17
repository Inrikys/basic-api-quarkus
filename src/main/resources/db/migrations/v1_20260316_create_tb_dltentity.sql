CREATE TABLE DLT_ENTITY (
    id VARCHAR(255) PRIMARY KEY,
    topic VARCHAR(255),
    partition INTEGER,
    offset BIGINT,
    key VARCHAR(255),
    payload TEXT,
    headers TEXT,
    exception TEXT,
    creation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);