<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhe do Elenco</title>
    </head>
    <body>
       <c:import url="cabecalho.jsp" />            
       <div align="center">
            <p>Elenco</p>
            <table class="zebrada">                
                <tr>                    
                    <th>Filme</th>                    
                    <th>Pessoa</th>                    
                    <th>Nome</th>                    
                </tr>
                <c:forEach var="elenco" items="${elenco}">
                    <tr>
                        <td>${elenco.pk.filme.titulo}</td>                        
                        <td>${elenco.pk.pessoa.pesCodigo}</td>                        
                        <td>${elenco.pk.pessoa.nome}</td>                        
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
