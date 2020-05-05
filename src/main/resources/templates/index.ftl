<#import "parts/general.ftl" as g>
<#include "parts/security.ftl">

<@g.general>
<body class="text-center">
    <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
        <main role="main" class="inner cover">
            <h1 class="cover-heading">Greeting! ${username}</h1>
            <p class="lead">Good day, this is your personal page!</p>
            <p class="lead">
                <button type="submit" data-toggle="collapse" data-target="#collapseExample" class="btn btn-primary btn-lg disabled">Instruction</button>
            </p>
            <div class="collapse" id="collapseExample">
                <div class="card card-body">
                    <#include "parts/instruction-text.ftl">
                </div>
            </div>
        </main>
    </div>
</body>
</@g.general>

