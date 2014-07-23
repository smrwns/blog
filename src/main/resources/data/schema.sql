






-- #sample --
CREATE TABLE MEMBER (
    s_id varchar(36) NOT NULL,
    s_passwd varchar(45) NOT NULL,
    s_name varchar(45) NOT NULL,
    s_nick varchar(45) NOT NULL,
    s_type varchar(45) NOT NULL,
    s_group varchar(45) NULL,
    s_email varchar(45) NOT NULL,
    PRIMARY KEY (s_id)
);