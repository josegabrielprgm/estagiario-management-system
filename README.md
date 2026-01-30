# Sistema de Gerenciamento de Estagiários

Projeto desenvolvido em **Java** com integração a **MySQL**, utilizando **JDBC** e o padrão **DAO**, com o objetivo de consolidar conceitos de persistência de dados, organização de código e boas práticas de desenvolvimento backend.

## 🛠 Tecnologias Utilizadas
- Java
- JDBC
- MySQL
- Eclipse IDE
- Git / GitHub

## 📌 Funcionalidades
- Cadastrar estagiários
- Listar estagiários cadastrados
- Remover estagiários pelo CPF
- Persistência de dados em banco de dados relacional

## 🗂 Estrutura do Projeto
- `domain` → Classes de domínio (Entidades)
- `db` → Conexão com banco de dados e DAO
- `SistemaEstagiario` → Classe principal (interface via console)

## 💾 Banco de Dados
O sistema utiliza MySQL. A tabela principal é:

```sql
CREATE TABLE estagiario (
  cpf VARCHAR(14) PRIMARY KEY,
  nome VARCHAR(100),
  tel INT,
  idade INT
);
