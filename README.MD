jedis-starter for spring-boot
=============================
* 使用JedisPool管理连接

* 使用方法

1.安装到本地仓库
```
    mvn clean install
```

2.pom文件添加依赖
```
     <dependency>
         <groupId>com.luxh</groupId>
         <artifactId>lingxi-redis-springboot-starter</artifactId>
         <version>1.0-SNAPSHOT</version>
     </dependency>`
```
3.application.properteis配置redsi相关信息
```$xslt
    lingxi.redis.host=127.0.0.1
    lingxi.redis.db=1
    lingxi.redis.port=6379
    lingxi.redis.password=123456
```
4.组件中注入依赖
```$xslt
    @Autowired
    private LingxiRedisService lingxiRedisService;
```
5.调用方法
```$xslt
    lingxiRedisService.set("hello", "灵犀-redis-starter");
    
    String reply = lingxiRedisService.get("hello");
```