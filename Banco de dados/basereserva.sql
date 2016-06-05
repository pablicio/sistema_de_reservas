-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Máquina: localhost
-- Data de Criação: 28-Maio-2016 às 01:47
-- Versão do servidor: 5.5.28
-- versão do PHP: 5.3.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de Dados: `basereserva`
--
CREATE DATABASE IF NOT EXISTS `basereserva` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `basereserva`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `cod_pessoa` int(11) NOT NULL,
  `cod_cliente` varchar(10) NOT NULL,
  PRIMARY KEY (`cod_pessoa`),
  UNIQUE KEY `codigo_cliente_UNIQUE` (`cod_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`cod_pessoa`, `cod_cliente`) VALUES
(5, '2142'),
(4, '558877');

-- --------------------------------------------------------

--
-- Estrutura da tabela `consumo`
--

CREATE TABLE IF NOT EXISTS `consumo` (
  `cod_consumo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_reserva` int(11) NOT NULL,
  `cod_produto` int(11) NOT NULL,
  `quantidade` decimal(7,2) NOT NULL,
  `preco_venda` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`cod_consumo`),
  KEY `fk_consumo_producto_idx` (`cod_produto`),
  KEY `fk_consumo_reserva_idx` (`cod_reserva`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `consumo`
--

INSERT INTO `consumo` (`cod_consumo`, `cod_reserva`, `cod_produto`, `quantidade`, `preco_venda`, `estado`) VALUES
(1, 2, 3, '8.00', '30.00', 'Aceptado'),
(2, 2, 2, '88.00', '10.00', 'Aceito'),
(3, 3, 2, '10.00', '10.00', 'Aceito'),
(4, 3, 3, '10.00', '30.00', 'Aceito');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `cod_pessoa` int(11) NOT NULL,
  `salario` decimal(7,2) NOT NULL,
  `acesso` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_pessoa`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`cod_pessoa`, `salario`, `acesso`, `login`, `senha`, `estado`) VALUES
(6, '11445.00', 'Digitador', 't', '1', 'A'),
(7, '65.00', 'Administrador', '2', '2', 'A');

-- --------------------------------------------------------

--
-- Estrutura da tabela `habitacao`
--

CREATE TABLE IF NOT EXISTS `habitacao` (
  `cod_habitacao` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(4) NOT NULL,
  `piso` varchar(2) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `caracteristicas` varchar(512) DEFAULT NULL,
  `preco_diaria` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `tipo_habitacao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cod_habitacao`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `habitacao`
--

INSERT INTO `habitacao` (`cod_habitacao`, `numero`, `piso`, `descricao`, `caracteristicas`, `preco_diaria`, `estado`, `tipo_habitacao`) VALUES
(6, '2', '4', 'la cancha de su madre', 'la canjicta de galinha', '100.00', 'Disponivel', 'Individual'),
(7, '1', '1', 'nossa tou boba', 'arara mahoe', '200.00', 'Em Manutenção', 'Familiar');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE IF NOT EXISTS `pagamento` (
  `cod_pagamento` int(11) NOT NULL AUTO_INCREMENT,
  `cod_reserva` int(11) NOT NULL,
  `tipo_comprovante` varchar(20) NOT NULL,
  `num_comprovante` varchar(20) NOT NULL,
  `igv` decimal(4,2) NOT NULL,
  `total_pagamento` decimal(7,2) NOT NULL,
  `data_emissao` date NOT NULL,
  `data_pagamento` date NOT NULL,
  PRIMARY KEY (`cod_pagamento`),
  KEY `fk_pago_reserva_idx` (`cod_reserva`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `pagamento`
--

INSERT INTO `pagamento` (`cod_pagamento`, `cod_reserva`, `tipo_comprovante`, `num_comprovante`, `igv`, `total_pagamento`, `data_emissao`, `data_pagamento`) VALUES
(1, 2, 'Boleto', '2', '2.00', '248.00', '2016-05-05', '2016-05-12'),
(3, 3, 'Ticket', '65', '65.00', '200.00', '2016-05-05', '2016-05-05'),
(4, 3, 'Boleto', '33', '33.00', '33.00', '2016-05-05', '2016-05-05');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
  `cod_pessoa` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `pai` varchar(20) NOT NULL,
  `mae` varchar(20) NOT NULL,
  `tipo_documento` varchar(15) NOT NULL,
  `num_documento` varchar(8) NOT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `telefone` varchar(8) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`cod_pessoa`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefono_UNIQUE` (`telefone`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`cod_pessoa`, `nome`, `pai`, `mae`, `tipo_documento`, `num_documento`, `endereco`, `telefone`, `email`) VALUES
(4, 'Thiago', 'Não sei', 'Elidia Cabral', 'DNI', '09805888', 'não sei porra!', '99885588', 'alias@gegue.com'),
(5, 'Elidia', 'Severino', 'Maria', 'LM', '5245', 'Rua Piaui', '85', 'lidia@gmail.com'),
(6, 'Thiago', 'Deus', 'Leda', 'CE', '34', 'rua a', '55596', 'as@gd.com'),
(7, 'df', 'df', 'sfd', 'LM', 'sds', 'dfs', '53', 'ret');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `cod_produto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `unidade_medida` varchar(20) NOT NULL,
  `preco_venda` decimal(7,2) NOT NULL,
  PRIMARY KEY (`cod_produto`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`cod_produto`, `nome`, `descricao`, `unidade_medida`, `preco_venda`) VALUES
(2, 'mortadela', 'vermelhinha e com toucinho', 'GLB', '10.00'),
(3, 'pão', 'pão é muito bom, enche o bucho de montão', 'KG', '30.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `reserva`
--

CREATE TABLE IF NOT EXISTS `reserva` (
  `cod_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `cod_habitacao` int(11) NOT NULL,
  `cod_cliente` int(11) NOT NULL,
  `cod_funcionario` int(11) NOT NULL,
  `tipo_reserva` varchar(20) NOT NULL,
  `data_reserva` date NOT NULL,
  `data_entrada` date NOT NULL,
  `data_saida` date NOT NULL,
  `custo_hospedagem` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`cod_reserva`),
  KEY `fk_reserva_habitacion_idx` (`cod_habitacao`),
  KEY `fk_reserva_cliente_idx` (`cod_cliente`),
  KEY `fk_reserva_trabajador_idx` (`cod_funcionario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `reserva`
--

INSERT INTO `reserva` (`cod_reserva`, `cod_habitacao`, `cod_cliente`, `cod_funcionario`, `tipo_reserva`, `data_reserva`, `data_entrada`, `data_saida`, `custo_hospedagem`, `estado`) VALUES
(1, 3, 4, 7, 'Alquiler', '2016-05-05', '2016-05-17', '2016-05-02', '78.00', 'Paga'),
(2, 1, 5, 7, 'Reserva', '2016-05-13', '2016-05-05', '2016-05-07', '8.00', 'Paga'),
(3, 6, 4, 7, 'Reserva', '2016-05-12', '2016-05-05', '2016-05-11', '100.00', 'Paga');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_persona_cliente` FOREIGN KEY (`cod_pessoa`) REFERENCES `pessoa` (`cod_pessoa`);

--
-- Limitadores para a tabela `consumo`
--
ALTER TABLE `consumo`
  ADD CONSTRAINT `fk_consumo_producto` FOREIGN KEY (`cod_produto`) REFERENCES `produto` (`cod_produto`);

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_persona_trabajador` FOREIGN KEY (`cod_pessoa`) REFERENCES `pessoa` (`cod_pessoa`);

--
-- Limitadores para a tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `fk_pago_reserva` FOREIGN KEY (`cod_reserva`) REFERENCES `reserva` (`cod_reserva`);

--
-- Limitadores para a tabela `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_reserva_cliente` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`cod_pessoa`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
