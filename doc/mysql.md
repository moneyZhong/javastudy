# 单表达到多少数据量需要分库分表？
   与服务器性能有关。 MySQL 为了提高性能，会将表的索引装载到内存中。InnoDB buffer size 足够的情况下，其能完成全加载进内存，查询不会有问题。但是，当单表数据库到达某个量级的上限时，导致内存无法存储其索引，使得之后的 SQL 查询会产生磁盘 IO，从而导致性能下降。一般建议单表数据量达到`500万` 考虑分库分表。

# 批量插入数据
```shell
#部门表
CREATE TABLE tb_dept_bigdata (
	id bigint	UNSIGNED PRIMARY KEY auto_increment,
	deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
	dname VARCHAR ( 20 ) NOT NULL DEFAULT '',
loc VARCHAR ( 13 ) NOT NULL DEFAULT '' 
) ENGINE = INNODB DEFAULT charset = utf8;

#员工表
create table tb_emp_bigdata(
id int unsigned primary key auto_increment,
empno mediumint unsigned not null default 0 comment '编号',
empname varchar(20) not null default '' comment '名字',
job varchar(9) not null default '' comment '工作',
mgr mediumint unsigned not null default 0 comment '上级编号',
hiredate date not null COMMENT '入职时间',
sal decimal(7,2) not null COMMENT '薪水',
comm decimal(7,2) not null COMMENT '红利',
deptno mediumint unsigned not null default 0 COMMENT '部门编号'
)engine=innodb default charset=utf8;

show VARIABLES like '%log_bin_trust_function_creators%';

set GLOBAL log_bin_trust_function_creators = 1;

# 定义随机字符串函数
delimiter $$
drop function if exists rand_string;
create function rand_string(n int) returns varchar(255)
begin
declare chars_str varchar(52) default 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
declare return_str varchar(255) default '';
declare i int default 0;
while i<n do
set return_str=concat(return_str,substring(chars_str,floor(1+rand()*52),1));
set i=i+1;
end while;
return return_str;
end $$

# 定义随机数字函数
delimiter $$
drop function if exists rand_num;
create function rand_num() returns int(5)
begin
declare i int default 0;
set i=floor(100+rand()*100);
return i;
end $$

# 定义存储过程
delimiter $$
drop procedure if exists insert_data;
create procedure insert_data(in start int(10),in max_num int(10))
begin
declare i int default 0;
declare n int;
set autocommit=0;
repeat
set i=i+1;
set n = rand_num();
insert into tb_dept_bigdata (deptno,dname,loc) values(n,rand_string(10),rand_string(8));
insert into tb_emp_bigdata (empno,empname,job,mgr,hiredate,sal,comm,deptno) values((start+i),rand_string(6),'developer',0001,curdate(),2000,400,n);
until i=max_num
end repeat;
commit;
end $$

# 调用
show FUNCTION status;
call insert_data(0,1000000);

select * from tb_dept_bigdata limit 10;
```


# 生成批量修改列名大小写脚本
select 
concat( 'alter table ', TABLE_NAME, ' change column ', COLUMN_NAME, '  ', LCASE( COLUMN_NAME ), '  ', COLUMN_TYPE,' ',EXTRA,' comment "',COLUMN_COMMENT,'";' ) AS '修改脚本'
from information_schema.`COLUMNS` t where t.table_schema = 'sys_data_monitor';

# 生成批量修改表名大小写脚本
select 
concat( 'alter table ', TABLE_NAME, ' rename to ', LCASE( TABLE_NAME ), ';' ) AS ‘修改脚本’
from information_schema.`TABLES` t where t.table_schema = 'sys_data_monitor';





# 分库分表采用哪种方案？
   * 阿里的TDDL，DRDS和cobar
   * 京东金融的sharding-jdbc
   * 民间组织的MyCAT
   * 360的Atlas
   * 美团的zebra

归总起来，就两类： client模式和proxy模式。 核心的步骤是一样的：SQL解析，重写，路由，执行，结果归并。
https://www.cnblogs.com/sgphappy2007/p/10489607.html



















