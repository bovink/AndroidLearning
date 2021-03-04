# AndroidLearning


用来展示Activity生命周期的变化
## 显示普通Activity

onCreate->onStart->onResume

## 销毁普通Activity

onPause->onStop->onDestroy

## 普通Activity进入后台

onPause->onStop

## 普通Activity返回前台

onRestart->onStart->onResume

## ActivityA to ActivityB

A.onPause->B.onCreate->B.onStart->B.onResume->A.onStop

## ActivityA to ActivityB 然后按Back

B.onPause->A.onRestart->A.onStart->A.onResume->B.onStop->B.onDestroy

## ActivityA to ActivityB，ActivityB是小窗口

## ActivityA在横竖屏变化的时候
