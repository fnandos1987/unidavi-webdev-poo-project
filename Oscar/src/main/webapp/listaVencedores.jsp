<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Vencedores</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />            
        <div align="center">
            <p>Vencedores</p>
            <table class="zebrada">                
                <tr>
                    <th>Ano</th>
                    <th>Categoria</th>
                    <th>Filme</th>                    
                    <th>Titulo</th>                    
                    <th>Indicado</th>  
                    <th>Detalhe Indicado</th>
                </tr>
                <c:forEach var="vencedor" items="${vencedores}">
                    <tr>
                        <td>${vencedor.pk.ano}</td>
                        <td>${vencedor.pk.categoria.descricao}</td>
                        <td>${vencedor.pk.filme.filCodigo}</td>
                        <td>${vencedor.pk.filme.titulo}</td>                        
                        <td>${vencedor.pessoa.nome}</td>   
                        <td>
                            <c:if test="${vencedor.pessoa.pesCodigo != ''}">
                                <a href="action?act=DetalharPessoa&pescodigo=${vencedor.pessoa.pesCodigo}">visualizar</a>                            
                            </c:if>
                        </td> 
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
