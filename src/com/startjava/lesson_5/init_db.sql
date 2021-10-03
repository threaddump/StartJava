-- Урок 5, часть 5
-- 
-- Заполните таблицу данными:
--     занесите информацию о 10 роботах (если каких-то данных будет не хватать — придумайте их самостоятельно)
--     данные о роботах берите тут: https://pacificrim.fandom.com/wiki/Category:Jaegers
--     SQL-код размещайте в файле init_db.sql

INSERT INTO Jaegers(modelName, mark, height, weight,
    status, origin, launch, kaijuKill) VALUES
    ('Gipsy Danger', 'Mark-3', '79.25', '1.980', 'DSTR', 'USA', '2017-07-10', '9'),
    ('Striker Eureka', 'Mark-5', '76.2', '1.850', 'DSTR', 'Australia', '2019-11-02', '11'),
    ('Cherno Alpha', 'Mark-1', '85.34', '2.412', 'DSTR', 'Russia', '2015-06-10', '6'),
    ('Gipsy Avenger', 'Mark-6', '81.77', '2.004', 'DSTR', 'USA', '2034-01-12', '1'),
    ('Obsidian Fury', 'Mark-6', '82.4', '2.213', 'DSTR', 'China', '2018-09-30', '5'),
    ('Coyote Tango', 'Mark-1', '85.34', '2.312', 'DSTR', 'Japan', '2015-12-30', '2'),
    ('Crimson Typhoon', 'Mark-4', '76.2', '1.722', 'DSTR', 'China', '2018-08-22', '7'),
    ('Brawler Yukon', 'Mark-1', '86.16', '2.350', 'DSTR', 'USA', '2015-01-30', '2'),
    ('Horizon Brave', 'Mark-1', '72.54', '7.890', 'DSTR', 'China', '2015-12-22', '2'),
    ('Tacit Ronin', 'Mark-1', '74.37', '7.450', 'DSTR', 'Japan', '2015-12-06', '3');