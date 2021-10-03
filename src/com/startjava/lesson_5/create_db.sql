-- Урок 5, часть 5
-- 
-- Создайте базу данных и таблицу под название Jaegers:
--     названия столбцов: id, modelName, mark, height, weight, status, origin, launch, kaijuKill
--     SQL-код размещайте в файле create_db.sql

CREATE DATABASE jaegers WITH ENCODING = 'UTF8';

\c jaegers;

CREATE TABLE Jaegers (
    id SERIAL PRIMARY KEY,
    modelName TEXT,
    mark TEXT,
    height REAL,
    weight REAL,
    status CHAR(4),
    origin TEXT,
    launch DATE,
    kaijuKill INTEGER
    );