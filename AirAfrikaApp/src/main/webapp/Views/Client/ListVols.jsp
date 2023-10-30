<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Admin</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" referrerpolicy="no-referrer">
</head>
<body class="bg-gray-50 text-slate-500">
<div class="container mx-auto mt-8">
    <div class="flex justify-end">

        <c:if test="${not empty sessionScope.IDClient}">
            <p class="text-gray-700 text-lg mr-4">Bonjour, ${clientName}</p>
            <a href="ClientLogoutServlet" class="text-white bg-red-500 py-2 px-6 rounded-lg text-lg hover:bg-red-600">Déconnexion</a>
        </c:if>

        <c:if test="${empty sessionScope.IDClient}">
            <a href="ClientLoginServlet" class="text-white bg-blue-500 py-2 px-8 rounded-lg text-lg hover:bg-blue-600">Login</a>
        </c:if>


    </div>
    <div class="overflow-x-auto mt-4">
        <table class="min-w-full bg-white">
            <thead>
            <tr>
                <th class="px-6 py-3 text-xs font-medium text-left uppercase bg-gray-50">Ville de départ</th>
                <th class="px-6 py-3 text-xs font-medium text-left uppercase bg-gray-50">Ville d'arrivée</th>
                <th class="px-6 py-3 text-xs font-medium text-left uppercase bg-gray-50">Heure de départ</th>
                <th class="px-6 py-3 text-xs font-medium text-left uppercase bg-gray-50">Heure d'arrivée</th>
                <th class="px-6 py-3 text-xs font-medium text-left uppercase bg-gray-50">Nombre de places</th>
                <th class="px-6 py-3 text-xs font-medium text-left uppercase bg-gray-50">Type de vols</th>
                <th class="px-6 py-3 text-xs font-medium text-left uppercase bg-gray-50">Nombre de places disponibles</th>
                <th class="px-6 py-3 text-sm text-left bg-gray-50" colspan="3"> </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="vols" items="${vols}">
                <tr>
                    <td class="px-6 py-4">${vols.villeDepart}</td>
                    <td class="px-6 py-4">${vols.villeArrivee}</td>
                    <td class="px-6 py-4">${vols.departTime}</td>
                    <td class="px-6 py-4">${vols.arriveTime}</td>
                    <td class="px-6 py-4">${vols.nbPlace}</td>
                    <td class="px-6 py-4">${vols.typeVols}</td>
                    <td class="px-6 py-4">${vols.nbPlaceDispo}</td>
                    <td class="px-6 py-4">

                        <c:if test="${not empty sessionScope.IDClient}">
                            <a href="ClientReserverServlet" class="text-indigo-600 hover:text-indigo-900">Réserver</a>
                        </c:if>
                        <c:if test="${empty sessionScope.IDClient}">
                            <a href="ClientLoginServlet" class="text-indigo-600 hover:text-indigo-900">Réserver</a
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
