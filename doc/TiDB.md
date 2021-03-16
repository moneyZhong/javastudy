##### TiDB安装

[https://pingcap.com/docs-cn/stable/quick-start-with-tidb/#%E7%AC%AC%E4%B8%80%E7%A7%8D%E4%BD%BF%E7%94%A8-tiup-playground-%E5%BF%AB%E9%80%9F%E9%83%A8%E7%BD%B2%E6%9C%AC%E5%9C%B0%E6%B5%8B%E8%AF%95%E7%8E%AF%E5%A2%83](https://pingcap.com/docs-cn/stable/quick-start-with-tidb/#第一种使用-tiup-playground-快速部署本地测试环境)

### 数据迁移

数据迁移分为增量数据、存量数据两部分。

- 对于存量数据，可以使用逻辑备份、导入的方式，除了传统的逻辑导入外，官方还提供一款物理导入的工具 TiDB Lightning。
- 对于增量备份可以使用 TiDB 提供的 Syncer （新版已经更名为 DM - Data Migration）来保证数据同步。

1. ```shell
   tiup clean --all
   mysql --host 127.0.0.1 --port 4000 -u root
   
   ```

