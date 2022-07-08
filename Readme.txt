*Данное приложение создает сервер Spring Boot*

1. Принимает запрос на endpoint:
http://localhost:8081/gif/RUB

2. Отправляет запрос на API с курсом валют на сегодня:
https://openexchangerates.org/api/latest.json?app_id=03a6c20a691540d4afea051b31578752

3. Отправляет запрос на API с курсом валют на вчера:
https://openexchangerates.org/api/historical/2022-06-06.json?app_id=03a6c20a691540d4afea051b31578752

4. Сравнивает курсы.

Если курс сегодня больше чем вчера -
делается запросв на API с гифками:
https://api.giphy.com/v1/gifs/random?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&tag=rich&rating=g

Если курс сегодня меньше чем вчера -
делается запросв на API с гифками:
https://api.giphy.com/v1/gifs/random?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&tag=broke&rating=g

5. Возвращает полученую gif в html странице.








