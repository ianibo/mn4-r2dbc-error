CREATE TABLE agency (
        id uuid PRIMARY KEY,
        code varchar(32),
        name varchar(200),
        host_lms_id uuid,
        auth_profile varchar(64),
        idp_url varchar(64)
);      
