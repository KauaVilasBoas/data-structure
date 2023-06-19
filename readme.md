# Data Structure - Pilha, Fila, Lista Ligada e Arvore

Este é um projeto que implementa uma simulacão de como funciona uma pilha, fila, lista e arvore em estrutura de dados, pra desenvolver as funcionalidades da pilha, foi usado java e spring para o backend e no frontend foi utilizado bootstrap e ajax com jquery.

## Teste em Produção

https://data-structure-production-a118.up.railway.app/index.html

## Tecnologias Utilizadas

- Java 11
- Spring / Spring Boot
- HTML
- CSS
- JavaScript
- Ajax
- jQuery
- Bootstrap

## Funcionalidades do Sistema

- Criar Pilha;
- Mudar tamanho da pilha;
- Empilhar;
- Desempilhar;
- Criar Fila;
- Mudar tamanho da fila;
- Efileirar;
- Desenfileirar;
- Criar Lista Ligada
- Inserir no meio da Lista
- Inserir no fim da Lista
- Inserir no inicio da Lista
- Remover no inicio da Lista
- Inserir no fim da Lista
- Buscar Lista
- Criar Arvore
- Adicionar valor da Arvore
- Remover valor da Arvore
- Buscar Arvore

## Configure e execute

1. Certifique-se de ter o JDK (Java Development Kit) instalado em seu sistema. Você pode verificar digitando java -version no terminal. Se não estiver instalado, você precisará instalá-lo.

2. Certifique-se de ter o Maven instalado em seu sistema. O Maven é uma ferramenta de automação de compilação e gerenciamento de dependências para projetos Java. Verifique digitando mvn -version no terminal. Se não estiver instalado, você precisará instalá-lo.

3. Abra o terminal e navegue até o diretório raiz do seu projeto Spring. O diretório raiz geralmente contém o arquivo pom.xml.

4. Execute o seguinte comando para compilar o projeto e empacotá-lo em um arquivo JAR:
```shell
   mvn clean package    
```
Isso irá compilar o código-fonte, executar os testes e gerar o arquivo JAR no diretório "target".

5. Depois que o pacote JAR for gerado com sucesso, você poderá executá-lo com o comando java -jar seguido do nome do arquivo JAR. Por exemplo:
```shell
   java -jar target/meuapp.jar    
```
Substitua "meuapp.jar" pelo nome real do seu arquivo JAR.

6. O aplicativo Spring será iniciado e começará a ser executado. Você verá as mensagens de log e, se tudo estiver configurado corretamente, poderá acessar o aplicativo em um navegador da web no endereço "http://localhost:8080" (ou outro endereço e porta, dependendo da configuração do seu aplicativo Spring).

## Endpoints

## Pilha

|   Endpoints   |  Query Parameters  |    Verb    |
| :---         |     :---:      |          ---: |
| /api/pilha/push       |   *  |   POST    |
| /api/pilha   |   *  | GET    |
| /api/pilha/pop        |   *  | GET   |
| /api/pilha/{tamanho}   |   *  | GET    |

<details>
  <summary>EMPILHAR - /api/pilha/push </summary>
  
### Descrição

- Empilha um valor na pilha.

### Códigos de Resposta

- `201`: Empilhado com sucesso.

- `400`: Pilha Cheia.

### Exemplo de Requisição

- POST -  /api/pilha/push 
- HTTP/1.1
- Host: example.com 
- Content-Type: application/json

```json
    {
        "valor":"3"
    }    
```

### Exemplo de Resposta

- HTTP/1.1 201 CREATED
- Content-Type: application/json
```json
    Empilhado com sucesso
```
  
</details>

<details>
  <summary>GET PILHA - /api/pilha </summary>
  
### Descrição

Retorna a pilha e a posicao do topo da pilha.

### Códigos de Resposta

- `200`: Pilha retornado com sucesso.

### Exemplo de Requisição

- GET - /api/pilha 
- HTTP/1.1
- Host: example.com

### Exemplo de Resposta

- HTTP/1.1 200 OK
- Content-Type: application/json
```json
    {
	"lista": [],
	"topo": 0
    } 
```
  
</details>

<details>
  <summary>DESEMPILHAR - /api/pilha/pop</summary>
  
### Descrição

Desempilha o valor do topo da pilha.

### Códigos de Resposta

- `200`: Desempilhado com sucesso.

### Exemplo de Requisição

- GET - /api/pilha/pop
- HTTP/1.1
- Host: example.com

### Exemplo de Resposta

- HTTP/1.1 - 200 OK
```json
    6   
```
</details>

<details>
  <summary>SET CAPACIDADE - /api/pilha/{tamanho} </summary>
  
### Descrição

Cria uma pilha com a capacidade passada no parametro.

## Parâmetros de Entrada

- `tamanho` (obrigatório): Capacidade da pilha.

### Códigos de Resposta

- `200`: Pilha criada com sucesso.

### Exemplo de Requisição

- GET /api/pilha/5
- Host: example.com

### Exemplo de Resposta

HTTP/1.1 200 OK

```json
    {
        "5"
    }    
```
  
</details>


## Fila

|   Endpoints   |  Query Parameters  |    Verb    |
| :---          |     :---:          |       ---: |
| /api/fila/queue       |   *        |     POST   |
| /api/fila     |           *        |     GET    |
| /api/fila/unqueue       | *        |     GET    |
| /api/fila/{tamanho}   |   *        |     GET    |

<details>
  <summary>ENFILEIRAR - /api/fila/queue </summary>
  
### Descrição

- Enfileira um valor na fila.

### Códigos de Resposta

- `201`: Enfileirado com sucesso.

- `400`: Fila Cheia.

### Exemplo de Requisição

- POST - api/fila/queue
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app
- Content-Type: application/json

```json
    {
        "valor":"3"
    }    
```

### Exemplo de Resposta

- HTTP/1.1 201 CREATED
- Content-Type: application/json
```json
    Enfileirado com sucesso
```
  
</details>

<details>
  <summary>GET FILA - /api/fila </summary>
  
### Descrição

Retorna a fila e a posicao do topo da pilha.

### Códigos de Resposta

- `200`: Fila retornada com sucesso.
- `400`: Fila vazia.

### Exemplo de Requisição

- GET - /api/fila
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

- HTTP/1.1 200 OK
- Content-Type: application/json
```json
    {
	"lista": [],
	"inicio": 0,
	"fim": 4
}
```
  
</details>

<details>
  <summary>DESENFILEIRAR - /api/fila/unqueue</summary>
  
### Descrição

Desenfileira o valor do inicio da fila e retorna-o como resposta.

### Códigos de Resposta

- `200`: 6.
- `400`: Fila vazia.

### Exemplo de Requisição

- GET - /api/fila/unqueue
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

- HTTP/1.1 - 200 OK
```json
    6   
```
</details>

<details>
  <summary>SET CAPACIDADE - /api/fila//{size} </summary>
  
### Descrição

Cria uma fila com a capacidade passada no parametro.

## Parâmetros de Entrada

- `size` (obrigatório): Capacidade da fila.

### Códigos de Resposta

- `200`: 5.

### Exemplo de Requisição

- GET /api/pilha/5
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

HTTP/1.1 200 OK

	"6"

  
</details>


## Lista Ligada

|   Endpoints   |  Query Parameters  |    Verb    |
| :---          |     :---:          |       ---: |
| /api/lista/addMeio       |   *        |     POST   |
| /api/lista/addFim      |   *        |     POST   |
| /api/lista/addInicio       |   *        |     POST   |
| /api/lista/removerInicio     |           *        |     DELETE |
| /api/lista/removerFim       | *        |     DELETE |
| /api/lista/listarLista   |   *        |     GET    |

<details>
  <summary>Adcionar no Meio - /api/lista/addMeio </summary>
  
### Descrição

- Enfileira um valor na fila.

### Códigos de Resposta

- `201`: Enfileirado com sucesso.

- `400`: Fila Cheia.

### Exemplo de Requisição

- POST - api/fila/queue
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app
- Content-Type: application/json

```json
    {
        "valor":"3"
    }    
```

### Exemplo de Resposta

- HTTP/1.1 201 CREATED
- Content-Type: application/json
```json
    Enfileirado com sucesso
```
  
</details>

<details>
  <summary>Adcionar no Inicio - /api/lista/addInicio </summary>
  
### Descrição

Retorna a fila e a posicao do topo da pilha.

### Códigos de Resposta

- `200`: Fila retornada com sucesso.
- `400`: Fila vazia.

### Exemplo de Requisição

- GET - /api/fila
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

- HTTP/1.1 200 OK
- Content-Type: application/json
```json
    {
	"lista": [],
	"inicio": 0,
	"fim": 4
}
```
  
</details>

<details>
  <summary>Adcionar no Fim - /api/lista/addFim </summary>
  
### Descrição

Desenfileira o valor do inicio da fila e retorna-o como resposta.

### Códigos de Resposta

- `200`: 6.
- `400`: Fila vazia.

### Exemplo de Requisição

- GET - /api/fila/unqueue
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

- HTTP/1.1 - 200 OK
```json
    6   
```
</details>

<details>
  <summary>Remover Inicio - /api/lista/removerInicio </summary>
  
### Descrição

Cria uma fila com a capacidade passada no parametro.

## Parâmetros de Entrada

- `size` (obrigatório): Capacidade da fila.

### Códigos de Resposta

- `200`: 5.

### Exemplo de Requisição

- GET /api/pilha/5
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

HTTP/1.1 200 OK

	"6"
  
</details>

<details>
  <summary>Remover no Fim - /api/lista/removerFim </summary>
  
### Descrição

- Enfileira um valor na fila.

### Códigos de Resposta

- `201`: Enfileirado com sucesso.

- `400`: Fila Cheia.

### Exemplo de Requisição

- POST - api/fila/queue
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app
- Content-Type: application/json

```json
    {
        "valor":"3"
    }    
```

### Exemplo de Resposta

- HTTP/1.1 201 CREATED
- Content-Type: application/json
```json
    Enfileirado com sucesso
```
  
</details>

<details>
  <summary>GET Lista - /api/lista/listarLista </summary>
  
### Descrição

Cria uma fila com a capacidade passada no parametro.

## Parâmetros de Entrada

- `size` (obrigatório): Capacidade da fila.

### Códigos de Resposta

- `200`: 5.

### Exemplo de Requisição

- GET /api/pilha/5
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

HTTP/1.1 200 OK

	"6"
  
</details>

## Arvore

|   Endpoints   |  Query Parameters  |    Verb    |
| :---          |     :---:          |       ---: |
| /api/tree     |   *                |     GET    |
| /api/tree/add |           *        |     POST   |
| /api/tree/remove  | *              |     DELETE |

<details>
  <summary>Get arvore - /api/tree </summary>
  
### Descrição

- Enfileira um valor na fila.

### Códigos de Resposta

- `201`: Enfileirado com sucesso.

- `400`: Fila Cheia.

### Exemplo de Requisição

- POST - api/fila/queue
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app
- Content-Type: application/json

```json
    {
        "valor":"3"
    }    
```

### Exemplo de Resposta

- HTTP/1.1 201 CREATED
- Content-Type: application/json
```json
    Enfileirado com sucesso
```
  
</details>

<details>
  <summary>Adicionar - /api/tree/add </summary>
  
### Descrição

Retorna a fila e a posicao do topo da pilha.

### Códigos de Resposta

- `200`: Fila retornada com sucesso.
- `400`: Fila vazia.

### Exemplo de Requisição

- GET - /api/fila
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

- HTTP/1.1 200 OK
- Content-Type: application/json
```json
    {
	"lista": [],
	"inicio": 0,
	"fim": 4
}
```
  
</details>

<details>
  <summary>Remover - /api/tree/remove </summary>
  
### Descrição

Desenfileira o valor do inicio da fila e retorna-o como resposta.

### Códigos de Resposta

- `200`: 6.
- `400`: Fila vazia.

### Exemplo de Requisição

- GET - /api/fila/unqueue
- HTTP/1.1
- Host: https://data-structure-production.up.railway.app

### Exemplo de Resposta

- HTTP/1.1 - 200 OK
```json
    6   
```
</details>

![Screenshot from 2023-06-18 23-44-16](https://github.com/diogoribeiro1/data-structure/assets/89152312/db7e7c0b-377a-4dc5-9186-8bf337d8eb60)
![Screenshot from 2023-06-18 23-44-25](https://github.com/diogoribeiro1/data-structure/assets/89152312/fb529f57-2af8-4554-95e8-d2c93620dabb)
![Screenshot from 2023-06-18 23-44-29](https://github.com/diogoribeiro1/data-structure/assets/89152312/112cfd1f-dcc3-4b73-8f8b-88bddadeeec7)
![Screenshot from 2023-06-18 23-44-34](https://github.com/diogoribeiro1/data-structure/assets/89152312/8ffd5e38-b63c-47ff-98ba-50816d7440e7)
![Screenshot from 2023-06-18 23-44-57](https://github.com/diogoribeiro1/data-structure/assets/89152312/d96859ce-6618-4a73-8e7a-226730b80d37)



