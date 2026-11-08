# Демо-проект по автоматизации тестирования для интернет магазина [Крымская-косметика.рф](https://крымская-косметика.рф/)

<p align="center">  
<a href="https://крымская-косметика.рф/"><img src="images/logo/logo-site.png" alt="Jenkins" width="500"/></a>  
</p>

## **Содержание:**

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Пример Allure отчета</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>
____

<a id="tools"></a>
## <a name="Технологии и инструменты">Технологии и инструменты:</a>

<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a> 
<a href="https://qameta.io/"><img src="images/logo/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="images/logo/Jira.svg" width="50" height="50"  alt="Jira"/></a>  
</p>

- Тесты: IntelliJ IDEA + JUnit5 + Selenide, язык Java
- Сборка: Gradle
- Среда: Selenoid
- Удаленный запуск: Jenkins
- Отчеты: Allure-отчет и отправка результата в Telegram
---

<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">Примеры автоматизированных тест-кейсов:</a>

- ✓ *Проверка регистрации*
- ✓ *Проверка авторизации*
- ✓ *Проверка работы поиска*
- ✓ *Проверка работы с найденным с помощью поиска товаром: просмотр карточки товара, добавление товара в корзину, добавление товара в Избранное*
- ✓ *Проверка работы кнопок панели меню*

____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="images/logo/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.qa.guru/view/java-students/job/42_annap_module4_all/)</a>

<p align="center">  
<a href="https://jenkins.qa.guru/view/java-students/job/42_annap_module4_all/"><img src="images/screen/jenkins2.png" alt="Jenkins" width="950"/></a>  
</p>


### **Параметры сборки в Jenkins:**

- *browser (браузер, по умолчанию chrome)*
- *browserVersion (версия браузера, по умолчанию 156.0)*
- *browserSize (размер окна браузера, по умолчанию 1920x1080)*
- *baseUrl (адрес тестируемого веб-сайта)*
- *remoteUrl (логин, пароль и адрес удаленного сервера Selenoid)*

<a id="console"></a>
## Команды для запуска из терминала

***Локальный запуск:***
```bash  
gradle clean
```

***Удалённый запуск через Jenkins:***
```bash  
clean
test
--continue
-Durl=$URL
-Dbrowser=$BROWSER
-DbrowserVersion=$BROWSERVERSION
-DbrowserSize=$BROWSERSIZE
-Dheadless=$HEADLESS
-DselenoidUrl=https://user1:1234@$SELENOIDE_URL/wd/hub
```
___
<a id="allure"></a>
## <img alt="Allure" height="25" src="images/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [отчет](https://jenkins.qa.guru/view/java-students/job/42_annap_module4_all/allure/)</a>

Allure Report — это популярный инструмент с открытым исходным кодом от компании Qameta Software для визуализации результатов автоматизированного тестирования. Он преобразует «сухие» технические логи из автотестов в наглядные и интерактивные HTML-отчёты.

### **Что показывает Allure Report::**

- *Статусы и дерево тестов: сколько тестов прошло успешно (passed), сколько упало (failed) или сломалось (broken), сгруппированные по пакетам, фичам или уровням*
- *Детали шагов: пошаговый сценарий выполнения каждого теста*
- *Вложения (Attachments): скриншоты ошибок, сетевые логи, видеозаписи или JSON-ответы с сервера*
- *История запусков (Trends): графики изменения стабильности тестов от сборки к сборке (помогают выявлять плавающие или нестабильные тесты — flaky tests)*
- *Окружение (Environment): информация о версии ОС, браузере, стенде и параметрах запуска*


### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="images/screen/allure-report.png" width="850">  
</p>  

### *Тест-кейсы*

<p align="center">  
<img title="Allure Tests" src="images/screen/test-cases.png" width="850">  
</p>

<p align="center">  
<img title="Allure Tests" src="images/screen/test-cases-behavior.png" width="850">  
</p>

### *Графики*

<p align="center">  
<img title="Allure Graphics" src="images/screen/allure-graphics.png" width="850">  
</p>

___
<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="images/logo/Allure2.svg" width="25"/></a>Интеграция с <a target="_blank" href="https://allure.qa.guru/project/5372/dashboards">Allure TestOps</a>
TestOps Тестирование + Операции) — это методология и практика управления, автоматизации и масштабирования процессов тестирования в разработке ПО по аналогии с тем, как DevOps объединяет разработку и эксплуатацию.


### **Главные задачи и принципы TestOps:**

- *Интеграция в CI/CD: Встраивание тестов (ручных и автоматизированных) прямо в конвейеры сборки и доставки ПО*
- *Единое пространство: Объединение тест-кейсов, результатов прогонов, логов, дефектов и требований в одной системе (например, с помощью платформ вроде ТестОпс или Allure TestOps)*
- *Работа с автотестами: Масштабирование запуска тестов, управление тестовым окружением и сбор отчетов в реальном времени*
- *Аналитика и метрики: Поиск и устранение «нестабильных» (flaky) тестов, оценка покрытия и прозрачность релизов для бизнеса и разработчиков*
- *Сотрудничество: Тесная связь между QA-инженерами, разработчиками, DevOps-специалистами и менеджерами*


### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="images/screen/testops-dashboard.png" width="850">  
</p>  


### *Авто тест-кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="images/screen/testops-testcases.png" width="850">  
</p>

____
<a id="telegram"></a>
## <img alt="Allure" height="25" src="images/logo/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

<p align="center">  
<img title="Telegram" src="images/screen/telegram.png" width="550">

Тут был бы скрин отчета о прогоне тестов, который пришел в Телеграмм, но из-за блокировок телеграмма скрипты отправки результатов теста в телеграмм не работают
</p>

____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="images/logo/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid

Каждый тест дополняется вложениями:
- Видео
- Ресурс страницы
- Последний скриншот
- Логи страницы

<p align="center">
<img title="Selenoid Video" src="images/video/video.gif" width="550" height="350"  alt="video">   
</p>

