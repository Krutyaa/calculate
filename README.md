Тестирование происходило через POSTMAN

Примеры запросов
http
GET localhost:8080/calculate?averageSalary=50000&vacationDays=14


http
GET localhost:8080/calculate?averageSalary=50000&startDate=2025-05-01&vacationDays=14

averageSalary - среднемесячная зарабатная плата

vacationDays - количество дней отпуска

startDate - Дата начала отпуска. Формат даты `YYYY-MM-DD`.
Если параметр не указан, расчет производится без учета выходных и праздников.

P.S., если указывать дату, то праздничные дни не считаются за отпускной, но за них начисляется ежедневная з.п.
