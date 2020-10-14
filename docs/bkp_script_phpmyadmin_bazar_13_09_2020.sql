-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Tempo de geração: 14-Set-2020 às 03:23
-- Versão do servidor: 8.0.18
-- versão do PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bazar`
--
CREATE DATABASE IF NOT EXISTS `bazar` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bazar`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `cpf` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`cpf`, `nome`) VALUES
(1111, 'Antônia Maria'),
(2222, 'Josefina Rica'),
(3333, 'Jessica Freitas'),
(4444, 'Murilo Romulo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `cnpj` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`cnpj`, `nome`) VALUES
(1000, 'Marcos da Silva'),
(2000, 'Melinda Martiz'),
(3000, 'Marcelo Vitor'),
(4000, 'Marcos Cortez');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `matricula` int(11) NOT NULL,
  `cpf` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `Login_codigo` int(11) NOT NULL,
  PRIMARY KEY (`matricula`),
  KEY `fk_Funcionarios_Login1_idx` (`Login_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`matricula`, `cpf`, `nome`, `Login_codigo`) VALUES
(1, 1010, 'Jose', 1),
(2, 2020, 'Maria', 2),
(3, 3030, 'Mirela', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE IF NOT EXISTS `login` (
  `codigo` int(11) NOT NULL,
  `senha` varchar(10) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `login`
--

INSERT INTO `login` (`codigo`, `senha`) VALUES
(1, '123'),
(2, '456'),
(3, 'xpto'),
(4, '2020'),
(5, 'ola');

-- --------------------------------------------------------

--
-- Estrutura da tabela `roupa`
--

DROP TABLE IF EXISTS `roupa`;
CREATE TABLE IF NOT EXISTS `roupa` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(150) NOT NULL,
  `preco` double NOT NULL,
  `marca` varchar(100) NOT NULL,
  `tamanho` varchar(100) NOT NULL,
  `TipoProduto_codigo` int(11) NOT NULL,
  `Fornecedor_cnpf` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_Roupas_TipoProduto1_idx` (`TipoProduto_codigo`),
  KEY `fk_Roupa_Fornecedor1_idx` (`Fornecedor_cnpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `roupa`
--

INSERT INTO `roupa` (`codigo`, `descricao`, `preco`, `marca`, `tamanho`, `TipoProduto_codigo`, `Fornecedor_cnpf`) VALUES
(1, 'Calça Jeans', 209.9, 'Claven klein', 'G', 1, 1000),
(2, 'Camiseta Simples', 15.99, 'ETB', 'G', 1, 2000),
(3, 'Short Jeans', 88.9, 'Nova Jeans', '40-42', 1, 3000),
(4, 'Jaqueta Preta', 100, 'Triumph Parka', 'G', 2, 4000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipoproduto`
--

DROP TABLE IF EXISTS `tipoproduto`;
CREATE TABLE IF NOT EXISTS `tipoproduto` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tipoproduto`
--

INSERT INTO `tipoproduto` (`codigo`, `descricao`) VALUES
(1, 'ROUPA NOVA'),
(2, 'ROUPA USADA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

DROP TABLE IF EXISTS `venda`;
CREATE TABLE IF NOT EXISTS `venda` (
  `Funcionarios_matricula` int(11) NOT NULL,
  `Clientes_cpf` int(11) NOT NULL,
  `Roupa_codigo` int(11) NOT NULL,
  `dataVenda` varchar(20) NOT NULL,
  PRIMARY KEY (`Funcionarios_matricula`,`Clientes_cpf`),
  KEY `fk_Funcionarios_has_Clientes_Clientes1_idx` (`Clientes_cpf`),
  KEY `fk_Funcionarios_has_Clientes_Funcionarios_idx` (`Funcionarios_matricula`),
  KEY `fk_Venda_Roupa1_idx` (`Roupa_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`Funcionarios_matricula`, `Clientes_cpf`, `Roupa_codigo`, `dataVenda`) VALUES
(1, 1111, 1, '10/09/2020'),
(1, 2222, 1, '11/09/2020'),
(1, 3333, 2, '11/09/2020'),
(2, 1111, 4, '12/09/2020'),
(2, 4444, 3, '14/09/2020');

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fk_Funcionarios_Login1` FOREIGN KEY (`Login_codigo`) REFERENCES `login` (`codigo`);

--
-- Limitadores para a tabela `roupa`
--
ALTER TABLE `roupa`
  ADD CONSTRAINT `fk_Roupa_Fornecedor1` FOREIGN KEY (`Fornecedor_cnpf`) REFERENCES `fornecedor` (`cnpj`),
  ADD CONSTRAINT `fk_Roupas_TipoProduto1` FOREIGN KEY (`TipoProduto_codigo`) REFERENCES `tipoproduto` (`codigo`);

--
-- Limitadores para a tabela `venda`
--
ALTER TABLE `venda`
  ADD CONSTRAINT `fk_Funcionarios_has_Clientes_Clientes1` FOREIGN KEY (`Clientes_cpf`) REFERENCES `cliente` (`cpf`),
  ADD CONSTRAINT `fk_Funcionarios_has_Clientes_Funcionarios` FOREIGN KEY (`Funcionarios_matricula`) REFERENCES `funcionario` (`matricula`),
  ADD CONSTRAINT `fk_Venda_Roupa1` FOREIGN KEY (`Roupa_codigo`) REFERENCES `roupa` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
