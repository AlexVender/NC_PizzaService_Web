PROMPT measurement_units...
DECLARE --CREATE OR REPLACE
nCount NUMBER;
BEGIN
SELECT COUNT(*)
  INTO nCount
  FROM USER_TABLES
  WHERE TABLE_NAME = 'MEASUREMENT_UNITS';

IF nCount <> 0 THEN
  EXECUTE IMMEDIATE 'DROP TABLE MEASUREMENT_UNITS CASCADE CONSTRAINTS';
END IF;

EXECUTE IMMEDIATE 'CREATE TABLE MEASUREMENT_UNITS(
msru_id NUMBER(10),
title VARCHAR2(100 CHAR),
CONSTRAINT msru_id_pk PRIMARY KEY (msru_id))';

nCount:=0;--sequence and trigger for primary key
SELECT COUNT(*)
  INTO nCount
  FROM USER_SEQUENCES
  WHERE SEQUENCE_NAME = 'MSRU_SEQ';

IF nCount <> 0 THEN
  EXECUTE IMMEDIATE 'DROP SEQUENCE MSRU_SEQ';
END IF;

EXECUTE IMMEDIATE 'CREATE SEQUENCE MSRU_SEQ
START WITH 1
INCREMENT BY 1
NOMAXVALUE';

EXECUTE IMMEDIATE 'CREATE OR REPLACE TRIGGER msru_id_trg
BEFORE INSERT ON measurement_units
FOR EACH ROW
BEGIN
  IF :new.msru_id IS NULL THEN
    SELECT msru_seq.nextval INTO :new.msru_id FROM dual;
  END IF;
END;';
END;
/