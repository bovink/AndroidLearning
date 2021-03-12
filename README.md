# AndroidLearning


介绍关于服务的Android知识。

与标准框架相关。

## 普通服务

服务只有第一次启动的时候会调用onCreate方法。


## Intent服务

## 绑定服务

# IntentService

每次启动服务只会处理一个Intent。之后发送的Intent会顺序执行。

在onDestroy()执行前，所有的Intent都是在同一个线程中执行。

onDestroy()后，再次启动会开启新的线程处理Intent。


# Service与Thread的区别

Service在手机息屏的时候不会停止。

Thread在手机息屏的时候会停止。
