# curso-alura-java-servlet

<p>
    <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/my-study-area/curso-alura-java-servlet">
    <a href="https://github.com/my-study-area">
        <img alt="Made by" src="https://img.shields.io/badge/made%20by-adriano%20avelino-gree">
    </a>
    <img alt="Repository size" src="https://img.shields.io/github/repo-size/my-study-area/curso-alura-java-servlet">
    <a href="https://github.com/EliasGcf/readme-template/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/my-study-area/curso-alura-java-servlet">
    </a>
</p>
Curso de Java Servlet: Fundamentos da programação web Java

## Anotações

**Módulo 01 - Fundamentos da Web e a API de Servlets**
- Apache Foundation é uma organização de projetos Open Source que possui `Apache HTTP` ou `Apache Tomcat`, ambos servidores web
- `Apache HTTP`: é escrito em C, é um servidor estático e depende de uma outra linguagem para gerar HTML
- `Apache Tomcat`: é escrito em Java, é dinâmico e utiliza Java e JSP 
- Apache Tomcat ou apenas Tomcat é um servidor web em Java
- Tomcat entende o protocolo HTTP e roda por padrão no http://localhost:8080
- O projeto Java faz parte da URL, no nosso caso: http://localhost:8080/gerenciador
- Uma aplicação web Java pode ter páginas HTML
- Uma servlet é um objeto Java que podemos chamar a partir de uma requisição HTTP
- Para mapear a URL para uma servlet usamos a anotação @WebServlet
- Uma servlet deve estender a classe HttpServlet e sobrescrever um determinado método (por exemplo service)

**Módulo 02 - Trabalhando com POST e GET**
- para criarmos um servlet estendemos nossa classe à classe `javax.servlet.http.HttpServlet`, anotamos com `@WebServlet("/novaEmpresa")`, por exemplo e sobrescremos algum dos métodos
- utilizamos a sobrescrita no método `service(HttpServletRequest, HttpServletResponse)` para realizarmos requisições `POST` e `GET`
- `javax.servlet.http.HttpServletResponse.getParameter(String)` é usado para receber parâmetro os formulários HTML
- o método `doPost(HttpServletRequest, HttpServletResponse)` realiza requisições POST
- o método `doGet(HttpServletRequest, HttpServletResponse)` realiza requisições GET
- requisições POST e GET somente são seguras usando `https`

**Módulo 03 - Definindo o nosso modelo**
- o método `getParameter` da classe `javax.servlet.http.HttpServletRequest` somente aceita String como parâmetro

**Módulo 04 - Páginas dinâmicas com JSP**
- JSP significa Java Server Pages
- JSP é uma página automaticamente processada pelo Tomcat
- Para gerar HTML dinamicamente no JSP usamos Scriptlets
- Um scriptlet `<% %>` é um código Java dentro do HTML
- Um scriptlet só funciona em uma página JSP
- Usamos o RequestDispatcher para chamar um JSP a partir da servlet
- Obtemos o RequestDispatcher a partir do HttpServletRequest
- Usamos a requisição para colocar ou pegar um atributo (`setAttribute(.., ..)` ou `getAttribute(..)`)

**Módulo 05 - JSTL e Expression Language**
- Expression Language (EL) é uma linguagem simples e limitada para imprimir o resultado de uma expressão
- EL usa a sintaxe de `${ .. }`
- JSTL é a biblioteca padrão de tags
- JSTL não vem com Tomcat e precisamos copiar um JAR
- JARs ficam na pasta WEB-INF/lib do projeto
- JSTL define 4 taglibs, as mais importantes são `core` e `fmt`
- a taglib `core` serve para controle de fluxo, `fmt` para formatação
- é preciso importar as taglib, core e fmt separadamente:
```xml
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
```
- JSTL e EL devem ser usados em conjunto
- vimos várias tags do core como `c:if`, `c:forEach` e `c:url`
- da fmt vimos a tag `fmt:formatDate`

**Módulo 06 - Redirecionando o fluxo**
- reenviar uma requisição com `request.getRequestDispatcher(String)`, por exemplo, ao encaminhar uma requisição de um servlet para outro pode permitir o usuário reenviar uma requisição POST na página de listagem de empresas
- no método `getRequestDispatcher(String)`, da classe `javax.servlet.http.HttpServletRequest`, os dados da requisição podem ser encaminhado para outro servlet, mas não conseguimos ver na url o caminho redirecionado e ocorre no próprio servidor
- no método `sendRedirect(String)`, da `classe javax.servlet.http.HttpServletResponse`, os dados da requisição não são encaminhados porque são tratados como uma nova solicitação pelo navegador. Conseguimos ver na url o caminho redirecionado e ocorre no cliente
- a diferença entre redirecionamento pelo cliente e servidor
- para redirecionar pelo navegador usamos o método `response.sendRedirect("endereço")`
- o código de resposta para redirecionamento HTTP é 30X (301 ou 302)


**Módulo 07 - Completando o CRUD**
- `CRUD`: Create, Read/Retrieve, Update, Delete
- utilize a tag input do tipo hidden para informar o id num formulário (
`<input type="hidden" name="id" value="${empresa.id}">`)

**Módulo 08 - Deploy da aplicação**
- o arquivo `/gerenciador/WebContent/WEB-INF/web.xml` é o arquivo responsável por manter as configurações relacionadas aos Servlets
- na tag `<welcome-file-list>` definimos o arquivo que será carregado automaticamente ao iniciar a aplicacão. Ex:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
    <display-name>gerenciador</display-name>
    <welcome-file-list>
      <welcome-file>bem-vindo.html</welcome-file>
    </welcome-file-list>
  </web-app>
  ```

- podemos usar o arquivo `web.xml` para mapear uma URL num Servlet. Ex:
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
    <display-name>gerenciador</display-name>
    <servlet>
      <servlet-name>OiMundoServlet</servlet-name>
      <servlet-class>br.com.alura.gerenciador.servlet.OiMundoServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
      <servlet-name>OiMundoServlet</servlet-name>
      <url-pattern>/ola</url-pattern>
    </servlet-mapping>
  </web-app>
  ```
- Servlet é um objeto, gerenciado por um container como o Apache Tomcat,  que pode ser chamado pelo protocolo HTTP, através de um requisião
- Apache Tomcat cria a instância do Servlet e é conhecido como um middleware, por ficar no intermédio entre o navegador e o Servlet
- No Tomcat teremos apenas um Servlet, `OiMundoServlet` ou `ListaEmpresaServlet`, e isso se eles forem chamados. Por isso o Servlet é chamado de Singleton, um escopo, que sobrevive no projeto por tempo indeterminado enquanto o Tomcat estiver no ar, sem nunca recriá-lo. Por isso é conhecido como `preguiçoso`
-  Inversão de controle, em inglês IOC (-Inversion Of Control). Isso significa que o método main() é quem instancia o objeto, mas no caso do nosso projeto quem realiza esse processo é o Tomcat
- O Tomcat só irá instanciar as servlets de acordo com a necessidade, além disso, ele instanciará apenas uma servlet de cada (singleton)
- A anotação @WebServlet possui o atributo loadOnStartup, que com valor 1 muda o comportamento "preguiçoso" do Tomcat e inicia o Servlet ao iniciar. Ex: `@WebServlet(urlPatterns="/oi", loadOnStartup=1)`
- Procedimento para deploy:
  - gerar o arquivo war no eclipse:
    - botão direito do mouse no projeto > Export > WAR file > selecione a pasta de destino > Finish
  - no tomcat de produção:
    - copie o seu WAR na pasta `webapps` dentro do diretório do Tomcat
  - inicie o servidor:
    ```bash
    # entre no diretório bin dentro do tomcat
    cd bin
    
    # inicie o servidor
    sudo ./startup.sh

    # caso necessário, pare o servidor
    sudo ./shutdown.sh
    ```
  - consultar o log:
    ```bash
    # na raiz do diretório do Tomcat
    tail -f logs/catalina.out
    ```
- Para alterar a porta padrão do Tomcat altere, no arquivo `conf/server.xml`, a porta de 8080  para 80. Ex:
  ```xml
      <Connector port="80" protocol="HTTP/1.1"
                connectionTimeout="20000"
                redirectPort="8443" />
  ```
