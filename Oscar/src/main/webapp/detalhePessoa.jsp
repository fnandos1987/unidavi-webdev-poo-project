<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhe de Pessoa</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />            
        <div align="center">
            <p>Detalhe Indicado</p>
            <c:set var="pessoa" scope="request" value="${pessoa}"/>
            <table class="zebrada" style="min-width: 30%">
                <tr>
                    <td>Pessoa:</td>
                    <td>${pessoa.pesCodigo}</td>
                </tr>
                <tr>
                    <td>Nome</td>
                    <td>${pessoa.nome}</td>
                </tr>
                <tr>
                    <td>Anos de Carreira:</td>
                    <td>${pessoa.anosCarreira}</td>
                </tr>
                <tr>
                    <td>Nomeações:</td>
                    <td>${pessoa.nomeacoes}</td>
                </tr>
                <tr>
                    <td>Conquistas:</td>
                    <td>${pessoa.conquistas}</td>
                </tr>
            </table>
        </div>
    </body>
</html>
