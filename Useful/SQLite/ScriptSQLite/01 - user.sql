CREATE TABLE IF NOT EXISTS user (
    us_name TEXT NOT NULL,
    us_password TEXT NOT NULL,
    us_administrator INTEGER NOT NULL,
    us_permission_to_delete_user INTEGER NOT NULL DEFAULT 1,
    PRIMARY KEY (us_name)
);
