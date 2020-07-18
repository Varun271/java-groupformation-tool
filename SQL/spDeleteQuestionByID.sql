DELIMITER $$

DROP PROCEDURE IF EXISTS spDeleteQuestionByID $$

CREATE PROCEDURE spDeleteQuestionByID (
	IN id BIGINT
)
BEGIN
	DELETE
	FROM QuestionBank
    WHERE QuestionBank.id = id;
END $$

DELIMITER ;