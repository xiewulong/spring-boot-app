CREATE TABLE `t_users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(32) NULL COMMENT '名字',
  `age` int(4) NULL COMMENT '年龄',
  `created_at` datetime NULL COMMENT '创建时间',
  `updated_at` datetime NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
);

INSERT INTO `t_users` (`name`, `age`, `created_at`, `updated_at`)
VALUES ('A', 18, NOW(), NOW())
     , ('B', 19, NOW(), NOW())
     ;