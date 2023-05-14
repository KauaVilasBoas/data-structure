# Data Structure - Pilha e Fila

Este é um projeto que implementa uma simulacao de como funciona uma pilha e uma fila em estrutura de dados, pra desenvolver as funcionalidades da pilha, foi usado java e spring para o backend  e no frontend foi utilizado bootsrap e ajax com jquery.

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
  <summary>GET FILA - /api/fila </summary>
  
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
  <summary>DESENFILEIRAR - /api/fila/unqueue</summary>
  
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
  <summary>SET CAPACIDADE - /api/fila/{tamanho} </summary>
  
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
