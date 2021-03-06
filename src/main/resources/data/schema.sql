/** sample **/
CREATE TABLE MEMBER (
    ID LONG NOT NULL,
    USERNAME varchar(45) NOT NULL,
    PASSWORD varchar(45) NOT NULL,
    NAME varchar(45) NOT NULL,
    EMAIL varchar(45) NOT NULL,
    REGISTERED DATE NOT NULL,
    PRIMARY KEY (ID)
);
insert into MEMBER (ID, USERNAME, PASSWORD, NAME, EMAIL, REGISTERED) values('1', 'smrwns', '1234', '최성균', 'smrwns@naver.com', '2014-08-17');

-- social connection --
create table UserConnection (userId varchar(255) not null,
    providerId varchar(255) not null,
    providerUserId varchar(255),
    rank int not null,
    displayName varchar(255),
    profileUrl varchar(512),
    imageUrl varchar(512),
    accessToken varchar(255) not null,                  
    secret varchar(255),
    refreshToken varchar(255),
    expireTime bigint,
    primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

-- #ordinary --
/*CREATE TABLE USERS (
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
*/