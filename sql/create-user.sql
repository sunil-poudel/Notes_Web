DROP USER IF EXISTS 'notesweb'@'%';

CREATE USER 'notesweb'@'%' IDENTIFIED BY 'notesWeb@$90';

GRANT ALL PRIVILEGES ON * . * TO 'notesweb'@'%';
