
# Projeto Desafio Mantis 
  
Este projeto foi criado com o intuito de aprender sobre o RESTASSURED e cumprir metas de um desafio de automação de APIREST.

O sistema alvo é o [Mantis BugTracker](https://www.mantisbt.org) e é utilizado o Docker para gestão do ambiente e banco de dados.

# 1. Preparação do ambiente Mantis

Serão necessárias as seguinte configurações para iniciar o projeto:

-Foi utilizado com o DockerToolBox para instalação do DockerQuickStartTerminal e VirtualBox

**Docker-compose:**  neste repositório é possível encontrar um arquivo chamado "docker-compose.yml", este arquivo contem um grupo de imagens do Mantis, seu banco de dados e o Jenkins onde vai rodar o ambiente de CI. 

## **1.1 Setup Docker Mantis**

1.  Instalar a Máquina Virtual (Virtual Box)
2.  Instalar o DockerToolbox

3.  Abra o aplicativo Docker QuickstartTerminal

![](https://i.stack.imgur.com/GFc3Z.png)

4.  Deverá ser apresentado o tutorial, basta dar skip que você terá esta tela

5.  Abra um terminal e acesse o diretório onde contém o arquivo do docker-compose

6.  No diretório haverá o arquivo **docker-compose.yml**

7.  Execute o comando> `docker-compose.exe up -d`

8.  Após o processamento se tudo correr bem, as imagens serão baixadas e novos contêineres criados:

9.  Para validar a criação e execução dos execute o comando `docker ps -a` e os contêineres estarão disponíveis e executando:
  

## **1.2 Configuração inicial Mantis**

Faça o seu primeiro acesso ao Mantis pelo endereço http://127.0.0.1:8989

Após acessar será necessário configurar o banco de dados conforme tabela e valores abaixo:

| Variável | Valor |
|-----|------|
| Type of Database | MySQL Improved |
| Hostname (for Database Server) |192.168.99.101 |
| Username (for Database) | mantisbt |
| Password (for Database) | mantisbt |
| Database name (for Database) | bugtracker |
| Admin Username (to create Database if required) | root |
| Admin Password (to create Database if required) | root |

Após preencher, clicar em **Login/Continue** e aguardar o processamento.

O primeiro acesso deverá ser feito utilizando as credenciais *administrator/root*. Redefinir a senha para o valor *administrator* ou outro valor fácil de lembrar.

  

## **1.3 Acessar banco de dados Mantis/MariaDB**

Para acessar ao banco de dados do Mantis (MariaDB) siga os passos abaixo:

1. Baixe e instale o [software HeidiSQL](https://www.heidisql.com/download.php)

2. Ao abrir o Gerenciador de sessões, preencha com os valores abaixo:

![](https://i.imgur.com/AhKMxvu.png)

3. Abra a conexão e será possível verificar todas as tabelas e registros:

![](https://i.imgur.com/EnYk6Md.png)

## 2. Mantis Bug Tracker REST API

Uma vez com a aplicação sendo executada pelo Docker, é possível também realizar testes manuais ou automatizados de API Rest no Mantis.

Basta acessar a [documentação oficial Mantis Bug Tracker REST API](https://documenter.getpostman.com/view/29959/mantis-bug-tracker-rest-api/7Lt6zkP) para visualizar cada endpoint, parâmetros, headers correspondentes.

![](https://i.imgur.com/rLg6Q54.png)

É possível também importar todos os endpoints diretamente no Postman para testar ou automatizar esta API Rest. Basta clicar no botão indicado:


### O Token é um parâmetro esssencial nas requisições do Mantis Bug Tracker REST API, para gerá-lo:

1. Acesse o sistema Mantis com o usuário administrador - http://127.0.0.1:8989

2. Acesse o menu com nome do usuário/Minha Conta

![](https://i.imgur.com/6OHC06W.png)

3. Clique na aba **Tokens API** 

4. Preencha um novo nome para o token e clique em **Criar Token API**

![](https://i.imgur.com/wp7IIFh.png)

5. Copie o Token gerado e use-o como header em requisições nas suas automações (RestSharp, Postman, SuperTest, RestAssured e demais).

![](https://i.imgur.com/7sybiId.png)

Para a instância local deverá ser usada a url de parâmetro **localhost** com a porta correspondente **8989**. 
Exemplo de execução no Postman:

![](https://i.imgur.com/sSofy8o.png)

## 3. Definições Sobre Projeto

## 4. Jenkins
Para a execução remota dos testes automatizados, via selenum grid, serão utilizados os seguintes passos:

  

- Configuração dos contêineres hub, node chrome e node mozilla

- Verificação do console

  








