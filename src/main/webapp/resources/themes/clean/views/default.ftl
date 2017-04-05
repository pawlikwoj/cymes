<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="${theme.getPath()}/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="${theme.getPath()}/style.css">
    </head>
    <body>
        <div class="container">
            <div class="row header bg-primary text-white">
                <div class="col-sm-9">
                    <h1 class="display-4">${pageName}</h1>
                    ${pageLogo}
                </div>
                <div class="col-sm-3">
                    <p>user: <#if user??>${user}</#if></p>
                </div>
            </div>
            <div class="row">
                <div class="col-12">NAV</div>
            </div>
            <div class="row main-content">
                <div class="col-12">
                    ${content}
                </div>
            </div>
            <div class="row footer bg-info text-white">
                <div class="col-12">
                    ${siteWideBlock.footerBlock}
                </div>
            </div>
        </div>

        <script src="${theme.getPath()}/js/jquery-3.2.0.min.js" ></script>
        <script src="${theme.getPath()}/js/tether.min.js" ></script>
        <script src="${theme.getPath()}/js/bootstrap.min.js" ></script>
    </body>
</html>

