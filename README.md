# API de Sistema de Vendas

Essas são as informações principais sobre a API de Sistema de Vendas. O projeto utiliza o Spring Boot para facilitar o desenvolvimento e a configuração da aplicação. 
O banco de dados H2 é utilizado em memória para permitir testes rápidos e facilitar a execução do projeto. O Maven é responsável pelo gerenciamento das dependências. 
O Apache Tomcat é o contêiner utilizado para executar a aplicação web.

As classes presentes na API são: "Usuário" (User), "Pedido" (Order), "Pagamento" (Payment), "Produto" (Product), "Categoria" (Category) e "Item do Pedido" (OrderItem).

A seguir está o esquema do domínio:

<p align="center">
  <img src="src\main\java\com\example\spring\files\domain.png" alt="Texto alternativo">
</p>

Alguns pontos importantes sobre o projeto:

- A arquitetura utilizada na API segue os três primeiros princípios de maturidade propostos por Leonard Richardson para arquiteturas REST.
- Também é utilizada a arquitetura MVC.
- Framework: Spring Boot
- Gerenciador de dependências: Maven
- Contêiner: Apache Tomcat
- Banco de dados: H2 (em memória, fornecido pelo Spring Boot para testes)
- Mapeamento dos endpoints:

## Usuário (User)

- GET (listar todos os usuários do banco): /users
- GET (encontrar usuário por ID): /users/{userId}
- POST: /users
- PUT: /users
- DELETE: /users

## Pedido (Order)

- GET (listar todos os pedidos do banco): /orders
- GET (encontrar pedido por ID): /orders/{orderId}
- POST: /orders
- PUT: /orders
- DELETE: /orders

## Produto (Product)

- GET (listar todos os produtos do banco): /products
- GET (encontrar produto por ID): /products/{productId}
- POST: /products
- PUT: /products
- DELETE: /products

## Categoria (Category)

- GET (listar todas as categorias do banco): /categories
- GET (encontrar categoria por ID): /categories/{categoryId}
- POST: /categories
- PUT: /categories
- DELETE: /categories
