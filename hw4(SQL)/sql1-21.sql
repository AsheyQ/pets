-- 1.Найдите номер модели, скорость и размер жесткого диска для всех ПК стоимостью менее 500 дол. Вывести: model, speed и hd
SELECT model, speed, hd 
FROM PC 
WHERE price < 500
-- 2.Найдите номер модели, скорость и размер жесткого диска для всех ПК стоимостью менее 500 дол. Вывести: model, speed и hd
SELECT DISTINCT maker 
FROM product 
WHERE type = 'Printer'
-- 3.Найдите номер модели, объем памяти и размеры экранов ПК-блокнотов, цена которых превышает 1000 дол.
SELECT model, 
	   ram, 
	   screen 
FROM laptop 
WHERE price > 1000
-- 4.Найдите все записи таблицы Printer для цветных принтеров.
SELECT * 
FROM printer 
WHERE color = 'y'
-- 5.Найдите номер модели, скорость и размер жесткого диска ПК, имеющих 12x или 24x CD и цену менее 600 дол.
SELECT model,
	   speed,
       hd
FROM PC
where (cd = '12x' OR cd = '24x')
AND price < 600
-- 6.Для каждого производителя, выпускающего ПК-блокноты c объёмом жесткого диска не менее 10 Гбайт, найти скорости таких ПК-блокнотов. Вывод: производитель, скорость.
SELECT DISTINCT Product.maker, 
		        Laptop.speed
FROM Laptop 
INNER JOIN Product ON (Laptop.model = Product.model) AND Laptop.hd >= 10

-- 7.Найдите номера моделей и цены всех имеющихся в продаже продуктов (любого типа) производителя B (латинская буква).
SELECT DISTINCT product.model,
			    pc.price
FROM Product
JOIN pc ON product.model = pc.model
WHERE maker = 'B'
UNION
SELECT DISTINCT product.model, 
			    laptop.price
FROM product 
JOIN laptop ON product.model = laptop.model WHERE maker = 'B'
UNION
SELECT DISTINCT product.model, 
			    printer.price
FROM product 
JOIN printer ON product.model = printer.model WHERE maker = 'B'

-- 8.Найдите производителя, выпускающего ПК, но не ПК-блокноты.
SELECT DISTINCT maker
FROM product
WHERE type = 'PC'
EXCEPT
SELECT DISTINCT maker
FROM product
WHERE type = 'Laptop'

-- 9.Найдите производителей ПК с процессором не менее 450 Мгц. Вывести: Maker
SELECT DISTINCT  maker 
FROM product, 
	 PC
WHERE PC.speed >= 450 AND PC.model = Product.model
-- 10.Найдите модели принтеров, имеющих самую высокую цену. Вывести: model, price
SELECT model, 
	   price
FROM printer
WHERE price = (
			   SELECT MAX(price)
			   FROM printer
			  )

-- 11.Найдите среднюю скорость ПК.
SELECT AVG(speed) AS "AVG-Speed"
FROM PC 

-- 12.Найдите среднюю скорость ПК-блокнотов, цена которых превышает 1000 дол.
SELECT AVG(speed) AS "AVG-Speed"
FROM LAPTOP 
WHERE price > 1000

-- 13.Найдите среднюю скорость ПК, выпущенных производителем A.
SELECT AVG(speed) AS "AVG-Speed"
FROM PC 
JOIN Product ON PC.model = Product.model AND Product.maker = 'A'

-- 14.Найдите класс, имя и страну для кораблей из таблицы Ships, имеющих не менее 10 орудий.
SELECT C.class,
	   S.name,
       C.country
FROM Ships S
JOIN Classes C ON S.class = C.class AND C.numGuns >= 10

-- 15.Найдите размеры жестких дисков, совпадающих у двух и более PC. Вывести: HD
SELECT HD
FROM PC
GROUP BY HD
HAVING COUNT(hd) > 1

-- 16.Найдите пары моделей PC, имеющих одинаковые скорость и RAM. В результате каждая пара указывается только один раз, т.е. (i,j), но не (j,i), Порядок вывода: модель с большим номером, модель с меньшим номером, скорость и RAM.
SELECT DISTINCT A.model,
			    B.model,	
	            A.speed,	
	            A.ram
FROM PC A, PC B
WHERE A.speed = B.speed AND B.ram = A.ram AND A.model > B.model

-- 17.Найдите модели ПК-блокнотов, скорость которых меньше скорости каждого из ПК.Вывести: type, model, speed
SELECT DISTINCT type, 
		        Laptop.model, 
				speed
FROM Laptop
JOIN Product ON Laptop.model = Product.model AND speed < ALL (
															 	SELECT speed
															 	FROM PC
															 )
-- 18.Найдите производителей самых дешевых цветных принтеров. Вывести: maker, price
SELECT DISTINCT product.maker, 
			    printer.price
FROM product,
	 printer
WHERE product.model = printer.model AND printer.color = 'y'
AND printer.price = (SELECT MIN(price) FROM printer WHERE printer.color = 'y')
-- 19.Для каждого производителя, имеющего модели в таблице Laptop, найдите средний размер экрана выпускаемых им ПК-блокнотов.Вывести: maker, средний размер экрана.
SELECT DISTINCT maker, 
			    AVG (screen)
FROM Product p JOIN Laptop l ON p.model = l.model
GROUP BY maker
-- 20.Найдите производителей, выпускающих по меньшей мере три различных модели ПК. Вывести: Maker, число моделей ПК.
SELECT maker, 
	   COUNT(model)
FROM Product
WHERE type = 'pc'
GROUP BY maker
HAVING COUNT(model) >= 3
-- 21.Найдите максимальную цену ПК, выпускаемых каждым производителем, у которого есть модели в таблице PC.Вывести: maker, максимальная цена.
SELECT maker, MAX(p.price)
FROM PC p 
JOIN Product pr ON p.model = pr.model
GROUP BY maker




		 