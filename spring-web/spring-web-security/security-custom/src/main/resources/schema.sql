CREATE TABLE `user` (
  `id`       INT(11)      NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(64)  NOT NULL,
  `password` VARCHAR(128) NOT NULL,
  `email`    VARCHAR(32)  NULL     DEFAULT NULL,
  `enabled`  TINYINT(1)   NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username` (`username`)
);
CREATE TABLE `role` (
  `id`      INT(11)     NOT NULL AUTO_INCREMENT,
  `name`    VARCHAR(32) NOT NULL,
  `enabled` TINYINT(1)  NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
);
CREATE TABLE `permission` (
  `id`        INT(11)      NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(128) NOT NULL,
  `name`      VARCHAR(128) NULL     DEFAULT NULL,
  `enabled`   TINYINT(1)   NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_role` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`)
);
CREATE TABLE `role_permission` (
  `role_id`       INT(11) NOT NULL,
  `permission_id` INT(11) NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`)
);

INSERT INTO `user` (`username`, `password`) VALUES ('user', '123456');
INSERT INTO `user` (`username`, `password`) VALUES ('admin', 'admin123');

INSERT INTO `role` (`name`) VALUES ('用户');
INSERT INTO `role` (`name`) VALUES ('站长');

INSERT INTO `permission` (`authority`, `name`) VALUES ('HOME_VIEW', '首页访问');
INSERT INTO `permission` (`authority`, `name`) VALUES ('ADMIN_VIEW', '后台访问');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (2, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (2, 2);

INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (1, 1);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (2, 1);
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES (2, 2);