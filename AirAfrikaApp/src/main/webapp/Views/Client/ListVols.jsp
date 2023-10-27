<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" referrerpolicy="no-referrer" />
    <title>Dashboard Admin</title>
</head>
<body>
<style>
    .scrollbar-hide::-webkit-scrollbar {
        display: none !important;
    }
    .scrollbar-hide {
        -ms-overflow-style: none !important;
        scrollbar-width: none !important;
    }
</style>
<jsp:include page="../Components/header.jsp"></jsp:include>
<div class="container max-w-6xl mx-auto mt-8">
    <div class="mb-4">
        <h1 class="font-serif text-3xl font-bold decoration-gray-400">Les vols disponible</h1>
    </div>

    <div class="flex flex-col">
        <div class="overflow-x-auto sm:-mx-6 sm:px-6 lg:-mx-8 lg:px-8 scrollbar-hide">
            <div class="inline-block min-w-full overflow-hidden align-middle border-b border-gray-200 shadow sm:rounded-lg">
                <table class="min-w-full">
                    <thead>
                    <tr>

                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">
                            Ville de depart
                        </th>
                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">
                            Ville d'arrivée
                        </th>
                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">
                            Heure de depart
                        </th>
                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">
                            Heure d'arrivée
                        </th>
                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">
                            nombre de place
                        </th>
                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">
                            type de vols
                        </th>
                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">
                            Nombre de place disponible
                        </th>
                        <th class="px-6 py-3 text-xs font-medium leading-4 tracking-wider text-left text-gray-500 uppercase border-b border-gray-200 bg-gray-50">

                        </th>


                    </tr>
                    </thead>
                    <tbody class="bg-white">
                    <c:forEach var="vols" items="${vols}">
                        <tr>

                            <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                                <p>
                                        ${vols.villeDepart}
                                </p>
                            </td>
                            <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                                <p>
                                        ${vols.villeArrivee}
                                </p>
                            </td>
                            <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                                <p>
                                        ${vols.departTime}
                                </p>
                            </td>
                            <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                                <p>
                                        ${vols.arriveTime}
                                </p>
                            </td>
                            <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                                <p>
                                        ${vols.nbPlace}
                                </p>
                            </td>
                            <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                                <p>
                                        ${vols.typeVols}
                                </p>
                            </td>
                            <td class="px-6 py-4 whitespace-no-wrap border-b border-gray-200">
                                <p>
                                        ${vols.nbPlaceDispo}
                                </p>
                            </td>
                            <td>
                                <p>
                                    <c:if test="${not empty sessionScope.IDClient}">
                                    <a href="ClientReserverServlet">reserver</a>
                                    </c:if>
                                    <c:if test="${empty sessionScope.IDClient}">
                                        <a href="ClientLoginServlet">reserver</a>
                                    </c:if>
                                </p>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
            <c:if test="${not empty sessionScope.IDClient}">
                <p>Bonjour, ${clientName}</p>
                <a href="ClientLogoutServlet">deconnexion</a>
            </c:if>
            <c:if test="${empty sessionScope.IDClient}">
                <a href="ClientLoginServlet">Login</a>
            </c:if>

        </div>
    </div>
</div>
<jsp:include page="../Components/footer.jsp"></jsp:include>
</body>
</html>
