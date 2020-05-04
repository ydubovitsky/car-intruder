<nav class="navbar navbar-expand-md justify-content-center">
    <div class="container">
        <div class="navbar-collapse collapse justify-content-between align-items-center w-100" id="collapsingNavbar2">
            <ul id="navbar-list-id" class="topBotomBordersOut navbar-nav mx-auto text-center">
                <li class="nav-item"><a class="nav-link" href="/declaration">Declaration</a></li>
                <li class="nav-item"> <a class="nav-link" href="#">Users</a>
                <li class="nav-item"> <a class="nav-link" href="#">Contact</a>
                <li class="nav-item">
                    <form id="logout" action="/logout" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="nav-link" type="submit">Sign Out</button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>