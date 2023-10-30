<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" referrerpolicy="no-referrer" />
    <title>Create Vol</title>
</head>
<body>
<jsp:include page="../Components/header_dash.jsp"></jsp:include>
<!-- Create Vol -->
<div>
    <div class="flex flex-col items-center min-h-screen pt-6 sm:justify-center sm:pt-0 mt-6">
        <div class="w-full px-16 py-10 overflow-hidden bg-gray-100 rounded-lg lg:max-w-4xl">
            <div class="mb-8">
                <h1 class="font-serif text-3xl font-bold text-center decoration-gray-400">
                    Create Vol
                </h1>
            </div>
            <div class="w-full px-6 py-4 bg-white rounded shadow-md ring-gray-900/10">
                <form method="POST">
                    <div>
                        <label class="mb-4 block text-sm font-bold text-gray-700">
                            Ville de depart
                        </label>
                        <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="text" name="ville_depart" placeholder="Enter la ville de depart" />
                    </div>
                    <div class="mt-4">
                        <label class="mb-4 block text-sm font-bold text-gray-700">
                            Ville d'arrivée
                        </label>
                        <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="text" name="ville_arrivee" placeholder="Enter la ville d'arrivée" />
                    </div>

                   <div>
                       <label class="mb-4 block text-sm font-bold text-gray-700">
                           Heure de depart
                       </label>
                       <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="time" name="heure_depart" placeholder="Enter l'heure de depart" />
                   </div>

                   <div class="mt-4">
                       <label class="mb-4 block text-sm font-bold text-gray-700">
                           Heure d'arrivée
                       </label>
                       <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="time" name="heure_arrivee" placeholder="Enter l'heure d'arrivée" />
                   </div>

                   <div>
                       <label class="mb-4 block text-sm font-bold text-gray-700">
                           Date de depart
                       </label>
                       <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="date" name="date_depart" placeholder="Enter la date de depart" />
                   </div>

                   <div class="mt-4">
                       <label class="mb-4 block text-sm font-bold text-gray-700">
                           Date d'arrivée
                       </label>
                       <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="date" name="date_arrivee" placeholder="Enter la date d'arrivée" />
                   </div>
                   <div class="mt-4">
                       <label class="mb-4 block text-sm font-bold text-gray-700">
                           Nombre de place
                       </label>
                       <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="number" max="30" name="nbre_place" placeholder="Enter le nombre de place" />
                   </div>

                   <div class="mt-4">
                       <label class="mb-4 block text-sm font-bold text-gray-700">
                           Prix
                       </label>
                       <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" required type="number" name="prix" placeholder="Enter le prix" />
                   </div>
                    <!--
                   <div class="mt-4">
                       <label class="mb-4 block text-sm font-bold text-gray-700">
                           Escal
                       </label>
                       <input class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out" type="text" name="stopover_aero" placeholder="Si le vol contient un escale plz entrer le nom de l'aeroport" />
                   </div>
                   -->

                    <div class="mt-4">
                        <label class="mb-4 block text-sm font-bold text-gray-700">
                            Société
                        </label>
                        <select name="societe_id" class="w-full bg-white rounded border border-gray-300 focus:border-blue-500 focus:ring-2 focus:ring-blue-200 text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out">
                           <c:forEach items="${societies}" var="societies">
                                <option value="${societies.id}">${societies.name}</option>
                            </c:forEach>
                        </select>

                    </div>

                    <div class="flex items-center justify-start mt-4 gap-x-2">
                        <button type="submit" class="text-white bg-blue-500 border-0 py-2 px-8 focus:outline-none hover:bg-blue-600 rounded text-lg">
                            Save
                        </button>
                        <a href="./getAllVolServlet" class="text-white bg-gray-500 border-0 py-2 px-8 focus:outline-none hover:bg-gray-600 rounded text-lg">
                            Cancel
                        </a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../Components/footer.jsp"></jsp:include>
</body>
</html>