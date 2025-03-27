CREATE TABLE IF NOT EXISTS quote (
    qu_id INTEGER PRIMARY KEY AUTOINCREMENT,
    qu_quote TEXT NOT NULL,
    qu_book_page TEXT NOT NULL,
    bo_id INTEGER NOT NULL,
    us_name TEXT NOT NULL,
    FOREIGN KEY (bo_id)
        REFERENCES book (bo_id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (us_name)
        REFERENCES user (us_name)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
