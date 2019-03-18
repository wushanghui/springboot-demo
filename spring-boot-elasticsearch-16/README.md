# 一、检索
我们的应用经常需要添加检索功能，开源的 ElasticSearch 是目前全文搜索引擎的首选。他可以快速的存储、搜索和分析海量数据。Spring Boot通过整合Spring Data ElasticSearch为我们提供了非常便捷的检索功能支持；

Elasticsearch是一个分布式搜索服务，提供Restful API，底层基于Lucene，采用多shard（分片）的方式保证数据安全，并且提供自动resharding的功能，github等大型的站点也是采用了ElasticSearch作为其搜索服务

中文地址：
https://www.elastic.co/guide/cn/elasticsearch/guide/current/_indexing_employee_documents.html
# 二、概念 

1、以 员工文档 的形式存储为例：一个文档代表一个员工数据。存储数据到 ElasticSearch 的行为叫做 索引 ，但在索引一个文档之前，需要确定将文档存储在哪里。

2、一个 ElasticSearch 集群可以 包含多个 索引 ，相应的每个索引可以包含多个 类型 。 这些不同的类型存储着多个 文档 ，每个文档又有 多个 属性 。

3、类似关系：
- 索引-数据库
- 类型-表
- 文档-表中的记录
- 属性-列

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190318211737938.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d1c2g5Mw==,size_16,color_FFFFFF,t_70)
# 三、整合ElasticSearch测试 
1、引入spring-boot-starter-data-elasticsearch

2、安装Spring Data 对应版本的ElasticSearch

3、application.yml配置

4、Spring Boot自动配置的 ElasticsearchRepository、ElasticsearchTemplate、Jest

5、测试ElasticSearch