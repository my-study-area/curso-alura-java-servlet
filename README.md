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
