<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.2.19/tailwind.min.css" referrerpolicy="no-referrer" />
    <title>airafrika - Regsiter</title>
</head>
<body>

<jsp:include page="../Components/header.jsp"></jsp:include>

<div class="flex">
    <section class="w-4/5 ml-auto h-screen bg-gray-200">
        <div class="w-full flex justify-center">
            <div class="w-full bg-white p-5 rounded-lg mt-8 mx-8">
                <h1 class="text-center pb-2 pt-1 text-xl font-medium">Create client</h1>
                <form action="ClientRegisterServlet" method="post" class="flex flex-col space-y-5">
                <div class="flex space-y-2 gap-4">
                        <input
                                required
                                type="text"
                                name="name"
                                placeholder="Entre your nom"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                        <input
                                required
                                type="text"
                                name="prenom"
                                placeholder="Entre your prenom"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                        <input
                                required
                                type="text"
                                name="phone"
                                placeholder="Entre your phone number"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                    </div>
                    <div class="flex space-y-2 gap-4">
                        <input
                                required
                                type="email"
                                name="email"
                                placeholder="Entre your email"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                        <input
                                required
                                type="password"
                                name="password"
                                placeholder="Entre your password"
                                class="block w-full px-4 py-2 mt-2 bg-white border rounded-md focus:border-blue-400 focus:ring-blue-300 focus:outline-none focus:ring focus:ring-opacity-40"
                        />
                    </div>

                    <div class="w-3/6 flex justify-center">
                        <button
                                type="submit"
                                class="mt-2 mx-auto shadow bg-blue-500 hover:bg-blue-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-4 rounded py-4 w-full"
                        >
                            Create
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
<jsp:include page="../Components/footer.jsp"></jsp:include>
</body>
</html>
</body>
</html>

