# springbootdemo
springboot demo

#SpringBoot

SpringBoot是对SpringMVC的进一层封装，自动化部署，简化了配置

本demo中用的是springboot 2.0

下图是springboot结构图

![image](https://github.com/AlienAvatar/springbootdemo/blob/master/images/springboot.png)

## 静态资源访问

如图所示

在static下面放置图片，访问http://localhost:8080/test.jpg  页面上会显示图片

## 渲染Web页面

Spring Boot提供了默认配置的模板引擎主要有以下几种：

Thymeleaf FreeMarker Velocity Groovy Mustache

## 注解

@RestController

springboot中控制器注解@RestController 等于原springmvc @Controller+@ResponseBody

@RequestMapping 配置url映射

@RequestParam 从页面中传递参数

@ModelAttribute 绑定参数

## 统一异常处理

## Swagger2

1.注入依赖
pom.xml
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.8.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.8.0</version>
</dependency>

2.创建配置类

@Configuration 让Spring来加载该类配置

@EnableSwagger2 注解来启用Swagger2

@ApiOperation 增加API说明

通过 @ApiImplicitParams、 @ApiImplicitParam 增加参数说明

select()函数会返回个ApiSelectorBulider控制哪些接口暴露给Swagger

地址：http://localhost:8088/swagger-ui.html

Swagger官方网站：http://swagger.io/


## springboot 发送邮件
1.maven 依赖

<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
		<dependency>
			<groupId>ort.springframework.boot</groupId>
			<artifactId>spring-boot-starter-velocity</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-freemarker</artifactId>
		</dependency>

2.添加配置

在application.properties中添加邮件配置

3.进行单元测试

springboot-starter 模块提供自动化配置，引入依赖后，会根据配置文件创建JavaMailSender实例，用@Autowired来自动注入对象

535错误
网易邮箱的password是授权码而不是账户登录密码

新版本中发送模板邮件不支持velocity
使用FreeMarker

## 自定义属性与加载

@Value("${属性名}")

## 多环境配置

application-dev.properties: 开发环境
application-test.properties: 测试环境
application-prod.properties:生产环境

#默认以dev环境设置
spring.profiles.active=dev

## SpringBoot 应有主要运行方式

(1) 运行Springboot运行主类
(2) 到项目所在目录，使用Maven的Springboot插件 'mvn spring-boot:run'来运行
(3) 打成jar包，使用'java -jar'运行

mvn install 打成jar包
jar包的位置 D:\java-project\springbootdemo\target
