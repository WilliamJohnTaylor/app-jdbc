create or replace
PROCEDURE update_status(code MEMBRES.code_membre%TYPE)
IS
  v_status membres.status%TYPE;
BEGIN
 
 SELECT status INTO v_status
 FROM membres
 WHERE code_membre = code;
 
 IF v_status <> 'REGULIER' THEN
  UPDATE membres 
  SET status = 'REGULIER'
  WHERE code_membre = code;
 END IF; 
END;
