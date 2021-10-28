CREATE TABLE IF NOT EXISTS post (
   id SERIAL PRIMARY KEY,
   name TEXT
);

CREATE TABLE IF NOT EXISTS candidates (
   id SERIAL PRIMARY KEY,
   name TEXT,
   city_id int references cities(id)
);

CREATE TABLE IF NOT EXISTS users (
   id SERIAL PRIMARY KEY,
   name TEXT,
   email TEXT,
   password TEXT
);

CREATE TABLE IF NOT EXISTS cities (
   id SERIAL PRIMARY KEY,
   city TEXT
);

ALTER TABLE users ADD UNIQUE(email);

ALTER TABLE candidates ADD COLUMN city_id int references cities(id);

ALTER TABLE post ADD COLUMN created timestamp;

ALTER TABLE post ADD COLUMN description TEXT;

ALTER TABLE candidates ADD COLUMN created timestamp;

INSERT INTO cities (city) VALUES ('Москва');
INSERT INTO cities (city) VALUES ('Санкт-Петербург');
INSERT INTO cities (city) VALUES ('Новосибирск');
INSERT INTO cities (city) VALUES ('Екатеринбург');
INSERT INTO cities (city) VALUES ('Казань');
INSERT INTO cities (city) VALUES ('Нижний Новгород');
INSERT INTO cities (city) VALUES ('Челябинск');
INSERT INTO cities (city) VALUES ('Омск');
INSERT INTO cities (city) VALUES ('Самара');
INSERT INTO cities (city) VALUES ('Ростов-на-Дону');
INSERT INTO cities (city) VALUES ('Уфа');
INSERT INTO cities (city) VALUES ('Красноярск');
INSERT INTO cities (city) VALUES ('Пермь');
INSERT INTO cities (city) VALUES ('Воронеж');
INSERT INTO cities (city) VALUES ('Волгоград');
