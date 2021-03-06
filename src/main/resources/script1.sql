CREATE DATABASE athletes1;

/*Table structure for table `hammer_women' */

CREATE TABLE `hammer_women` (
    `athlete_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `rank` int(11) NOT NULL,
    `mark` varchar(30) NOT NULL DEFAULT '',
    `athlete_name` varchar(100) NOT NULL DEFAULT '',
    `date` varchar(20) NOT NULL DEFAULT '',
    `location` varchar(40) NOT NULL DEFAULT '',
    PRIMARY KEY (`athlete_id`)
) AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `hammer_women` */

INSERT INTO `hammer_women`
VALUES (1,1,'82.98 m (272 ft 2 3⁄4 in)','Anita Włodarczyk (POL)','28 August 2016','Warsaw'),
       (2,2,'79.42 m (260 ft 6 3⁄4 in)','Betty Heidler (GER)','21 May 2011','Halle'),
       (3,3,'78.80 m (258 ft 6 1⁄4 in)','Tatyana Lysenko (RUS)','16 August 2013','Moscow'),
       (4,4,'78.24 m (256 ft 8 1⁄4 in)','DeAnna Price (USA)','27 July 2019','Des Moines'),
       (5,5,'77.78 m (255 ft 2 in)','Gwen Berry (USA)','8 June 2018','Chorzów'),
       (6,6,'77.68 m (254 ft 10 1⁄4 in)','Wang Zheng (CHN)','29 March 2014','Chengdu'),
       (7,7,'77.33 m (253 ft 8 1⁄4 in)','Zhang Wenxiu (CHN)','28 September 2014','Incheon'),
       (8,8,'77.32 m (253 ft 8 in)','Aksana Miankova (BLR)','29 June 2008','Minsk'),
       (9,9,'77.26 m (253 ft 5 1⁄2 in)','Gulfiya Agafonova (RUS)','12 June 2006','Tula'),
       (10,10,'77.13 m (253 ft 1⁄2 in)','Oksana Kondratyeva (RUS)','30 June 2013','Zhukovskiy'),
       (11,11,'76.90 m (252 ft 3 1⁄2 in)','Martina Hrašnová (SVK)','16 May 2009','Trnava'),
       (12,12,'76.85 m (252 ft 1 1⁄2 in)','Malwina Kopron (POL)','26 August 2017','Taipei'),
       (13,13,'76.83 m (252 ft 3⁄4 in)','Kamila Skolimowska (POL)','11 May 2007','Doha'),
       (14,14,'76.75 m (251 ft 9 1⁄2 in)','Brooke Andersen (USA)','2 June 2019','Rathdrum'),
       (15,15,'76.72 m (251 ft 8 1⁄4 in)','Mariya Bespalova (RUS)','23 June 2012','Zhukovsky'),
       (16,16,'76.66 m (251 ft 6 in)','Volha Tsander (BLR)','23 June 2006','Minsk'),
       (17,17,'76.63 m (251 ft 4 3⁄4 in)','Yekaterina Khoroshikh (RUS)','23 June 2006','Zhukovsky'),
       (18,18,'76.62 m (251 ft 4 1⁄2 in)','Yipsi Moreno (CUB)','9 September 2008','Zagreb'),
       (19,19,'76.56 m (251 ft 2 in)','Alena Matoshka (BLR)','12 June 2012','Minsk'),
       (20,20,'76.33 m (250 ft 5 in)','Darya Pchelnik (BLR)','29 June 2008','Minsk'),
       (21,21,'76.26 m (250 ft 2 1⁄4 in)','Hanna Malyshik (BLR)','27 April 2018','Brest'),
       (22,22,'76.21 m (250 ft 1⁄4 in)','Yelena Konevtseva (RUS)','26 May 2007','Sochi'),
       (23,23,'76.17 m (249 ft 10 3⁄4 in)','Anna Bulgakova (RUS)','24 July 2013','Moscow'),
       (24,24,'76.07 m (249 ft 6 3⁄4 in)','Mihaela Melinte (ROU)','29 August 1999','Rüdlingen'),
       (25,25,'76.05 m (249 ft 6 in)','Kathrin Klaas (GER)','10 August 2012','London');