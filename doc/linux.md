## 查看某个被占用的端口号

```java
lsof -i:8000
```

## ping 安装
> `api-get update`
> `apt-get install inetutils-ping`

## vim 
1. 安装
> yum -y install vim*
2. 编辑
   > 撤销修改,命令行模式下u
   > 恢复修改 `ctrl+r`
   > 删除行 dd,  删除多行 dnd
   > 快速到文件结尾，命令行模式 $
   


## centos vim 中文乱码
文件地址：/etc/vimrc， 在文件中添加
```shell
set fileencodings=utf-8,ucs-bom,gb18030,gbk,gb2312,cp936
set termencoding=utf-8
set encoding=utf-8
```
![](2020-10-30-15-57-49.png)

文件数量
ls -l |grep "^-"|wc -l

文件夹
ls -l |grep "^d"|wc -l
