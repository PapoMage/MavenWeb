-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2017 a las 06:22:26
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `blog_maven`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `POST_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comment`
--

INSERT INTO `comment` (`id`, `content`, `date`, `POST_ID`, `USER_ID`) VALUES
(5451, 'Muy buen post facha', '2017-11-20 02:10:02', 5401, 2),
(5452, 'Posta', '2017-11-20 02:10:30', 5402, 1),
(5453, 'Gracias capo', '2017-11-20 02:10:49', 5401, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagepost`
--

CREATE TABLE `imagepost` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imageuser`
--

CREATE TABLE `imageuser` (
  `id` int(11) NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `openjpa_sequence_table`
--

CREATE TABLE `openjpa_sequence_table` (
  `ID` tinyint(4) NOT NULL,
  `SEQUENCE_VALUE` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `openjpa_sequence_table`
--

INSERT INTO `openjpa_sequence_table` (`ID`, `SEQUENCE_VALUE`) VALUES
(0, 5601);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `contenido` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `IMAGE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `post`
--

INSERT INTO `post` (`id`, `contenido`, `date`, `user_id`, `IMAGE_ID`) VALUES
(5401, 'Probando post', '2017-11-20 02:09:31', 1, NULL),
(5402, 'Que buen dia', '2017-11-20 02:10:12', 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  `IMAGE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `email`, `name`, `password`, `is_admin`, `IMAGE_ID`) VALUES
(1, 'martinbobbio1@gmail.com', 'Tincho', '1234', 1, NULL),
(2, 'pablofernandez@gmail.com', 'Papo', '1234', 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `I_COMMENT_POST` (`POST_ID`),
  ADD KEY `I_COMMENT_USER` (`USER_ID`);

--
-- Indices de la tabla `imagepost`
--
ALTER TABLE `imagepost`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `imageuser`
--
ALTER TABLE `imageuser`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `openjpa_sequence_table`
--
ALTER TABLE `openjpa_sequence_table`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `I_POST_USER` (`user_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
