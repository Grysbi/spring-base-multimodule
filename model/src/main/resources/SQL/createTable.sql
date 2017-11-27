#### Database
CREATE DATABASE spring_base;
USE spring_base;

#### Table
# Users
DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
  users_id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(50),
  password VARCHAR(64),
  PRIMARY KEY (users_id)
);

# Roles
DROP TABLE IF EXISTS roles;
CREATE TABLE IF NOT EXISTS roles (
  roles_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR (20),
  PRIMARY KEY (roles_id)
);

# Users_Roles
DROP TABLE IF EXISTS users_roles;
CREATE TABLE IF NOT EXISTS users_roles (
  users_roles_id INT NOT NULL AUTO_INCREMENT,
  users_id INT (11),
  roles_id INT (11),
  PRIMARY KEY (users_roles_id)
);

#### Foreign Key
ALTER TABLE users_roles ADD FOREIGN KEY (users_id) REFERENCES users(users_id) ON DELETE CASCADE;
ALTER TABLE users_roles ADD FOREIGN KEY (roles_id) REFERENCES roles(roles_id) ON DELETE CASCADE;

#### Index
ALTER TABLE users ADD INDEX idx_users_id (users_id);
ALTER TABLE roles ADD INDEX idx_roles_id (roles_id);
ALTER TABLE users_roles ADD INDEX idx_users_roles_id (users_roles_id);

#### Insert
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_GUEST');
INSERT INTO roles (name) VALUES ('ROLE_USER');

#### Insert test
# admin / admin
INSERT INTO users (login, password) VALUES ("admin", "$2a$10$FN1LMKjPU46aPffh9Zaw4exJOLo51JJPWrxqzak/eJrbt3CO9WzVG");
# guest / guest
INSERT INTO users (login, password) VALUES ("guest", "$2a$10$KqymZoQFZRmO.dQpdXDfo.B9r28Fv4xLHERKav.Dp9yqEvAvhdLP6");
# user / user
INSERT INTO users (login, password) VALUES ("user", "$2a$10$97rfJAU6Jjdm0Arxat1zG.X0ScYLQACFjnAMOKpRTQ03FhYZLF9me");

INSERT INTO users_roles (users_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (users_id, roles_id) VALUES (2, 2);
INSERT INTO users_roles (users_id, roles_id) VALUES (3, 3);