# Anime API 🎌📺

![Finalizado](https://img.shields.io/badge/Status-Finalizado-brightgreen)

## Descrição do Projeto

Esta é uma API RESTful que fornece informações sobre animes, permitindo adicionar, atualizar, deletar e buscar animes. A busca pode ser feita por nome e episódio, mas também é possível listar todos os animes disponíveis.

## Funcionalidades 🌟

- **Adicionar Anime**: Permite cadastrar novos animes com informações como nome, episódio e data de lançamento.
- **Atualizar Anime**: Permite atualizar informações de um anime existente.
- **Deletar Anime**: Permite remover um anime.
- **Buscar Anime por Nome**: Recupera informações sobre animes com base no nome.
- **Buscar Anime por Episódio**: Obtém detalhes de um anime específico baseado no número do episódio.
- **Listar Todos os Animes**: Retorna a lista completa de animes cadastrados.

## Tecnologias Utilizadas 💻

- **Node.js**: Ambiente de execução para JavaScript.
- **Express**: Framework para criar APIs RESTful.
- **MongoDB**: Banco de dados NoSQL para armazenar informações dos animes.
- **Mongoose**: Biblioteca para modelar dados em MongoDB.

## Endpoints 📡

### 1. Adicionar Anime

- **Método**: `POST`
- **Endpoint**: `/api/animes`
- **Descrição**: Adiciona um novo anime.
- **Corpo da Requisição**:
    ```json
    {
        "nome": "Nome do Anime",
        "episodio": 1,
        "data_lancamento": "YYYY-MM-DD"
    }
    ```

### 2. Atualizar Anime

- **Método**: `PUT`
- **Endpoint**: `/api/animes/:id`
- **Descrição**: Atualiza informações de um anime existente.

### 3. Deletar Anime

- **Método**: `DELETE`
- **Endpoint**: `/api/animes/:id`
- **Descrição**: Remove um anime.

### 4. Buscar Anime por Nome

- **Método**: `GET`
- **Endpoint**: `/api/animes/nome/:nome`
- **Descrição**: Retorna os detalhes de um anime com base no nome fornecido.

### 5. Buscar Anime por Episódio

- **Método**: `GET`
- **Endpoint**: `/api/animes/episodio/:episodio`
- **Descrição**: Retorna os detalhes de um anime específico com base no número do episódio.

### 6. Listar Todos os Animes

- **Método**: `GET`
- **Endpoint**: `/api/animes`
- **Descrição**: Retorna a lista completa de animes cadastrados.

## Instruções para Execução 🚀

1. Clone o repositório:
   ```bash
   git clone <URL do repositório>
   cd <nome do repositório>
