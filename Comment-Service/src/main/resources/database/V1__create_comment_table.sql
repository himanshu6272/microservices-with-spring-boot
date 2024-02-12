CREATE TABLE IF NOT EXISTS comment (
                                            comment_id VARCHAR(100) PRIMARY KEY,
                                            user_id VARCHAR(100) NOT NULL,
                                            post_id VARCHAR(100) NOT NULL,
                                            description VARCHAR(1000) NOT NULL
                                        );