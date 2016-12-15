
# blank-server-spring-boot-mybatis

此项目为了方便创建API服务，使用了`spring-boot` , `mybatis` ,`swigger`等相关库。

## 项目结构

<img src="http://i1.piimg.com/567571/517fa03a5009fb87.png" width="250"/>

## 项目打包

通过`gradle`打包成`jar`包运行。

```shell
gradle build -x test
```

* `-x test`命令跳过junit测试类构建

执行以上命令之后，会在`build/libs/`下找到打包出来的`xxx.jar`包。

## 项目线上环境配置和部署

将打包好的`xxx.jar`包上传到服务器端，
并且复制`jar`包内部的`xxx.jar/BOOT-INF/classes/application.properties`配置文件，
将配置文件放置到与`xxx.jar`包的统计目录。

实际的目录结构;

```
dist
|--- xxx.jar
|--- application.properties
```

然后执行以下命令运行项目
```shell
java -jar xxx.jar
```

说明：

* `spring-boot`会优先读取`jar`包同级目录中的`application.properties`文件,配置文件的读取顺序：
    1. `application.properties`
    1. `config/application.properties`
    1. `xxx.jar/BOOT-INF/classes/application.properties`

### 访问项目

运行此项目之后，在浏览器打开地址： [http://localhost:9090](http://localhost:9090) 访问项目。

使用`swigger-ui`查看`API`文档，如下图:

<img  src="http://p1.bqimg.com/567571/6a8c760799e9cc1f.png" width="250"/>


### 配置说明

```properties
# server 服务端口等配置
server.port=9090

# datasource 数据源配置信息
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:~/todo
spring.datasource.username=sa
spring.datasource.password=sa

# mybatis Mybatis配置信息
mybatis.mapper-locations=classpath:cn.geobeans.web.blank_mybatis.todo.*.xml
mybatis.config-location=classpath:mybatis-config.xml

# logging 日志信息

logging.level.org.springframework = INFO
logging.level.cn.geobeans = DEBUG
```




