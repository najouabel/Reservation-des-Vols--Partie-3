<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Vol</title>
</head>
<body>
<jsp:include page="../Components/header_dash.jsp"></jsp:include>

<div class="w-full px-16 py-10 overflow-hidden bg-gray-100 rounded-lg lg:max-w-4xl">
    <div class="mb-8">
        <h1 class="font-serif text-3xl font-bold text-center text-gray-400">
            Edit Vol
        </h1>
    </div>
    <form  method="POST">
        <div>
            <label for="ville_depart" class="mb-4 block text-sm font-bold text-gray-700">
                Ville de départ
            </label>
            <input type="text" name="ville_depart" id="ville_depart" value="${vols.villeDepart}" required>
        </div>

        <div>
            <label for="ville_arrivee" class="mb-4 block text-sm font-bold text-gray-700">
                Ville d'arrivée
            </label>
            <input type="text" name="ville_arrivee" id="ville_arrivee" value="${vols.villeArrivee}" required>
        </div>

        <div class="flex items-center justify-start mt-4 gap-x-2">
            <button type="submit" class="text-white bg-blue-500 border-0 py-2 px-8 focus:outline-none hover:bg-blue-600 rounded text-lg">
                Save
            </button>
            <a href="./DashboardAdminServlet" class="text-white bg-gray-500 border-0 py-2 px-8 focus:outline-none hover:bg-gray-600 rounded text-lg">
                Cancel
            </a>
        </div>
    </form>
</div>

<jsp:include page="../Components/footer.jsp"></jsp:include>
</body>
</html>
