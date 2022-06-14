-- 1.         Вывести список самолетов с кодами 320, 321, 733;
SELECT AIRCRAFT_CODE, 
	   RANGE,
	   MODEL
FROM LANIT.AIRCRAFTS_DATA
WHERE AIRCRAFT_CODE IN ('320', '321', '733')
-- 2.         Вывести список самолетов с кодом не на 3;
SELECT AIRCRAFT_CODE, 
	   RANGE,
	   MODEL
FROM LANIT.AIRCRAFTS_DATA
WHERE AIRCRAFT_CODE NOT LIKE '3%'
-- 3.         Найти билеты оформленные на имя «OLGA», с емайлом «OLGA» или без емайла;   
SELECT TICKET_NO,
	   PASSENGER_NAME,
	   EMAIL
FROM LANIT.TICKETS
WHERE (PASSENGER_NAME LIKE 'OLGA%') OR (EMAIL LIKE '%OLGA%')
-- 4.         Найти самолеты с дальностью полета 5600, 5700. Отсортировать список по убыванию дальности полета;    
SELECT AIRCRAFT_CODE,
	   RANGE,
	   MODEL
FROM LANIT.AIRCRAFTS_DATA
WHERE RANGE IN ('5600', '5700')
ORDER BY RANGE DESC
-- 5.         Найти аэропорты в Moscow. Вывести название аэропорта вместе с городом. Отсортировать по полученному названию;
SELECT AIRPORT_CODE,
	   CITY,
	   AIRPORT_NAME 
FROM LANIT.AIRPORTS_DATA ad
WHERE CITY = 'Moscow'
ORDER BY AIRPORT_NAME 
-- 6.         Вывести список всех городов без повторов в зоне «Europe»;
SELECT CITY,
	   TIMEZONE
FROM LANIT.AIRPORTS_DATA
WHERE TIMEZONE LIKE ('Europe%')
GROUP BY CITY,
		 TIMEZONE 
-- 7.         Найти бронирование с кодом на «3A4» и вывести сумму брони со скидкой 10%
SELECT BOOK_REF,
	   TOTAL_AMOUNT,
	   TOTAL_AMOUNT * 1.1 AS AMOUNT_WITH_SALE
FROM LANIT.BOOKINGS
WHERE BOOK_REF LIKE ('3A4%')
-- 8.         Вывести все данные по местам в самолете с кодом 320 и классом «Business» строками вида «Данные по месту: номер места 1», «Данные по месту: номер места 2» … и тд
SELECT	SEAT_NO, 
		AIRCRAFT_CODE,
		FARE_CONDITIONS 
FROM LANIT.SEATS
WHERE AIRCRAFT_CODE = '320' AND FARE_CONDITIONS = 'Business'
-- 9.         Найти максимальную и минимальную сумму бронирования в 2017 году;
SELECT MAX(TOTAL_AMOUNT),
	   MIN(TOTAL_AMOUNT)
FROM LANIT.BOOKINGS 
WHERE TO_CHAR(BOOK_DATE, 'yyyy') = '2017'
-- 10.      Найти количество мест во всех самолетах, вывести в разрезе самолетов;      
SELECT 
	MODEL,
	COUNT(SEAT_NO)
FROM
	LANIT.AIRCRAFTS_DATA ad 
JOIN LANIT.SEATS s ON
	s.AIRCRAFT_CODE  = ad.AIRCRAFT_CODE
GROUP BY MODEL
ORDER BY MODEL
-- 11.      Найти количество мест во всех самолетах с учетом типа места, вывести в разрезе самолетов и типа мест;
SELECT 
	MODEL,
	FARE_CONDITIONS,
	COUNT(SEAT_NO)
FROM
	LANIT.AIRCRAFTS_DATA ad 
JOIN LANIT.SEATS s ON
	s.AIRCRAFT_CODE  = ad.AIRCRAFT_CODE
GROUP BY MODEL,
		 FARE_CONDITIONS
ORDER BY MODEL, FARE_CONDITIONS
-- 12.      Найти количество билетов пассажира ALEKSANDR STEPANOV, телефон которого заканчивается на 11;
SELECT 
	COUNT(TICKET_NO)
FROM LANIT.TICKETS
WHERE PASSENGER_NAME = 'ALEKSANDR STEPANOV' AND PHONE LIKE ('%11')
GROUP BY PASSENGER_NAME
-- 13.      Вывести всех пассажиров с именем ALEKSANDR, у которых количество билетов больше 2000. Отсортировать по убыванию количества билетов;    
SELECT 
	PASSENGER_NAME,
	COUNT(TICKET_NO)
FROM LANIT.TICKETS
WHERE PASSENGER_NAME LIKE ('ALEKSANDR%')
GROUP BY PASSENGER_NAME
HAVING COUNT(TICKET_NO) > 2000
ORDER BY COUNT(TICKET_NO) DESC
-- 14.      Вывести дни в сентябре 2017 с количеством рейсов больше 500.
SELECT DATE_DEPARTURE,
	   COUNT(FLIGHT_NO)
FROM LANIT.FLIGHTS
WHERE TO_CHAR(DATE_DEPARTURE, 'yyyy-mm') = '2017-09'
GROUP BY DATE_DEPARTURE 
HAVING COUNT(FLIGHT_NO) > 500
-- 15.      Вывести список городов, в которых несколько аэропортов
SELECT CITY,
	   COUNT(AIRPORT_CODE)
FROM LANIT.AIRPORTS_DATA
GROUP BY CITY
HAVING COUNT(AIRPORT_CODE) > 1
-- 16.      Вывести модель самолета и список мест в нем, т.е. на самолет одна строка результата
SELECT 
	MODEL,
	COUNT(SEAT_NO)
FROM
	LANIT.AIRCRAFTS_DATA ad 
JOIN LANIT.SEATS s ON
	s.AIRCRAFT_CODE  = ad.AIRCRAFT_CODE
GROUP BY MODEL
ORDER BY COUNT(SEAT_NO)
-- 17.      Вывести информацию по всем рейсам из аэропортов в г.Москва за сентябрь 2017
SELECT 
	DEPARTURE_AIRPORT,
	FLIGHT_NO,
	FLIGHT_ID,
	DATE_DEPARTURE 
FROM
	LANIT.FLIGHTS f 
JOIN LANIT.AIRPORTS_DATA ad ON
	f.DEPARTURE_AIRPORT  = ad.AIRPORT_CODE 
WHERE 
	ad.CITY = 'Moscow'
	AND TO_CHAR(DATE_DEPARTURE, 'yyyy-mm') = '2017-09'
ORDER BY DATE_DEPARTURE
-- 18.      Вывести кол-во рейсов по каждому аэропорту в г.Москва за 2017
SELECT 
	DEPARTURE_AIRPORT,
	COUNT(FLIGHT_NO)
FROM
	LANIT.FLIGHTS f 
JOIN LANIT.AIRPORTS_DATA ad ON
	f.DEPARTURE_AIRPORT  = ad.AIRPORT_CODE 
WHERE 
	ad.CITY = 'Moscow'
	AND TO_CHAR(DATE_DEPARTURE, 'yyyy') = '2017'
GROUP BY DEPARTURE_AIRPORT
ORDER BY DEPARTURE_AIRPORT
-- 19.      Вывести кол-во рейсов по каждому аэропорту, месяцу в г.Москва за 2017
SELECT 
	DEPARTURE_AIRPORT,
	TO_CHAR(DATE_DEPARTURE, 'yyyy-mm'),
	COUNT(FLIGHT_NO)
FROM
	LANIT.FLIGHTS f 
JOIN LANIT.AIRPORTS_DATA ad ON
	f.DEPARTURE_AIRPORT  = ad.AIRPORT_CODE 
WHERE 
	ad.CITY = 'Moscow'
	AND TO_CHAR(DATE_DEPARTURE, 'yyyy') = '2017'
GROUP BY DEPARTURE_AIRPORT,
		 TO_CHAR(DATE_DEPARTURE, 'yyyy-mm')
ORDER BY TO_CHAR(DATE_DEPARTURE, 'yyyy-mm')
-- 20.      Найти все билеты по бронированию на «3A4B»
SELECT TICKET_NO,
       PASSENGER_ID,
       PASSENGER_NAME
FROM LANIT.TICKETS
WHERE BOOK_REF LIKE '3A4B%'
-- 21.      Найти все перелеты по бронированию на «3A4B»
SELECT FLIGHT_NO,
	   b.BOOK_REF
FROM LANIT.FLIGHTS 
			 JOIN LANIT.TICKET_FLIGHTS tf ON FLIGHTS.FLIGHT_ID = tf.FLIGHT_ID
             JOIN LANIT.TICKETS t ON T.TICKET_NO = tf.TICKET_NO
             JOIN LANIT.BOOKINGS b ON b.BOOK_REF = t.BOOK_REF
WHERE b.BOOK_REF LIKE '3A4B%'


		 
