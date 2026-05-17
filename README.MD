# Запуск тестов
Для запуска тестов на реальном устройстве использовать команду ниже:
```shell
gradle test -DdeviceHost=REAL
```

Для запуска тестов в browserstack использовать команду ниже:
```shell
gradle test -DdeviceHost=BROWSERSTACK
```

Для запуска тестов на эмуляторе использовать команду ниже:
```shell
gradle test -DdeviceHost=EMULATION
```