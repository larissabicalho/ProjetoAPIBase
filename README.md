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
 - Crie um novo Job ![](https://drive.google.com/uc?export=view&id=1FzrW9Aj7Rovm-cNY-ij78kq4xhqLQqyj)
 - Configure o Job (Nome e Tipo)![](https://drive.google.com/uc?export=view&id=1nsxHiD55DryjW5Fg5amj_vTnjcgYdeLN)
 - Colocar o Projeto Git no Jenkins e Adicionar as credenciais git para baixar![](https://drive.google.com/uc?export=view&id=1ies76OIM1RtCdVRc-L4Zh_D1DYNYiKpV)
![](https://drive.google.com/uc?export=view&id=1uzP0_J_McZFZK_hXjs64enB0-f2fMkui)
3. Adicionar o Plugin o HTML Report 
 - Gerenciar Jenkins ![](https://drive.google.com/uc?export=view&id=1rP9YAUMwPvINps1PbIzmaUL6cZy5CcmR)
 - Gerenciar Plugins ![](https://drive.google.com/uc?export=view&id=1Zv-V3VGlhqtl5vMzJs_WOt494wjTID4k)
 - HTML Plugin ![](https://drive.google.com/uc?export=view&id=1l2S1t_5u6XCs0eG38LzNopVYypvVUt2T)
4. Configurar o SufireReport ![](https://drive.google.com/uc?export=view&id=1wjPR5-tmVzqtBgG5mvHP8LPJSZiu4xE0)
5. Configurar o HTML Report ![](https://drive.google.com/uc?export=view&id=12YJBvkgn1qXmyWdiDyKSq4IlAZRwVvNm)

## 4. Definições Sobre Projeto

- Foram Criados mais de 50 Scripts de Automação Utilizando as API's ![](https://drive.google.com/uc?export=view&id=1FSoCcES2DnyJat7y2rm40OnZ9Dzvrjmu)
- Criação de Projetos e Usuários Utilizando DataDriven ![](https://drive.google.com/uc?export=view&id=1pf92vwCnNH9XDTpodudns6LwLj38mflS)
 ![](https://drive.google.com/uc?export=view&id=10YtEv5aQmaFkSlP34L1IEP5bAzuoTeCO)
  -  Nome de Projeto e Usuário utilizando uma String Randomica gerada através do JavaScript(Node.Js)![image](https://drive.google.com/uc?export=view&id=1AanHe0Q-5DW8aqS-nImAzEYfG9mNCeAE)
  -  Script Utilizado
![image](https://drive.google.com/uc?export=view&id=1HxwRMJu2cIo9XAOSP6HjjfRZ_EV_uMY0)
- Criação de Queries para Inserir e Deletar informações necessárias ![](https://drive.google.com/uc?export=view&id=19YT3RMgonexKwOSN7snct-0J9fHbuBKV)
- Utilização do Jenkins como Ambiente de CI para rodar e também mostrar o relatório gerado <img src="https://drive.google.com/uc?export=view&id=1kyYNKhq6g5Ly4RHWIVcrKHS1UjDnzBYc" style="center: 500px; max-width: 100%; height: auto" />

## **4.1 Configurar o TimeTracking** 
 Passos Abaixo:
1. Gerenciar no Mantis
3. Apos isso siga a imagem abaixo
<img src="https://drive.google.com/uc?export=view&id=1Zmswgxi8BmPbXyfuHuGc47SkfE_jBkrh" style="center: 500px; max-width: 100%; height: auto" />
3. A configuração será a seguinte
<img src="https://drive.google.com/uc?export=view&id=11-FSrNSqcUs2kZr-6AQE6KtEukEdgk9c" style="center: 500px; max-width: 100%; height: auto" />
