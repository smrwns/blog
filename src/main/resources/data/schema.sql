-- #ordinary --
CREATE TABLE USERS (
    ID BIGINT(20) NOT NULL AUTO_INCREMENT,
    USER_LOGIN VARCHAR(60) NOT NULL,
    USER_PASS VARCHAR(64) NOT NULL,
    USER_NAME VARCHAR(50) NOT NULL,
    USER_EMAIL VARCHAR(100) NOT NULL,
    USER_URL VARCHAR(100),
    USER_REGISTERED DATETIME NOT NULL,
    USER_ACTIVATION_KEY VARCHAR(60),
    USER_STATUS INT(11) NOT NULL,
    DISPLAY_NAME VARCHAR(250) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE USERMETA (
    UMETA_ID BIGINT(20) NOT NULL AUTO_INCREMENT,
    USER_ID INT(20) NOT NULL,
    META_KEY VARCHAR(255),
    META_VALUE TEXT, 
    PRIMARY KEY(UMETA_ID),
    FOREIGN KEY(USER_ID) REFERENCES USERS(ID)
);

CREATE TABLE POSTS (
    ID BIGINT(20) NOT NULL AUTO_INCREMENT,
    POST_AUTHOR BIGINT(20),
    POST_DATE DATETIME,
    -- ..ing --
    PRIMARY KEY(ID),
    FOREIGN KEY(POST_AUTHOR) REFERENCES USERS(ID)
);





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
insert into MEMBER (s_id, s_passwd, s_name, s_nick, s_type, s_group, s_email) values('smrwns', '1234', '최성균', '에세마', '1', 'non', 'smrwns@naver.com');