-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2018 a las 07:52:16
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tiendaequipo1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `correo`, `estado`) VALUES
(1, 'Raul', 'Contreras', 'raulCon@gmail.com', 1),
(2, 'Miguel', 'Martinez', 'miguelMa@gmail.com', 1),
(3, 'Alma', 'Rios', 'almaRi@gmail.com', 1),
(4, 'Felipe', 'Enrriquez', 'felipeEn@gmail.com', 0),
(11, 'Oscar', 'Velasco', 'tovo@gmail.com', 1),
(12, 'Indira', 'Moreno', 'indy@hotmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE IF NOT EXISTS `detalle` (
  `id_detalle` int(4) NOT NULL AUTO_INCREMENT,
  `id_producto` int(4) DEFAULT NULL,
  `cantidad` int(10) DEFAULT NULL,
  `monto` decimal(10,0) DEFAULT NULL,
  `id_factura` int(4) DEFAULT NULL,
  PRIMARY KEY (`id_detalle`),
  KEY `id_producto` (`id_producto`),
  KEY `id_factura` (`id_factura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=132 ;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`id_detalle`, `id_producto`, `cantidad`, `monto`, `id_factura`) VALUES
(80, 10, 1, '1000', 253),
(81, 6, 1, '300', 253),
(82, 4, 1, '1200', 253),
(83, 30, 1, '4000', 254),
(84, 29, 1, '10000', 254),
(85, 25, 1, '1000', 255),
(86, 26, 1, '12000', 255),
(87, 4, 1, '1200', 255),
(88, 6, 1, '300', 255),
(89, 6, 1, '300', 258),
(90, 6, 1, '300', 259),
(91, 5, 1, '600', 259),
(92, 12, 1, '500', 260),
(93, 11, 1, '300', 260),
(94, 6, 1, '300', 261),
(95, 12, 1, '500', 262),
(96, 10, 1, '1000', 262),
(97, 18, 1, '1200', 263),
(98, 19, 1, '600', 263),
(99, 24, 1, '600', 264),
(100, 24, 1, '600', 264),
(101, 25, 1, '1000', 265),
(102, 26, 1, '12000', 265),
(103, 4, 1, '1200', 265),
(104, 3, 1, '500', 265),
(105, 2, 1, '1000', 265),
(106, 2, 1, '1000', 265),
(107, 3, 1, '500', 265),
(108, 3, 1, '500', 268),
(109, 4, 1, '1200', 268),
(110, 3, 1, '500', 269),
(111, 4, 1, '1200', 269),
(112, 4, 1, '1200', 269),
(113, 11, 1, '300', 269),
(114, 4, 1, '1200', 269),
(115, 6, 1, '300', 269),
(116, 4, 1, '1200', 269),
(117, 11, 1, '300', 269),
(118, 13, 1, '500', 269),
(119, 4, 1, '1200', 269),
(120, 11, 1, '300', 269),
(121, 13, 1, '500', 269),
(122, 7, 1, '800', 269),
(123, 11, 1, '300', 269),
(124, 13, 1, '500', 269),
(125, 4, 1, '1200', 269),
(126, 5, 1, '600', 269),
(127, 7, 1, '800', 269),
(128, 6, 1, '300', 269),
(129, 11, 1, '300', 269),
(130, 12, 1, '500', 269),
(131, 12, 1, '500', 269);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` int(4) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(4) DEFAULT NULL,
  `id_vendedor` int(4) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `monto_total` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_vendedor` (`id_vendedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=278 ;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id_factura`, `id_cliente`, `id_vendedor`, `fecha`, `monto_total`) VALUES
(253, 3, 9, '2018-05-20', '2500'),
(254, 2, 28, '2018-05-20', '14000'),
(255, 4, 39, '2018-06-20', '13000'),
(258, 1, 9, '2018-06-20', '300'),
(259, 1, 9, '2018-06-20', '900'),
(260, 4, 9, '2018-06-20', '800'),
(261, 2, 9, '2018-06-20', '300'),
(262, 3, 9, '2018-06-20', '1500'),
(263, 11, 9, '2018-06-20', '1800'),
(264, 1, 9, '2018-06-20', '1200'),
(265, 1, 9, '2018-06-20', '14200'),
(268, 3, 9, '2018-06-20', '1700'),
(269, 1, 9, '2018-06-20', '1700');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `precio` decimal(10,0) DEFAULT NULL,
  `precio_compra` decimal(10,0) DEFAULT NULL,
  `stock` int(6) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=39 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `precio`, `precio_compra`, `stock`, `estado`) VALUES
(1, 'Gears of war 4', '1000', '850', 9, 1),
(2, 'Halo 4', '1000', '750', 1, 1),
(3, 'The Last of Us', '500', '300', 0, 1),
(4, 'God of War', '1200', '900', 8, 1),
(5, 'The Last Guardian', '600', '250', 6, 1),
(6, 'Cuphead', '300', '100', 4, 1),
(7, 'Shadow of the Colossus', '800', '650', 7, 1),
(8, 'Super Mario Odissey', '1200', '1000', 10, 0),
(9, 'Doom', '600', '450', 0, 1),
(10, 'PSP', '1000', '500', 7, 1),
(11, 'Assasins Creed', '300', '200', 13, 1),
(12, 'The Witcher 3', '500', '400', 5, 1),
(13, 'Grand Theft Auto V', '500', '350', 17, 1),
(14, 'Pokemon Sol', '800', '600', 5, 1),
(15, 'Bioshock infinite', '300', '100', 5, 1),
(16, 'Fallout 4', '800', '350', 10, 1),
(17, 'Final Fantasy XV', '800', '500', 9, 1),
(18, 'Dragon Quest XI', '1200', '950', 9, 1),
(19, 'Uncharted 4', '600', '300', 8, 1),
(21, 'Red Dead Redemption 2', '1200', '1000', 20, 1),
(22, 'Metal Gear Solid V', '350', '250', 4, 1),
(23, 'Overwatch', '800', '600', 9, 1),
(24, 'Super Smash Bros', '600', '400', 8, 1),
(25, 'Mario Kart 8', '1000', '800', 8, 1),
(26, 'Xbox One X', '12000', '10000', 18, 1),
(27, 'PlayStation 4 Pro', '12000', '10000', 20, 1),
(28, 'Dark Souls', '1200', '950', 20, 1),
(29, 'Nintendo Switch', '10000', '9000', 19, 1),
(30, 'Nintendo 3DS', '4000', '3000', 9, 1),
(31, 'Wii U', '3000', '2500', 10, 0),
(33, 'jahdhff', '500', '350', 2, 1),
(34, 'reeeretet', '506', '450', 0, 1),
(38, 'wdwdwdw', '1000', '760', 42, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE IF NOT EXISTS `vendedor` (
  `id_vendedor` int(4) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `contrasena` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `administrador` tinyint(1) DEFAULT NULL,
  `estado` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_vendedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=41 ;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`id_vendedor`, `nombre`, `apellido`, `username`, `contrasena`, `correo`, `administrador`, `estado`) VALUES
(1, 'Juan', 'Garcia', 'capibara', 'j0g4', 'juan@gmail.com', 0, 1),
(2, 'Martin', 'Martinez', 'pinguino', 'm4fe', 'martin@gmail.com', 0, 1),
(4, 'Gabriela', 'Fernandez', 'hamster', 'g4f3', 'gabrielaFe@gmail.com', 1, 0),
(9, 'Yesme', 'Morales', 'delfin', 'y35m365f', 'morales@gmail.com', 1, 1),
(28, 'Carla', 'Sosa', 'cocodrilo', 'soca12', 'carlaSosa@gmail.com', 0, 1),
(39, 'Monserrat', 'Castro', 'pika', 'm0c4sk', 'monseCa@hotmail.com', 0, 1),
(40, 'Perseo', 'Rocha', 'gato', 'p3r5r0', 'rochaPer@gmail.com', 0, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD CONSTRAINT `detalle_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_ibfk_2` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`id_vendedor`) REFERENCES `vendedor` (`id_vendedor`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
