# Patterns [![Build status](https://ci.appveyor.com/api/projects/status/kf5odib1imdpe744?svg=true)](https://ci.appveyor.com/project/Murrk/patterns)

## Домашнее задание к занятию «2.3. Patterns»

### Инструкция по запуску

Перед запуском тестов необходимо установить [java 8](https://www.oracle.com/technetwork/java/javase/downloads/2133151)

* Склонировать репозиторий `git clone https://github.com/Murrk/Patterns.git`
* Перейти в директорию с проектом
* Перейти в каталог с файлом jar `cd artifacts` и запустить целевой сервис набрав в консоли команду `java -jar app-card-delivery.jar`
* Выполнить команду `./gradlew test` (`./gradlew.bat test`, если запускается из windows)
* Отчет можно посмотреть в директории `build/reports/tests/test/`
* Для запуска тестов Allure выполнить команду `gradlew clean test allureReport` для просмотра результатов `gradlew allureServe`