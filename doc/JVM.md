# 内存分析
https://www.cnblogs.com/hhandbibi/p/7280450.html
jps -l 获取jvm进程

获取内存使用情况
jmap -dump:format=b,file=abc.dat 13262

导出文件通过MAT 工具分析

# 线程堆栈分析
`
jstack -l -m 13262 >> 123.txt
`

# JVM 调优
1. 常用参数
   * -XX:+PrintGC 出发GC时打印相关日志
   * -XX:+UseSerialGC 串行回收
   * -XX:+PrintGCDetails 更详细的GC日志
   * -Xms   堆初始值
   * -Xmx   堆最大值（堆最大值和初始值一般保持一致）
   * -Xmn   新生代堆最大可用值
   * -Xss   线程堆栈大小
   * -XX:SurvivorRatio 设置新生代中EDEN 空间和 from/to 空间的比例
   *  

bit
byte  1Byte = 8bit
kb    1kb = 1024 Byte 
Mb  1Mb = 1024Mb
GB  1GB = 1024MB






