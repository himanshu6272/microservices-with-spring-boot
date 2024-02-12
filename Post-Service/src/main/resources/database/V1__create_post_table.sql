CREATE TABLE IF NOT EXISTS post (
                                            post_id VARCHAR(100) PRIMARY KEY,
                                            user_id VARCHAR(100) NOT NULL,
                                            description VARCHAR(1000) NOT NULL
                                        );