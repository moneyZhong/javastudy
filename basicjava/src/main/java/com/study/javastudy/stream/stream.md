中间操作符
    map(mapToInt,mapToLong,mapToDouble) 转换操作符，把比如A->B，这里默认提供了转int，long，double的操作符。
    flatmap(flatmapToInt,flatmapToLong,flatmapToDouble) 拍平操作比如把 int[]{2,3,4} 拍平 变成 2，3，4 也就是从原来的一个数据变成了3个数据，这里默认提供了拍平成int,long,double的操作符。
    limit 限流操作，比如数据流中有10个 我只要出前3个就可以使用。
    distint 去重操作，对重复元素去重，底层使用了equals方法。
    filter 过滤操作，把不想要的数据过滤。
    peek 挑出操作，如果想对数据进行某些操作，如：读取、编辑修改等。
    skip 跳过操作，跳过某些元素。
    sorted(unordered) 排序操作，对元素排序，前提是实现Comparable接口，当然也可以自定义比较器。
    
    
终止操作符
    collect 收集操作，将所有数据收集起来，这个操作非常重要，官方的提供的Collectors 提供了非常多收集器，可以说Stream 的核心在于Collectors。
    count 统计操作，统计最终的数据个数。
    findFirst、findAny 查找操作，查找第一个、查找任何一个 返回的类型为Optional。
    noneMatch、allMatch、anyMatch 匹配操作，数据流中是否存在符合条件的元素 返回值为bool 值。
    min、max 最值操作，需要自定义比较器，返回数据流中最大最小的值。
    reduce 规约操作，将整个数据流的值规约为一个值，count、min、max底层就是使用reduce。
    forEach、forEachOrdered 遍历操作，这里就是对最终的数据进行消费了。
    toArray 数组操作，将数据流的元素转换成数组。
    
    
    