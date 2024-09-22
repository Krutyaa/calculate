Тестирование происходило через POSTMAN

Примеры запросов
http
GET http://localhost:8080/calculacte?averageSalary=50000&vacationDays=11


http
GET http://localhost:8080/calculacte?averageSalary=50000&vacationDays=11&startDate=2024-09-20

averageSalary - среднемесячная зарабатная плата

vacationDays - количество дней отпуска

startDate - Дата начала отпуска. Формат даты `YYYY-MM-DD`.
Если параметр не указан, расчет производится без учета выходных и праздников.

