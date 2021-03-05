# curso-alura-java-servlet

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
- utilizamos a sobrescrita no método `doPost(HttpServletRequest, HttpServletResponse)` para realizarmos requisições `POST` e `GET`
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
- Um scriptlet <% %> é um código Java dentro do HTML
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
- no método `getRequestDispatcher(String)` da classe `javax.servlet.http.HttpServletRequest` os dados da requisição podem ser encaminhado para outro servlet, não conseguimos ver na url o caminho redirecionado e ocorre no próprio servidor
- no método `sendRedirect(String)` da `classe javax.servlet.http.HttpServletResponse` os dados da requisição não são encaminhados porque são tratados como uma nova solicitação pelo navegador, conseguimos ver na url o caminho redirecionado e ocorre no cliente
- a diferença entre redirecionamento pelo cliente e servidor
- para redirecionar pelo navegador usamos o método response.sendRedirect- ("endereço")
- o código de resposta para redirecionamento HTTP é 30X (301 ou 302)


**Módulo 07 - Completando o CRUD**
- `CRUD`: Create, Read/Retrieve, Update, Delete
- utilize a tag input do tipo hidden para informa o id num formulário (
`<input type="hidden" name="id" value="${empresa.id}">`)
