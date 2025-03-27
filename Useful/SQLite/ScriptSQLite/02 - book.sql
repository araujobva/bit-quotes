CREATE TABLE IF NOT EXISTS book (
    bo_id INTEGER PRIMARY KEY AUTOINCREMENT,
    bo_name TEXT NOT NULL,
    bo_author TEXT NOT NULL,
    bo_photo BLOB,
    us_us_name TEXT NOT NULL,
    FOREIGN KEY (us_us_name)
        REFERENCES user (us_name)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
