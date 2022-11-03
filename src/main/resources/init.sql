CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE jobs(
                     uuid uuid default uuid_generate_v4(),
                     post varchar,
                     company varchar,
                     salary numeric
);

INSERT INTO jobs(post, company, salary) VALUES
    ('CEO', 'GOOGLE', 700000);