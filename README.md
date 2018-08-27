# myDouYing
这是我的maven分层聚合工程-基于SpringBoot的小视频小程序后端

1.使用swagger2构建restful接口测试

2.Redis-session:
    用户信息储存到redis缓存中，形成无状态会话；
    单体应用扩展成集群变得方便；
    便于权限验证。
  
3.使用FFmpeg处理音频。
  
4.使用Pagehelper处理分页操作。
   拦截sql语句，添加语句操作。
   
   
  
  对于Redis：  
  在项目中使用redis，主要是从两个角度去考虑:性能和并发。  
  碰到需要执行耗时特别久，且结果不频繁变动的SQL，就特别适合将运行结果放入缓存。  
  在大并发的情况下，所有的请求直接访问数据库，数据库会出现连接异常。这个时候，就需要使用redis做一个缓冲操作，让请求先访问到redis，而不是直接访问数据库。
    
  单线程的redis为什么这么快？
  (一)纯内存操作
  (二)单线程操作，避免了频繁的上下文切换
  (三)采用了非阻塞I/O多路复用机制： 只有单个线程(一个快递员)，通过跟踪每个I/O流的状态(每个快递的送达地点)，来管理多个I/O流。
  
  redis的数据类型，以及每种数据类型的使用场景？ 
  (一)String
  这个其实没啥好说的，最常规的set/get操作，value可以是String也可以是数字。一般做一些复杂的计数功能的缓存。

  (二)hash
  这里value存放的是结构化的对象，比较方便的就是操作其中的某个字段。博主在做单点登录的时候，就是用这种数据结构存储用户信息，以cookieId作为key，设置30分钟为缓存过期时间，能很好的模拟出类似session的效果。


  (三)list
  使用List的数据结构，可以做简单的消息队列的功能。另外还有一个就是，可以利用lrange命令，做基于redis的分页功能，性能极佳，用户体验好。本人还用一个场景，很合适---取行情信息。就也是个生产者和消费者的场景。LIST可以很好的完成排队，先进先出的原则。


  (四)set
  因为set堆放的是一堆不重复值的集合。所以可以做全局去重的功能。为什么不用JVM自带的Set进行去重？因为我们的系统一般都是集群部署，使用JVM自带的Set，比较麻烦，难道为了一个做一个全局去重，再起一个公共服务，太麻烦了。
  另外，就是利用交集、并集、差集等操作，可以计算共同喜好，全部的喜好，自己独有的喜好等功能。

  (五)sorted set
  sorted set多了一个权重参数score,集合中的元素能够按score进行排列。可以做排行榜应用，取TOP N操作。
