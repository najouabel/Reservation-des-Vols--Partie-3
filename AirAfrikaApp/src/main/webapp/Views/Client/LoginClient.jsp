<jsp:include page="../Components/header.jsp"></jsp:include>
<section class="flex pb-16 w-full">
    <form action="ClientLoginServlet" method="POST" class="mx-auto w-6/12 m-auto mt-16 text-center">
        <h1 class="font-bold tracking-wider text-3xl mb-8 w-full text-gray-600">
            Login Client
        </h1>
        <div class="mb-3 flex justify-center">
            <input
                    required
                    type="email"
                    class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                    placeholder="Adresse email"
                    name="email"
            />
        </div>
        <div class="mb-3 flex justify-center">
            <input
                    required
                    type="password"
                    class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                    placeholder="Mot de passe"
                    name="password"
            />
        </div>
        <div class="flex justify-between my-4 w-75">
            <a href="ClientRegisterServlet" class="text-blue-700 hover:text-blue-800 font-medium text-sm mr-2 mb-2 dark:text-blue-600 dark:hover:text-blue-700">
                Client Register
            </a>
            </br>

        </div>
        <div class="form-group flex justify-center">
            <button
                    type="submit"
                    class="mt-2 mx-auto shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded py-4 w-full"
            >
                Connexion
            </button>
        </div>
    </form>
</section>
<jsp:include page="../Components/footer.jsp"></jsp:include>
