# MySql5.7挂载安装

```shell
docker run -p 3308:3306 --name mysql5.7 \
 -v /Users/mac/Documents/docker_volume/mysql5.7/data:/var/lib/mysql \
 -v /Users/mac/Documents/docker_volume/mysql5.7/conf:/etc/mysql \
 -v  /Users/mac/Documents/docker_volume/mysql5.7/logs:/var/log/mysql \
 -e MYSQL_ROOT_PASSWORD=zhongqian \
 -d mysql:5.7 
```

# MySql8.0挂载安装

```shell
docker run -p 3308:3306 --name mysql8.0 \
 -v /Users/mac/Documents/docker_volume/mysql8.0/data:/var/lib/mysql-files \
 -v /Users/mac/Documents/docker_volume/mysql8.0/conf:/etc/mysql \
 -v  /Users/mac/Documents/docker_volume/mysql8.0/logs:/var/log/mysql \
 -e MYSQL_ROOT_PASSWORD=zhongqian \
 -d mysql:8.0 
```

> 注意:挂载目录文件下需为空. 如果失败，可以通过`docker logs 容器名称`  来查看日志
> 删除容器 `docker rm 容器名`  
> 删除镜像 `docker rmi 镜像名`
> 删除所有 `docker rm $(docker ps -qa)`
> 进入mysql容器 `docker exec -it 容器名 /bin/bash `
> 查看容器IP ： `docker inspect --format='{{.NetworkSettings.IPAddress}}' 容器名`

**在/Users/mac/Documents/docker_volume/mysql5.7/conf  下新增my.cnf 配置文件，修改mysql配置**

> 容器操作`docker start/restart/stop 镜像名称`

# Redis 挂载安装

```shell
docker run -p 6379:6379 --name redis \
-v /Users/mac/Documents/docker_volume/redis_latest/data:/data \
-v /Users/mac/Documents/docker_volume/redis_latest/conf/redis.conf:/etc/redis/redis.conf \
-d redis redis-server /etc/redis/redis.conf
```


# MySql5.7 主从配置

https://blog.csdn.net/abcde123_123/article/details/106244181

1. 创建启动mysql5.7_master, mysql5.7_slave
```
docker run -p 3307:3306 --name mysql5.7_master  \
 -v /Users/mac/Documents/docker_volume/mysql5.7_master/data:/var/lib/mysql \
 -v /Users/mac/Documents/docker_volume/mysql5.7_master/conf:/etc/mysql \
 -v  /Users/mac/Documents/docker_volume/mysql5.7_master/logs:/var/log/mysql \
 -e MYSQL_ROOT_PASSWORD=zhongqian \
 -d mysql:5.7 
```

```
 docker run -p 3308:3306 --name mysql5.7_slave  \
 -v /Users/mac/Documents/docker_volume/mysql5.7_slave/data:/var/lib/mysql \
 -v /Users/mac/Documents/docker_volume/mysql5.7_slave/conf:/etc/mysql \
 -v  /Users/mac/Documents/docker_volume/mysql5.7_slave/logs:/var/log/mysql \
 -e MYSQL_ROOT_PASSWORD=zhongqian \
 -d mysql:5.7 
 ```

 2. 配置 master my.cnf
```bash
[mysqld]
## 同一局域网内注意要唯一
server-id=100
## 开启二进制日志功能，可以随便取（关键）
log-bin=mysql-bin
```
配置完成后重启
 ![](2020-10-30-10-13-10.png)
 
> File 和 Position 值后续会使用到

3. 配置 slave my.cnf
```bash
[mysqld]
## 设置server_id,注意要唯一
server-id=103
## 开启二进制日志功能，以备Slave作为其它Slave的Master时使用
log-bin=mysql-slave-bin
## relay_log配置中继日志
relay_log=edu-mysql-relay-bin
read_only=1
## 设置为只读,该项如果不设置，表示slave可读可写
```
配置完成后重启服务
设置master
```bash
 CHANGE MASTER TO MASTER_HOST='172.17.0.2',
　　MASTER_PORT=3306,
　　MASTER_USER='slave',
　　MASTER_PASSWORD='123456',
　　MASTER_LOG_FILE='mysql-bin.000001',
　　MASTER_LOG_POS=154; 
```
启动slave
```bash
start slave;
show slave status \G;
```
![](2020-10-30-10-25-19.png)


mysql binlog 复制模式
![](2020-11-01-17-23-29.png)




























































