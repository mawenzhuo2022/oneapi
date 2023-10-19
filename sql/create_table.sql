# 数据库初始化

-- 创建库
create database if not exists oneapi;

-- 切换库
use oneapi;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    `accessKey` varchar(512) not null comment 'accessKey',
    `secretKey` varchar(512) not null comment 'secretKey',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 接口信息
create table if not exists oneapi.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '名称',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `requestParams` text not null comment '请求参数',
    `requestHeader` text null comment '请求头',
    `responseHeader` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0-关闭，1-开启）',
    `method` varchar(256) not null comment '请求类型',
    `userId` bigint not null comment '创建人',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息';

-- 用户调用接口关系表
create table if not exists oneapi.`user_interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `userId` bigint not null comment '调用用户 id',
    `interfaceInfoId` bigint not null comment '接口 id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '0-正常，1-禁用',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户调用接口关系';


INSERT INTO oneapi.user (id, userName, userAccount, userAvatar, gender, userRole, userPassword, accessKey, secretKey, createTime, updateTime, isDelete) VALUES (1, null, 'admin', null, null, 'admin', 'b0dd3697a192885d7c055db46155b26a', '15d0c0568d9b3cbd0b3f12a7a58753ea', '0d27617e34b61fd39c46dd28db037a01', '2023-10-05 20:25:39', '2023-10-05 21:03:35', 0);
INSERT INTO oneapi.user (id, userName, userAccount, userAvatar, gender, userRole, userPassword, accessKey, secretKey, createTime, updateTime, isDelete) VALUES (2, null, 'user', null, null, 'user', 'b0dd3697a192885d7c055db46155b26a', '15d0c0568d9b3cbd0b3f12a7a58753ea', '0d27617e34b61fd39c46dd28db037a01', '2023-10-05 21:01:01', '2023-10-05 21:03:35', 0);
INSERT INTO oneapi.interface_info (id, name, description, url, requestParams, requestHeader, responseHeader, status, method, userId, createTime, updateTime, isDelete) VALUES (1, 'getMotivationalQuote', 'get motivational quote', 'http://localhost:8123/name/getMotivationalQuote', '-', '{"Content-Type":"text/xml"}', '{"Content-Type":"application/json"}', 1, 'GET', 1,'2023-10-07 20:41:24', '2023-10-18 20:00:06', 0);
INSERT INTO oneapi.interface_info (id, name, description, url, requestParams, requestHeader, responseHeader, status, method, userId, createTime, updateTime, isDelete) VALUES (2, 'getIPLocation', 'get IP location', 'http://localhost:8123/name/getIPLocation', 'city:String(eg:124.221.67.220)', '{"Content-Type":"text/xml"}', '{"Content-Type":"application/json"}', 1, 'GET', 1, '2023-10-07 20:43:13', '2023-10-18 20:04:41', 0);
INSERT INTO oneapi.interface_info (id, name, description, url, requestParams, requestHeader, responseHeader, status, method, userId, createTime, updateTime, isDelete) VALUES (3, 'getWorldTimeByCity', 'get world time of city', 'http://localhost:8123/name/getWorldTimeByCity', 'city:String(eg:new-york)', '{"Content-Type":"text/xml"}', '{"Content-Type":"application/json"}', 1, 'GET', 1, '2023-10-17 09:08:53', '2023-10-18 19:50:13', 0);
INSERT INTO oneapi.interface_info (id, name, description, url, requestParams, requestHeader, responseHeader, status, method, userId, createTime, updateTime, isDelete) VALUES (4, 'getUsernameByPost', 'get username', 'http://localhost:8123/name/user', '[{"name":"username","type":"string"}]', '{"Content-Type":"application/json"}', '{"Content-Type":"application/json"}', 1, 'POST', 1, '2023-10-17 20:38:00', '2023-10-17 21:31:53', 0);
INSERT INTO oneapi.interface_info (id, name, description, url, requestParams, requestHeader, responseHeader, status, method, userId, createTime, updateTime, isDelete) VALUES (5, 'Xchanger', 'exchange covert', 'http://localhost:8123/name/Xchanger', 'scur:String,tcur:String(eg:usd,cny)', '{"Content-Type":"text/xml"}', '{"Content-Type":"application/json"}', 1, 'GET', 1, '2023-10-18 18:25:35', '2023-10-18 19:50:13', 0);
INSERT INTO oneapi.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (1, 2, 1, 50, 34, 0, '2023-10-05 21:00:15', '2023-10-07 20:43:45', 0);
INSERT INTO oneapi.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (2, 2, 2, 50, 44, 0, '2023-10-05 21:00:15', '2023-10-07 20:43:45', 0);
INSERT INTO oneapi.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (3, 2, 3, 50, 45, 0, '2023-10-05 21:00:15', '2023-10-07 20:43:45', 0);
INSERT INTO oneapi.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (4, 2, 4, 50, 14, 0, '2023-10-05 21:00:15', '2023-10-07 20:43:45', 0);
INSERT INTO oneapi.user_interface_info (id, userId, interfaceInfoId, totalNum, leftNum, status, createTime, updateTime, isDelete) VALUES (5, 2, 5, 50, 25, 0, '2023-10-05 21:00:15', '2023-10-07 20:43:45', 0);