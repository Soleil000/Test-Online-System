# Test-Online-System
一、环境
1.操作系统 Windows
2.运行环境 java jdk 1.8
3.服务器版本 tomcat 7.0
4.MySQL 版本 5.7(非硬性要求)
5.运行软件 Eclipse Oxygen
6.数据库可视化工具navicat
二、步骤

1.打开navicat，新建名为onlinexam的数据库，选择utf-8的编码方式，右击新建的数据库选择运行SQL文件，
将项目源码/onlinexam.sql文件导入运行即可。
2.打开eclipse，左上角File-->Import-->General-->Existing Projects into Workspace,点击下方Next，
在新的页面中选择Browse导入项目源码/onlinexam2018。
3.在Eclipse左侧目录结构中找到 Java Resources-->src-->db.properties配置文件，
将文件中的username和password修改为您电脑上数据库的用户名和密码并保存。
4-1.在Eclipse下方servers界面中点击click this link to create a new server
将tomcat 7.0（选中本地安装的tomcat文件夹）加入到servers中（若servers中已有服务器则忽略此步骤）。
4-2.右击Servers中的Tomcat v7.0 Server at localhost 选择 Add and Remove将onlinexam2018项目部署到服务器上。
5.点击Eclipse上方绿色三角，选择Run on server，等待启动。
6.打开浏览器，在地址栏输入localhost:8080/onlinexam2018/回车即可进入登录页面（8080为tomcat默认端口后，若进行过修改需替换）

三、身份
管理员账户 admin  123456
教师       赵梓予 456789
学生       赵天宇 456789 
