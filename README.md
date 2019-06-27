# Granja Inteligente
## Projeto de Sistemas Orientados a Objetos
### Grupo:
#### Bruno Augusto Vieira
#### Felipe de Almeida Balascio
#### Lucas Ito Atsuo
#### Professor Frank José Affonso
Esse Projeto foi feito com a finalidade que aprender um pouco sobre rest api.
Tem como base a ideia de uma granja inteligente que teria baias diferentes com 4 tipos de sensores(temperatura,comida,agua,iluminaçao)
Esse projeto pode ser utilizado sozinho, porem afim de demostrar a sua utilização, fizemos um outro projeto que pode ser utilizado como front-end.
Que pode ser encontrado aqui: https://github.com/fe2bala/granjainteligente-front-app
### Feito com SpringBoot, Hibernate, MySQL
Foram utilizados no projeto afim de facilitar e agilizar o desenvolvimento
### Como usar o projeto:
##### *Certificar-se que o MySQL tem um schema criado chamado granjainteligente(create SCHEMA granjainteligente)
##### modificar o arquivo application.properties, e colocar as credencias para acessar o MySQL, EX: 
###### spring.datasource.username = <<'USERNAME'>>
###### spring.datasource.password = <<'PASSWORD'>>
#### Com netbeans:

Clean and Build + Run project

### Visualizar requisições:
Para que fosse possivel testar as requisições foi instalado o @swagger : https://swagger.io/ e para acessá-lo basta seguir para {baseUrl}/swagger-ui.html 

# Para utilizar o front-end criado:
## Utilizar o projeto granjainteligente-front-app
##### *Ter o Node.js(https://www.npmjs.com/get-npm) instalado na maquina e o CLI do Angular (Apos ter o npm instaldo utilizar o seguinte comando: npm install -g @angular/cli)
Abrir um commandLine na pasta do projeto e executar os seguintes comandos:
###### Para baixar os modulos do projeto(necessario fazer apenas na primeira vez):
####### npm install 
###### Para construir o projeto:
####### ng build
###### Para rodar:
####### ng serve
###### aguardar o servidor inicializar e o site estará disponivel na porta padrão: localhost:4200 
