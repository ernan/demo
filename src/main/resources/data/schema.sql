DROP TABLE Individual IF EXISTS;

CREATE TABLE INDIVIDUAL (
	ID BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) NOT NULL,
	NAME VARCHAR(255) NOT NULL,
	DATE_OF_BIRTH DATE NOT NULL,
	MOBILE_PHONE VARCHAR(25) NOT NULL,
	SSN VARCHAR(25) NOT NULL,
	UNIQUE (SSN)
)
