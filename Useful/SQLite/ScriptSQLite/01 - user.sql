CREATE TABLE IF NOT EXISTS user (
    us_name TEXT NOT NULL,
    us_password TEXT NOT NULL,
    us_administrator INTEGER NOT NULL,
    PRIMARY KEY (us_name)
);
