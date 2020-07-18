DELIMITER $$

DROP PROCEDURE IF EXISTS spInsertQuestion $$

CREATE PROCEDURE spInsertQuestion (
	IN title VARCHAR(200),
	IN text VARCHAR(200),
	IN question_type_name VARCHAR(200),
	IN questionOption VARCHAR(200),
	IN questionValue VARCHAR(200)
)
BEGIN
    SELECT questiontypeID
    INTO @q
    FROM QuestionType
    WHERE QuestionType.questionType = question_type_name;
	INSERT INTO QuestionBank(questionTitle, questionText, questiontypeID, questionOption, questionValue)
    VALUES (title,text,@q,questionOption,questionValue);
END $$

DELIMITER ;