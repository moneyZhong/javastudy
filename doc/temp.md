docker run -p 3309:3306 --name mysql8.0_ignore_case \
 -v /Users/mac/Documents/docker_volume/mysql8.0_ignore_case/data:/var/lib/mysql-files \
 -v /Users/mac/Documents/docker_volume/mysql8.0_ignore_case/conf:/etc/mysql \
 -v  /Users/mac/Documents/docker_volume/mysql8.0_ignore_case/logs:/var/log/mysql \
 -e MYSQL_ROOT_PASSWORD=zhongqian \
 -d mysql:8.0 