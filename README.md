# Projeto Desafio Mantis 
  
Este projeto foi criado com o intuito de aprender sobre o RESTASSURED e cumprir metas de um desafio de automação de APIREST.

O sistema alvo é o [Mantis BugTracker](https://www.mantisbt.org) 

Durante o Desenvolvimento foram abordados os seguintes tópicos:

:point_right: Setup inicial de projeto com Docker (MariaDB, Jenkins e  Mantis BT) </br>
:point_right: Criação de testes DataDriven para Usuários e Projetos lendo de um arquivo Excel </br>
:point_right: Criação de modelo de dados para o mapeamento de entidades em bancos de dados </br>
:point_right: Desenvolvimento de operações para: Criar,Remover, Atualizar e Buscar (Issues,Projetos,Usuários, Filtros e Configurações) </br>
:point_right: Desenvolvimento de testes unitários para validação de funcionalides básicas: Criação, listagem, remoção, atualização de (Usuários,Projetos,Issues,Filtros e Configurações) </br>
:point_right:  Criação de um Script para criar uma string randomica em Java Script </br>
:point_right: Criação de testes DataDriven para Usuários e Projetos lendo de um arquivo Excel  Ambiente de CI utilizando o Jenkins

# 1. Preparação do ambiente Mantis

Serão necessárias as seguinte configurações para iniciar o projeto:

:green_book: Foi utilizado com o DockerToolBox para instalação do DockerQuickStartTerminal e VirtualBox

**Docker-compose:**  neste repositório é possível encontrar um arquivo chamado "docker-compose.yml", este arquivo contem um grupo de imagens do Mantis, seu banco de dados e o Jenkins onde vai rodar o ambiente de CI. 

## **1.1 Setup Docker Mantis**

1.  Instalar a Máquina Virtual (Virtual Box)
2.  Instalar o DockerToolbox

3.  Abra o aplicativo Docker QuickstartTerminal

![](https://i.stack.imgur.com/GFc3Z.png)

4.  Abra um terminal e acesse o diretório onde contém o arquivo do docker-compose

5.  No diretório haverá o arquivo **docker-compose.yml**

6.  Execute o comando> `docker-compose.exe up -d`

7.  Após o processamento se tudo correr bem, as imagens serão baixadas e novos contêineres criados:

8.  Para validar a criação e execução dos execute o comando `docker ps -a` e os contêineres estarão disponíveis e executando.

## **1.2 Setup VirtualBox**
1. Com o tópico 1.1 já realizado, executar no *Docker Quickstart Terminal*, o comando `docker-machine ip` e coletar a informação

2. Abrir o software VirtualBox (última versão deverá estar instalada)

3. Encontrar a imagem referente ao docker

4. Acessar "Configurações"

5. Acessar "Redes"

6. Acessar "Avançado"

7. Acessar "Redirecionamento de Portas"

8. A configuração para funcionar no docker toolbox deverá estar dessa maneira:

![enter image description here](https://i.imgur.com/nUKTsr2.png)

9. Incluir linha conforme nome "docker"

10. Protocolo: TCP

11. Endereço de Hospedeiro: 127.0.0.1

12. Porta de Hospedeiro: 80

13. IP Convidado preenchido com o valor recebido do docker (docker-machine ip default): 192.168.99.100

14. Porta do convidado: 80

MariaDb/Mantis/Jenkis:  

1. Encontrar a imagem referente ao docker

2. Acessar "Configurações"

3. Acessar "Redes"

4. Acessar "Avançado"

5. Acessar "Redirecionamento de Portas"

6. A configuração para funcionar no docker toolbox deverá estar dessa maneira:

![enter image description here](https://i.imgur.com/09lJxzV.png)

7. Incluir linha conforme nome "docker"

8. Protocolo: TCP

9. Endereço de Hospedeiro: 127.0.0.1

10. Porta de Hospedeiro: 3306

11. IP Convidado preenchido com o valor recebido do docker (docker-machine ip default): 192.168.99.101

12. Porta do convidado: 3306
13. Faça isso para o Mantis e  o Jenkins

  

## **1.2 Configuração inicial Mantis**

Faça o seu primeiro acesso ao Mantis pelo endereço http://192.168.99.101:8989
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

1. Baixe e instale o [Dbeaver](https://dbeaver.io/download/)

2. Crie uma nova conexão é configure da seguinte maneira : 

| Variável | Valor |
|-----|------|
| Server Host |localhost |
| Username | root |
| Password| root |


## 2. Mantis Bug Tracker REST API

Uma vez com a aplicação sendo executada pelo Docker, é possível também realizar testes manuais ou automatizados de API Rest no Mantis.

Basta acessar a [documentação oficial Mantis Bug Tracker REST API](https://documenter.getpostman.com/view/29959/mantis-bug-tracker-rest-api/7Lt6zkP) para visualizar cada endpoint, parâmetros, headers correspondentes.

![](https://i.imgur.com/rLg6Q54.png)

É possível também importar todos os endpoints diretamente no Postman para testar ou automatizar esta API Rest. Basta clicar no botão indicado:


### O Token é um parâmetro esssencial nas requisições do Mantis Bug Tracker REST API, para gerá-lo:

1. Acesse o sistema Mantis com o usuário administrador - http://192.168.99.101:8989/

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

## 3. Jenkins
Para a execução remota dos testes automatizados, via jenkins foi executados os seguintes passos:

1. Criação de um DockerFile, que está na pasta Utils do Projeto (atráves desse Dockerfile e criado uma imagem do Jenkins contendo o Maven)
 Execute o comando no QuickStartTerminal> `docker build -t jenkins-maven .` ex. Faça isso antes de subir o compose 
2. Acessar o endereço do Jenkins vai ter provávelmente nesse endereço : http://192.168.99.101:8081 vai ser necessário uma chave.
 Execute o comando no QuickStartTerminal> `docker exec jenkins cat /var/jenkins_home/secrets/initialAdminPassword `
 :heavy_check_mark: Crie um novo Job </br>
 
 ![jenkinsjob](https://user-images.githubusercontent.com/22267601/141997787-e4c13727-b279-4fe2-b0e7-fc4c09668da8.png) </br>
 :heavy_check_mark: Configure o Job (Nome e Tipo) </br>
 
 ![job](https://user-images.githubusercontent.com/22267601/141997722-bbba5297-4e83-41e6-a6a2-883e4f350b8c.png)
 
 :heavy_check_mark:Colocar o Projeto Git no Jenkins e Adicionar as credenciais git para baixar <br>
 
 ![adicionarChave](https://user-images.githubusercontent.com/22267601/141997302-994840f1-244c-4774-bd86-b71d4c075656.png) </br>
 
 ![codigo](https://user-images.githubusercontent.com/22267601/141997625-829ba24f-e6e1-40ad-bba3-1cf4c9cdaf57.png) </br>

3. Adicionar o Plugin o HTML Report 

 :heavy_check_mark: Gerenciar Jenkins </br>
 
 ![gerenciar](https://user-images.githubusercontent.com/22267601/141996925-03a761d7-4ea4-49e3-8bfb-ccb2539b8a4d.png)
 
 :heavy_check_mark: Gerenciar Plugins </br>
 
 ![gerenciarPlugins](https://user-images.githubusercontent.com/22267601/141996953-074e08f6-3eca-43f2-b917-bc9623f8c342.png)
 
 :heavy_check_mark: HTML Plugin </br> </br>
 
 ![htmlPlugin](https://user-images.githubusercontent.com/22267601/141996896-b7ca84df-ee7b-4b2e-b114-8c51f4f0afd5.png)
 
4. Configurar o SufireReport </br>

![jenkinssufire](https://user-images.githubusercontent.com/22267601/141996560-ef329f52-ef7a-4a6a-8d56-7f5c13ceb14a.png)
 
5. Configurar o HTML Report </br>

![html](https://user-images.githubusercontent.com/22267601/141996599-cd718251-f903-4787-8462-cba212882b04.png)

6. Rodar Projeto </br>

![buildJekins](https://user-images.githubusercontent.com/22267601/141997832-cd090135-153f-476c-a85b-bda3d04fae6a.png)

## 4. Definições Sobre Projeto

:heavy_check_mark: Foram Criados mais de 50 Scripts de Automação Utilizando as API's </br>

![casosdeTeste](https://user-images.githubusercontent.com/22267601/141992815-a8b225e5-e44f-41fa-a79a-e7aa22be118c.png)

:heavy_check_mark: Criação de Projetos e Usuários Utilizando DataDriven </br>

![dataUser](https://user-images.githubusercontent.com/22267601/141995202-ed804bca-bdbe-4688-946b-beb56e380af6.png)</br>


![projeto](https://user-images.githubusercontent.com/22267601/141995279-b8c8cb97-eeed-46ba-ad17-57ef6059ac16.png)

:heavy_check_mark: Nome de Projeto e Usuário utilizando uma String Randomica gerada através do JavaScript(Node.Js) </br>

![classe](https://user-images.githubusercontent.com/22267601/141994542-218f78a2-14f0-4db1-ad34-64e7d4d551f3.png)
 
:heavy_check_mark: Script Utilizado </br>

![funcao](https://user-images.githubusercontent.com/22267601/141994442-75abbfa9-0035-4975-b3f0-73c238d49695.png)

:heavy_check_mark: Criação de Queries para Inserir e Deletar informações necessárias </br>

![queries](https://user-images.githubusercontent.com/22267601/141994040-365db98f-1e5b-4800-beb5-90f9cd6bb4e0.png)

:heavy_check_mark: Utilização do Jenkins como Ambiente de CI para rodar e também mostrar o relatório gerado </br>

![relatorio](https://user-images.githubusercontent.com/22267601/141993615-3380dc4b-a8cd-46ee-9180-2ff245db5669.png)


## **4.1 Configurar o TimeTracking** 
 Passos Abaixo:
1. Gerenciar no Mantis
2. Apos isso siga a imagem abaixo </br>

![timetracking](https://user-images.githubusercontent.com/22267601/141993134-22138886-3d87-45a7-bdc4-8de94ce1cf30.png)

3. A configuração será a seguinte </br>

![confiTrack](https://user-images.githubusercontent.com/22267601/141993178-f85a68a3-1447-4cd0-97d9-5e8e44a5a244.png)
