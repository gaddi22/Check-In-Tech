CREATE DEFINER=`root`@`localhost` PROCEDURE `checkInMobile`(IN targetAttendee VARCHAR(10),IN targetEventID VARCHAR(10),IN signInMethod VARCHAR(6),IN inMAC VARCHAR(12))
BEGIN

declare isCheck TINYINT;
declare dur time;
declare firstc DATETIME;
declare lastc DATETIME;

SET dur = (SELECT Duration FROM event WHERE ID = targetEventID),
	firstc = (select FirstCheck FROM attends WHERE AttID = targetAttendee AND EventID = targetEventID),
	lastc = current_timestamp();

IF (abs( firstc - lastc) >= dur) THEN
	set isCheck = 1;
ELSE set isCheck = 0;
END IF;

UPDATE attends 
	SET LastCheck = current_timestamp(),
	HasAttended = isCheck
	WHERE AttID = targetAttendee AND
	EventID = targetEventID;
    
IF (firstc IS NULL) THEN
	UPDATE attends 
		SET 
        FirstCheck = current_timestamp(),
        LastCheck = current_timestamp(),
        HasAttended = 0, 
        SignMethod = signInMethod,
        MAC = inMAC
        WHERE AttID = targetAttendee AND
        EventID = targetEventID;
END IF;
END