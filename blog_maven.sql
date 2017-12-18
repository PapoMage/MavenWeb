-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-12-2017 a las 23:17:56
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.6.24

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
  `content` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `POST_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `comment`
--

INSERT INTO `comment` (`id`, `content`, `date`, `POST_ID`, `USER_ID`) VALUES
(2451, 'Felicidades por tu primer post!', '2017-12-17 19:10:47', 2301, 51);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `favorite`
--

CREATE TABLE `favorite` (
  `id` int(11) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `POST_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `favorite`
--

INSERT INTO `favorite` (`id`, `status`, `POST_ID`, `USER_ID`) VALUES
(2401, b'1', 2301, 51),
(2402, b'1', 2301, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `follower`
--

CREATE TABLE `follower` (
  `id` int(11) NOT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `USERFOLLOW_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `follower`
--

INSERT INTO `follower` (`id`, `USER_ID`, `USERFOLLOW_ID`) VALUES
(2501, 1, 751);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `path` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagepost`
--

CREATE TABLE `imagepost` (
  `id` int(11) NOT NULL,
  `path` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `imagepost`
--

INSERT INTO `imagepost` (`id`, `path`, `size`, `type`) VALUES
(1451, 'zd9twjl2fz', 282837, 'image/jpeg'),
(1452, '5o7spit070', 5298, 'image/jpeg'),
(1901, '8gz0sg3qke', 282837, 'image/jpeg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imageuser`
--

CREATE TABLE `imageuser` (
  `id` int(11) NOT NULL,
  `path` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `imageuser`
--

INSERT INTO `imageuser` (`id`, `path`, `size`, `type`) VALUES
(2351, 'n229to4yol', 21088, 'image/jpeg');

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
(0, 2551);

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
(2301, 'Mi primer post! :D', '2017-12-17 19:08:17', 751, NULL);

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
(1, 'martinbobbio1@gmail.com', 'Martin', '1234', 1, NULL),
(51, 'pablofernandez@gmail.com', 'Papo', '1234', 1, NULL),
(751, 'test@gmail.com', 'Test', '12345678', 0, 2351);

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
-- Indices de la tabla `favorite`
--
ALTER TABLE `favorite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `I_FVORITE_POST` (`POST_ID`),
  ADD KEY `I_FVORITE_USER` (`USER_ID`);

--
-- Indices de la tabla `follower`
--
ALTER TABLE `follower`
  ADD PRIMARY KEY (`id`),
  ADD KEY `I_FOLLOWR_USER` (`USER_ID`),
  ADD KEY `I_FOLLOWR_USERFOLLOW` (`USERFOLLOW_ID`);

--
-- Indices de la tabla `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`);

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
