# AndroidLearning


用来展示Activity生命周期的变化
## 显示普通Activity

onCreate->onStart->onResume

## 销毁普通Activity

onPause->onStop->onDestroy

## 普通Activity进入后台

onPause->onStop->onSaveInstanceState

## 普通Activity返回前台

onRestart->onStart->onResume

## ActivityA to ActivityB

A.onPause->B.onCreate->B.onStart->B.onResume->A.onStop->onSaveInstanceState

## ActivityA to ActivityB 然后按Back

B.onPause->A.onRestart->A.onStart->A.onResume->B.onStop->B.onDestroy

## ActivityA to ActivityB，ActivityB是小窗口

A.onPause->B.onCreate

## ActivityA to ActivityB，ActivityB是小窗口 然后按Back

A.onResume

## ActivityA在横竖屏变化的时候

竖->横
onPause->onStop->onSaveInstanceState->onDestroy->onCreate->onStart->onResume

横->竖
onPause->onStop->onSaveInstanceState->onDestroy->onCreate->onStart->onResume


## 什么时候会出现调用onDestroy但是没有调用onPause和onStop

在onCreate中调用finish()方法的时候。