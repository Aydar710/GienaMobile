# **Финансовый наставник**

> :alembic: Реализация обучения в формате текстового квеста/визуальной новэллы с главной героиней «финансовым наставником» - Ватабэ.

:construction: **This project is still in development!**

## :sparkles: Backend server (Python/Django with Postgres DB)

See GitHub Pages at https://github.com/AminovE99/vatabe-back 

## :rocket: Android build
- Из корневой директории проекта выполнить:
```shell
./gradlew assembleDebug
```
для сборки установочного apk файла приложения.

- Подключить телефон через USB с разрешенной в настройках установкой и отладкой через USB

- Для установки приложения на телефон, перейти в директорию Android/sdk/platform-tools/ и выполнить:
```shell
./adb -d install /Users/username/AndroidStudioProjects/GienaMobile/app/build/outputs/apk/debug/app-debug.apk
```

- Для запуска приложения выполнить команду:
```shell
./adb shell am start -n com.gina.gienamobile/.presentation.greeting.GreetingActivity
```
, либо найти установленное приложение на телефоне
