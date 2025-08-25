## 项目概述
题库社区项目领域服务 - 一款使用 Java 21 和 Spring Boot 3.2.0 构建、采用多模块 Maven 架构的解决问题的社区项目服务。

## 项目结构

该项目遵循了“领域驱动设计（DDD）”的分层架构，并且清晰地划分了各个功能模块的职责范围：

```
club-subject/                   # 父 POM 模块
├── club-subject-api            # API 层 - 合同、数据传输对象、服务接口
├── club-subject-domain         # 领域层 - 业务实体与逻辑
├── club-subject-infra          # 基础设施层 - 持久化、消息传递、远程过程调用
├── club-subject-application    # 应用层
│   ├── club-subject-application-controller   # REST 控制器
│   ├── club-subject-application-job          # 后台任务/调度程序
│   └── club-subject-application-mq           # 消息队列处置器
├── club-subject-common         # 共享的公用组件、枚举值、配置信息
└── club-subject-starter        # Spring Boot 应用程序入口点
```

## 构建命令

```bash
# 构建整个项目
mvn clean install

# 构建特定模块
mvn clean install -pl club-subject-starter -am

# 构建项目跳过测试
mvn clean install -DskipTests

# 启动
mvn spring-boot:run -pl club-subject-starter

# 打包可执行的 JAR 文件
mvn clean package -pl club-subject-starter
java -jar club-subject-starter/target/club-subject-starter-1.0-SNAPSHOT.jar
```

## 技术栈
- **Java**: 21
- **Spring Boot**: 3.2.0
- **Maven**: Build tool
- **Repository**: Aliyun Maven (https://maven.aliyun.com/repository/public)
- **Encoding**: UTF-8



https://api.moonshot.cn/anthropic/

sk-ugVQpzXVLfifUBCGW2bvCFTwabQ1fqAwcBliiegbmbxUJwtt