### 微服务划分说明

当前项目初步拆分了微服务，仅使用了 Eureka Server、Eureka Client、Feign，尚未配置网关、配置负载均衡等

目前运行项目需要启动的应用有 server、mooc、courseware， 分别对应了服务注册中心、Mooc后端主体服务、课件服务

另外 coursenotice模块 仅用于展示 使用 FeignClient 调用其他微服务的接口测试，实际上前端调用的 api 并未更改 