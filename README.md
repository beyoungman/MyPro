这是我根据自家情况做的一个练习项目，用javabean+serlvet+jsp 的mvc模式开发的，开发工具eclipse，tomcat7，mysql 5.7。

主要是管理员工，管理打包场进货和出货。页面不会写，写的很烂。

javabeans包：	主要类；
		user-用户，即老板，管理者；
		staff-员工；
		ot,bmoney,rest,buy,sale，otherpay-- 分别对应加班，借支，休息，进货，出货,其他方面的支出；


serlvet包:每个类都有对应的serlvet调用相应的service完成对数据的增删改查。

service包：每个类都有对应的service，负责调用相应的dao进行业务逻辑处理。

dao包: 每个类都有对应的dao，负责连接数据库，进行数据库通信。

tools包：工具包，包含分页类，jdbc连接，数据库连接信息在这里配置。

用到的jar包：junit单元测试： hamcrest-core-1.3.jar，junit-4.12.jar；

	     Mysql连接驱动： mysql-connector-java-5.1.6.jar，

	     JSTL :  jstl-1.2.jar，
		
	    Servlet:  servlet-api.jar

sql文件：需要去掉单引号才可以导入；# MyPro


//第一次上传GitHub.^_^
