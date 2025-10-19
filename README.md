## Приложение «Мобильный хоспис»: 

### Описание процедуры запуска авто-тестов:

1. Установить и открыть Android Studio

2. Склонировать [репозиторий](https://github.com/valera4388/qamid_diplom)

3. Установить приложение "Мобильный хоспис" на мобильное устройство.

4. Данные для авторизации:

   - В поле "Логин" ввести: login2

   - В поле "Пароль" ввести: password2

### Запуск всех тестов:

Запустить тесты, выбрав папку проекта `app`, нажать правую кнопку мыши,

<img width="446" height="557" alt="image" src="https://github.com/user-attachments/assets/59d57680-417e-4cf0-aa78-afbf7dfa5967" />

Из открывшегося спика выбрать `Run 'All Tests'`

<img width="433" height="276" alt="image" src="https://github.com/user-attachments/assets/18e6bc38-ae39-4b1d-92c6-3d960c93f541" />

### Генерация отчёта Allure:

1. После прохождения всех тестов скопировать папку allure-results в проект с устройства, которую можно найти по пути: `/data/data/ru.iteco.fmhandroid/files/`

2. Выполнить комманду `allure serve` для формирования отчета в браузере.
