CREATE TABLE plc_config_version(
    id BIGINT NOT NULL   COMMENT 'ID' ,
    sub_type_id INT    COMMENT '设备子类型 汉堡机、煎炸机' ,
    name VARCHAR(32)    COMMENT 'PLC版本名称 v1.0,v1.2,v.20' ,
    enabled TINYINT    COMMENT '是否启用 1:是，0:否' ,
    created_by BIGINT    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_by BIGINT    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    deleted TINYINT    COMMENT '删除标志' ,
    PRIMARY KEY (id)
) COMMENT = 'PLC配置版本 ';;

CREATE TABLE plc(
    id BIGINT NOT NULL   COMMENT 'ID' ,
    code INT    COMMENT '编号 PLC实际ID' ,
    config_version_id BIGINT    COMMENT '配置版本ID' ,
    name VARCHAR(32)    COMMENT '名称' ,
    ip VARCHAR(32)    COMMENT 'IP' ,
    port INT    COMMENT '端口' ,
    protocol_id INT    COMMENT '协议类型 枚举' ,
    type_id INT    COMMENT '类型 枚举' ,
    big_endian TINYINT    COMMENT '是否大端 1:是，0:否' ,
    created_by BIGINT    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_by BIGINT    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    deleted TINYINT    COMMENT '删除标志' ,
    PRIMARY KEY (id)
) COMMENT = 'PLC ';;

CREATE TABLE plc_data_model(
    id BIGINT NOT NULL   COMMENT 'ID' ,
    component_id BIGINT    COMMENT '部件ID' ,
    parent_id BIGINT    COMMENT '父ID' ,
    third_party_id VARCHAR(32)    COMMENT '第三方ID 与设备管理系统交互使用' ,
    code INT    COMMENT '编号' ,
    name VARCHAR(64)    COMMENT '名称' ,
    address VARCHAR(64)    COMMENT '地址 非连续块时可空' ,
    data_type_id INT    COMMENT '数据类型 (枚举)数据类型与长度不能同时为空' ,
    length INT    COMMENT '长度 数据类型与长度不能同时为空' ,
    sort INT    COMMENT '解析顺序' ,
    continuous TINYINT    COMMENT '是否连续块 1:是，0:否' ,
    acquisition TINYINT    COMMENT '是否采集 1:是，0:否' ,
    created_by BIGINT    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_by BIGINT    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    deleted TINYINT    COMMENT '删除标志' ,
    PRIMARY KEY (id)
) COMMENT = 'PLC数据模型 ';;

CREATE TABLE plc_alarm(
    id BIGINT NOT NULL   COMMENT 'ID' ,
    component_id BIGINT    COMMENT '部件ID' ,
    data_model_id BIGINT    COMMENT '数据模型ID' ,
    code INT    COMMENT '编号' ,
    alarm_value VARCHAR(32)    COMMENT '告警值' ,
    message VARCHAR(256)    COMMENT '告警信息' ,
    alarm_level INT    COMMENT '告警级别 是否枚举？' ,
    created_by BIGINT    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_by BIGINT    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    deleted TINYINT    COMMENT '删除标志' ,
    PRIMARY KEY (id)
) COMMENT = 'PLC告警配置 ';;

CREATE TABLE plc_monitor(
    id BIGINT NOT NULL   COMMENT 'ID' ,
    component_id BIGINT    COMMENT '部件ID' ,
    function_id BIGINT    COMMENT '方法ID' ,
    data_model_id BIGINT    COMMENT '数据模型ID' ,
    code INT    COMMENT '编号' ,
    monitor_value VARCHAR(32)    COMMENT '监听值' ,
    message VARCHAR(256)    COMMENT '监听信息' ,
    created_by BIGINT    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_by BIGINT    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    deleted TINYINT    COMMENT '删除标志' ,
    PRIMARY KEY (id)
) COMMENT = 'PLC监听 ';;

CREATE TABLE plc_function(
    id BIGINT NOT NULL   COMMENT 'ID' ,
    component_id BIGINT    COMMENT '部件ID' ,
    data_model_id BIGINT    COMMENT '数据模型ID 入参' ,
    code INT    COMMENT '编号' ,
    name VARCHAR(64)    COMMENT '方法名' ,
    created_by BIGINT    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_by BIGINT    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    deleted TINYINT    COMMENT '删除标志' ,
    PRIMARY KEY (id)
) COMMENT = 'PLC方法 ';;

CREATE TABLE plc_component(
    id BIGINT NOT NULL   COMMENT 'ID' ,
    plc_id BIGINT    COMMENT 'PLCID' ,
    code INT    COMMENT '编号' ,
    parent_id BIGINT    COMMENT '父ID' ,
    name VARCHAR(32)    COMMENT '名称' ,
    port INT    COMMENT '端口' ,
    type_id TINYINT    COMMENT '部件类型' ,
    created_by BIGINT    COMMENT '创建人' ,
    created_time DATETIME    COMMENT '创建时间' ,
    updated_by BIGINT    COMMENT '更新人' ,
    updated_time DATETIME    COMMENT '更新时间' ,
    deleted TINYINT    COMMENT '删除标志' ,
    PRIMARY KEY (id)
) COMMENT = 'PLC部件 ';;

