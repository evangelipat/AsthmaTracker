<%@page import="java.util.Date"%>
<%@page import="net.aksingh.owmjapis.core.OWMPro"%>
<%@page import="net.aksingh.owmjapis.model.DailyWeatherForecast"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.athmatracker.model.User"%>
<%@page import="com.mycompany.athmatracker.db.UserDB"%>
<%@page import= "net.aksingh.owmjapis.core.OWM"%>
<%@page import="net.aksingh.owmjapis.api.APIException"%>
<%@page import="net.aksingh.owmjapis.model.CurrentWeather"%>
<% User user = UserDB.getUser(request.getSession().getAttribute("email").toString());%>
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="navbar-header" id="logoLogged">
                <a class="navbar-brand">
                    <svg width="220" height="45" viewBox="0 0 260 61" fill="none" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                        <path d="M78.7617 56C78.7617 55.599 78.6159 55.3711 78.3242 55.3164C78.2331 55.2982 78.1419 55.2891 78.0508 55.2891H77.1211L70.8594 39.5938H69.8477L63.7227 55.2891H62V56H66.8672C66.8672 55.599 66.7214 55.3711 66.4297 55.3164C66.3385 55.2982 66.2474 55.2891 66.1562 55.2891H64.8164L66.8672 49.9844H72.582L74.6328 55.2891H72.8555V56H78.7617ZM72.2812 49.1914H67.168L69.7109 42.5742L72.2812 49.1914ZM83.957 55.5352C85.2148 55.5352 86.0625 55.1523 86.5 54.3867C86.6641 54.1133 86.7461 53.8125 86.7461 53.4844C86.7461 52.7188 86.1901 52.0625 85.0781 51.5156C84.8411 51.388 84.4492 51.2057 83.9023 50.9688C82.4076 50.349 81.4141 49.7656 80.9219 49.2188C80.3932 48.6172 80.1289 47.9154 80.1289 47.1133C80.1289 45.8555 80.8216 44.9714 82.207 44.4609C82.8451 44.224 83.5378 44.1055 84.2852 44.1055C85.4883 44.1055 86.5273 44.3607 87.4023 44.8711C87.4023 44.3424 87.5299 44.0417 87.7852 43.9688C87.8945 43.9505 88.013 43.9414 88.1406 43.9414V47.3594H87.4297C87.3932 45.6823 86.4635 44.8346 84.6406 44.8164C83.2734 44.8164 82.4258 45.2174 82.0977 46.0195C82.0065 46.2383 81.9609 46.4661 81.9609 46.7031C81.9609 47.487 82.526 48.1523 83.6562 48.6992C83.9115 48.8268 84.3125 49 84.8594 49.2188C86.3359 49.8203 87.3203 50.3945 87.8125 50.9414C88.3411 51.5247 88.6055 52.2174 88.6055 53.0195C88.6055 54.4961 87.8216 55.4805 86.2539 55.9727C85.6523 56.1732 84.9961 56.2734 84.2852 56.2734C82.9727 56.2552 81.8333 55.9271 80.8672 55.2891C80.8672 55.763 80.7487 56.0365 80.5117 56.1094C80.4023 56.1276 80.2747 56.1367 80.1289 56.1367V51.9805H80.8945C80.931 54.332 81.9518 55.5169 83.957 55.5352ZM90.2461 45.0625H92.1602V52.7734C92.2878 55.0521 93.3359 56.2279 95.3047 56.3008C96.9818 56.3008 98.0299 55.2708 98.4492 53.2109C98.4492 53.1927 98.4492 53.1745 98.4492 53.1562L97.7109 53.0195C97.2552 54.5326 96.5898 55.3529 95.7148 55.4805C94.7305 55.444 94.2292 54.7422 94.2109 53.375V45.0625H98.4492V44.3789H94.2109V41.207L92.1602 41.7812V44.3789H90.2461V45.0625ZM104.93 55.3164H103.562V49.4102C103.562 47.7513 104.137 46.5482 105.285 45.8008C105.759 45.4909 106.251 45.3359 106.762 45.3359C107.874 45.3359 108.648 45.8555 109.086 46.8945C109.286 47.3867 109.387 47.9336 109.387 48.5352V53.6758C109.387 54.5143 109.186 55.0156 108.785 55.1797C108.53 55.2708 108.092 55.3164 107.473 55.3164V56H113.488C113.488 55.599 113.352 55.3802 113.078 55.3438C113.005 55.3255 112.914 55.3164 112.805 55.3164H111.438V48.5352C111.438 46.5482 110.781 45.1992 109.469 44.4883C108.958 44.2331 108.411 44.1055 107.828 44.1055C106.479 44.1055 105.349 44.5977 104.438 45.582C104.055 46.0013 103.763 46.4753 103.562 47.0039V38.2266H99.4609V38.9102H101.512V53.6758C101.512 54.5143 101.275 55.0156 100.801 55.1797C100.527 55.2708 100.081 55.3164 99.4609 55.3164V56H105.613C105.613 55.599 105.477 55.3802 105.203 55.3438C105.13 55.3255 105.039 55.3164 104.93 55.3164ZM120.352 55.3164H119.121V49.4102C119.176 47.806 119.732 46.612 120.789 45.8281C121.281 45.4635 121.773 45.2812 122.266 45.2812C123.177 45.2812 123.806 45.7826 124.152 46.7852C124.298 47.2227 124.371 47.7148 124.371 48.2617V53.6758C124.371 54.5143 124.171 55.0156 123.77 55.1797C123.514 55.2708 123.077 55.3164 122.457 55.3164V56H128.336C128.336 55.599 128.199 55.3802 127.926 55.3438C127.853 55.3255 127.762 55.3164 127.652 55.3164H126.422V48.5352V48.3164C126.714 46.9857 127.361 46.056 128.363 45.5273C128.746 45.3451 129.111 45.2539 129.457 45.2539C130.387 45.2539 131.043 45.737 131.426 46.7031C131.608 47.1589 131.699 47.6784 131.699 48.2617V53.6758C131.699 54.5143 131.499 55.0156 131.098 55.1797C130.842 55.2708 130.405 55.3164 129.785 55.3164V56H135.828C135.828 55.599 135.691 55.3802 135.418 55.3438C135.345 55.3255 135.254 55.3164 135.145 55.3164H133.75V48.5352C133.75 46.6576 133.139 45.3451 131.918 44.5977C131.371 44.2695 130.779 44.1055 130.141 44.1055C128.755 44.1055 127.643 44.7526 126.805 46.0469C126.586 46.375 126.404 46.7214 126.258 47.0859C125.93 45.6458 125.21 44.7161 124.098 44.2969C123.77 44.1693 123.432 44.1055 123.086 44.1055C121.773 44.1055 120.689 44.6615 119.832 45.7734C119.522 46.1745 119.276 46.6211 119.094 47.1133L118.984 44.3789H115.02V45.0625H117.07V53.6758C117.07 54.5143 116.833 55.0156 116.359 55.1797C116.086 55.2708 115.639 55.3164 115.02 55.3164V56H121.035C121.035 55.6172 120.898 55.3984 120.625 55.3438C120.534 55.3255 120.443 55.3164 120.352 55.3164ZM147.203 56.2734C148.607 56.2734 149.382 55.4258 149.527 53.7305C149.546 53.6211 149.555 53.5208 149.555 53.4297L148.844 53.4023C148.716 54.7331 148.361 55.4076 147.777 55.4258C147.303 55.3893 147.057 54.9154 147.039 54.0039V48.2344C147.039 45.6276 145.736 44.2513 143.129 44.1055C142.965 44.1055 142.801 44.1055 142.637 44.1055C140.595 44.1055 139.228 44.5794 138.535 45.5273C138.316 45.8372 138.207 46.1471 138.207 46.457C138.207 47.0221 138.471 47.3503 139 47.4414C139.091 47.4596 139.182 47.4688 139.273 47.4688C139.693 47.4688 140.003 47.2044 140.203 46.6758C140.458 46.0013 140.632 45.6003 140.723 45.4727C141.069 45.0169 141.607 44.7891 142.336 44.7891C144.049 44.8984 144.934 45.8372 144.988 47.6055V49.3281C140.704 49.3281 138.253 50.2214 137.633 52.0078C137.523 52.3542 137.469 52.7279 137.469 53.1289C137.469 54.5143 138.079 55.4622 139.301 55.9727C139.793 56.1732 140.312 56.2734 140.859 56.2734C142.19 56.2734 143.311 55.8177 144.223 54.9062C144.551 54.5599 144.797 54.1953 144.961 53.8125C145.18 55.4349 145.927 56.2552 147.203 56.2734ZM141.762 55.1797C140.65 55.1797 139.966 54.6237 139.711 53.5117C139.656 53.2565 139.629 52.974 139.629 52.6641C139.629 51.4427 140.331 50.668 141.734 50.3398C142.482 50.1758 143.566 50.0846 144.988 50.0664V52.2539C144.715 53.5117 144.049 54.3958 142.992 54.9062C142.573 55.0885 142.163 55.1797 141.762 55.1797ZM166.562 56C166.562 55.599 166.417 55.3711 166.125 55.3164C166.034 55.2982 165.943 55.2891 165.852 55.2891H163.992V40.3047H165.578C167.055 40.3047 168.039 41.1979 168.531 42.9844C168.531 43.0573 168.54 43.112 168.559 43.1484L168.996 44.9805H169.762L169.625 39.5938H156.117L155.98 44.9805H156.746L157.184 43.1484C157.767 41.362 158.76 40.4141 160.164 40.3047H161.641V55.2891H159.043V56H166.562ZM177.664 55.3164H175.695V49.875C175.695 48.2161 176.206 46.8854 177.227 45.8828C177.628 45.5 177.965 45.2995 178.238 45.2812C178.548 45.2812 178.831 45.5091 179.086 45.9648C179.378 46.4753 179.651 46.7669 179.906 46.8398C180.016 46.8763 180.125 46.8945 180.234 46.8945C180.781 46.8945 181.128 46.6302 181.273 46.1016C181.31 45.9922 181.328 45.8828 181.328 45.7734C181.328 44.9531 180.909 44.4518 180.07 44.2695C179.888 44.2331 179.715 44.2148 179.551 44.2148C178.457 44.2148 177.482 44.6797 176.625 45.6094C176.224 46.0469 175.905 46.5391 175.668 47.0859L175.559 44.3789H171.594V45.0625H173.645V53.6758C173.645 54.5143 173.408 55.0156 172.934 55.1797C172.66 55.2708 172.214 55.3164 171.594 55.3164V56H178.348C178.348 55.599 178.211 55.3802 177.938 55.3438C177.865 55.3255 177.773 55.3164 177.664 55.3164ZM192.156 56.2734C193.56 56.2734 194.335 55.4258 194.48 53.7305C194.499 53.6211 194.508 53.5208 194.508 53.4297L193.797 53.4023C193.669 54.7331 193.314 55.4076 192.73 55.4258C192.257 55.3893 192.01 54.9154 191.992 54.0039V48.2344C191.992 45.6276 190.689 44.2513 188.082 44.1055C187.918 44.1055 187.754 44.1055 187.59 44.1055C185.548 44.1055 184.181 44.5794 183.488 45.5273C183.27 45.8372 183.16 46.1471 183.16 46.457C183.16 47.0221 183.424 47.3503 183.953 47.4414C184.044 47.4596 184.135 47.4688 184.227 47.4688C184.646 47.4688 184.956 47.2044 185.156 46.6758C185.411 46.0013 185.585 45.6003 185.676 45.4727C186.022 45.0169 186.56 44.7891 187.289 44.7891C189.003 44.8984 189.887 45.8372 189.941 47.6055V49.3281C185.658 49.3281 183.206 50.2214 182.586 52.0078C182.477 52.3542 182.422 52.7279 182.422 53.1289C182.422 54.5143 183.033 55.4622 184.254 55.9727C184.746 56.1732 185.266 56.2734 185.812 56.2734C187.143 56.2734 188.264 55.8177 189.176 54.9062C189.504 54.5599 189.75 54.1953 189.914 53.8125C190.133 55.4349 190.88 56.2552 192.156 56.2734ZM186.715 55.1797C185.603 55.1797 184.919 54.6237 184.664 53.5117C184.609 53.2565 184.582 52.974 184.582 52.6641C184.582 51.4427 185.284 50.668 186.688 50.3398C187.435 50.1758 188.52 50.0846 189.941 50.0664V52.2539C189.668 53.5117 189.003 54.3958 187.945 54.9062C187.526 55.0885 187.116 55.1797 186.715 55.1797ZM195.738 50.3125C195.738 52.5182 196.549 54.168 198.172 55.2617C199.174 55.9362 200.314 56.2734 201.59 56.2734C203.486 56.2734 204.917 55.6081 205.883 54.2773C206.102 53.9674 206.275 53.6576 206.402 53.3477L205.691 53.1016C205.017 54.5417 203.905 55.3346 202.355 55.4805C202.21 55.4987 202.064 55.5078 201.918 55.5078C200.624 55.5078 199.612 54.8607 198.883 53.5664C198.336 52.582 198.062 51.4154 198.062 50.0664C198.062 47.6784 198.691 46.0833 199.949 45.2812C200.478 44.9531 201.061 44.7891 201.699 44.7891C202.684 44.7891 203.276 45.1719 203.477 45.9375C203.513 46.0833 203.559 46.3112 203.613 46.6211C203.723 47.3503 203.923 47.806 204.215 47.9883C204.397 48.0794 204.598 48.1341 204.816 48.1523C205.436 48.1888 205.828 47.9336 205.992 47.3867C206.029 47.2591 206.047 47.1406 206.047 47.0312C206.047 46.1016 205.454 45.3359 204.27 44.7344C203.431 44.3151 202.52 44.1055 201.535 44.1055C199.092 44.1055 197.388 45.099 196.422 47.0859C195.966 48.0339 195.738 49.1094 195.738 50.3125ZM212.719 55.3164H211.488V51.2695L212.992 49.875L216.848 56H220.484C220.484 55.599 220.348 55.3802 220.074 55.3438C220.001 55.3255 219.91 55.3164 219.801 55.3164H218.816L214.414 48.5352L216.984 46.1289C217.622 45.5273 218.105 45.1901 218.434 45.1172C218.579 45.0807 218.743 45.0625 218.926 45.0625C219.327 45.0625 219.546 44.9258 219.582 44.6523C219.6 44.5612 219.609 44.4701 219.609 44.3789H214.961V45.0625H217.012L211.488 50.1758V38.2266H207.387V38.9102H209.438V53.6758C209.438 54.5143 209.201 55.0156 208.727 55.1797C208.453 55.2708 208.007 55.3164 207.387 55.3164V56H213.402C213.402 55.599 213.266 55.3802 212.992 55.3438C212.919 55.3255 212.828 55.3164 212.719 55.3164ZM227.02 44.7891C228.296 44.7891 229.143 45.3268 229.562 46.4023C229.708 46.7487 229.781 47.1224 229.781 47.5234C229.781 48.4349 229.344 48.9909 228.469 49.1914C228.013 49.2826 227.366 49.319 226.527 49.3008L223.629 49.2188C223.72 47.1224 224.404 45.7552 225.68 45.1172C226.099 44.8984 226.546 44.7891 227.02 44.7891ZM231.777 53.375L231.094 53.1289C230.456 54.5143 229.426 55.2982 228.004 55.4805C227.822 55.4987 227.648 55.5078 227.484 55.5078C225.57 55.5078 224.367 54.3685 223.875 52.0898C223.729 51.4518 223.647 50.75 223.629 49.9844L226.91 50.0391C229.134 50.0755 230.565 49.8659 231.203 49.4102C231.695 49.0456 231.941 48.526 231.941 47.8516C231.941 46.612 231.312 45.6276 230.055 44.8984C229.161 44.3698 228.132 44.1055 226.965 44.1055C224.686 44.1055 223.055 45.0534 222.07 46.9492C221.56 47.9336 221.305 49.0456 221.305 50.2852C221.305 52.5456 222.116 54.2227 223.738 55.3164C224.704 55.9544 225.807 56.2734 227.047 56.2734C229.016 56.2734 230.465 55.5625 231.395 54.1406C231.54 53.8854 231.668 53.6302 231.777 53.375ZM239.844 55.3164H237.875V49.875C237.875 48.2161 238.385 46.8854 239.406 45.8828C239.807 45.5 240.145 45.2995 240.418 45.2812C240.728 45.2812 241.01 45.5091 241.266 45.9648C241.557 46.4753 241.831 46.7669 242.086 46.8398C242.195 46.8763 242.305 46.8945 242.414 46.8945C242.961 46.8945 243.307 46.6302 243.453 46.1016C243.49 45.9922 243.508 45.8828 243.508 45.7734C243.508 44.9531 243.089 44.4518 242.25 44.2695C242.068 44.2331 241.895 44.2148 241.73 44.2148C240.637 44.2148 239.661 44.6797 238.805 45.6094C238.404 46.0469 238.085 46.5391 237.848 47.0859L237.738 44.3789H233.773V45.0625H235.824V53.6758C235.824 54.5143 235.587 55.0156 235.113 55.1797C234.84 55.2708 234.393 55.3164 233.773 55.3164V56H240.527C240.527 55.599 240.391 55.3802 240.117 55.3438C240.044 55.3255 239.953 55.3164 239.844 55.3164Z" fill="white"/>
                        <rect width="60" height="60" fill="url(#pattern0)"/>
                        <defs>
                            <pattern id="pattern0" patternContentUnits="objectBoundingBox" width="1" height="1">
                                <use xlink:href="#image0" transform="scale(0.015625)"/>
                            </pattern>
                            <image id="image0" width="64" height="64" xlink:href="data:image/png;base64,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"/>
                        </defs>
                    </svg>
                </a>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="index.html">Home</a></li>
                <li><a onclick="profileRequest();">Profile</a></li>
                <li><a onclick="logbook();">Logbook</a></li>
                <li><a onclick="motivationPages('motivation');">Motivation</a></li>
                <li><a onclick="aboutAsthmaPages('aboutAsthma');">About Asthma</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a onclick="logout();"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-1 ">
        </div>
        <div class="col-sm-9 text-left">
            <h2>Welcome to Asthma Tracker</h2>

            <div class="col-sm-8">
                <div class="form-inline">
                    <label for="City">Search weather for another city:</label>
                    <input type="text" class="form-control" id="reqCity" >
                        <input type="button" class="btn btn-default" value="Search" onclick="findWeather();">
                            </div>
            </div>
        </div>
        <div class="col-sm-12" id="weather">
            <br>
                <%                      double humidity = 0;
                                        double temp = 0;
                                        try {
                                            OWM owm = new OWM("943ed901c118ec454eaac8992da7b77b");
                                            CurrentWeather cwd = owm.currentWeatherByCityName(user.getCity());

                                            // checking data retrieval was successful or not
                                                if (cwd.hasRespCode() && cwd.getRespCode() == 200) {

                                                /*      RAIN    ***/
                                                    if (cwd.hasRainData()) {


                                    %>
                                    <img id="weatherIMG" src="rain.jpeg" alt="rain" >
                                        <div class=" col-sm-5 weatherInfo">
                                            <% out.println("<h2 id=\"city-temp\">" + cwd.getCityName() + "</h2>"); %><br>
                                                <%  if (cwd.hasMainData() && cwd.getMainData().hasTemp()) {
                                                        temp = cwd.getMainData().getTemp();
                                                        temp = temp - 273.15;
                                                        /*Kelvin to Celcius*/
                                                        out.println("<h3 id=\"city-temp\">" + "Temperature:   " + temp + " °C" + "</h3>");
                                                    }
                                                    out.println("<h3 id=\"city-temp\">" + "Rain:   " + cwd.getRainData().getPrecipVol3h() + " mm" + "</h3>");
                                                    if (cwd.getMainData().hasHumidity()) {
                                                        out.println("<h3 id=\"city-temp\">" + "Humidity:   " + cwd.getMainData().getHumidity() + " %" + "</h3>");
                                                    }
                                                    out.println("<h3 id=\"city-temp\">" + "Wind:   " + cwd.getWindData().getSpeed() + " m/s" + "</h3>");
                                                    out.println("<h3 id=\"city-temp\">" + "Clouds:   " + cwd.getCloudData().getCloud() + " %" + "</h3>");


                                                %>
                                        </div>   <div class="col-sm-5" id="predictions">
                                            <h3 id="prediction-font">&ldquo;Be careful, the rain is not the ideal weather for workout</h3>
                                            <h3 id="prediction-font">Better, take a break!  &rdquo;</h3>
                                        </div>
                                        <%  } else if (cwd.hasSnowData()) {
                                                /**
                                                     * ******SNOW **********
                                                     */
                                        %>
                                        <img id="weatherIMG" src="snow.jpeg" alt="snow" >
                                            <div class="col-sm-5 snow">
                                                <% out.println("<h2 id=\"city-temp\">" + cwd.getCityName() + "</h2>"); %><br>
                                                    <%  if (cwd.hasMainData() && cwd.getMainData().hasTemp()) {
                                                            temp = cwd.getMainData().getTemp();
                                                            temp = temp - 273.15;
                                                            /*Kelvin to Celcius*/
                                                            out.println("<h3 id=\"city-temp\">" + "Temperature:   " + temp + " °C" + "</h3>");
                                                        }
                                                        out.println("<h3 id=\"city-temp\">" + "Snow:   " + cwd.getSnowData().getSnowVol3h() + " mm" + "</h3>");

                                                        out.println("<h3 id=\"city-temp\">" + "Wind:   " + cwd.getWindData().getSpeed() + " m/s" + "</h3>");
                                                        out.println("<h3 id=\"city-temp\">" + "Clouds:   " + cwd.getCloudData().getCloud() + " %" + "</h3>");


                                                    %>
                                            </div>  <div class="col-sm-5" id="predictions">
                                                <h3 id="prediction-font">&ldquo;Be careful, the cold air may trigger an asthma attack</h3>
                                                <h3 id="prediction-font">Take your meds with you!  &rdquo;</h3>
                                            </div>
                                            %><% } else {
                                                /*SUNNY WEATHER*/
                                            %>
                                            <img id="weatherIMG" src="sunn.jpg" alt="sun" >
                                                <div class="col-sm-5 weatherInfo">
                                                    <% out.println("<h2 id=\"city-temp\">" + cwd.getCityName() + "</h2>"); %><br>
                                                        <%  if (cwd.hasMainData() && cwd.getMainData().hasTemp()) {
                                                                temp = cwd.getMainData().getTemp();
                                                                temp = temp - 273.15;
                                                                /*Kelvin to Celcius*/
                                                                out.println("<h3 id=\"city-temp\">" + "Temperature:   " + temp + " °C" + "</h3>");
                                                            }
                                                            if (cwd.getMainData().hasHumidity()) {
                                                                out.println("<h3 id=\"city-temp\">" + "Humidity:   " + cwd.getMainData().getHumidity() + " %" + "</h3>");
                                                                humidity = cwd.getMainData().getHumidity();
                                                            }
                                                            out.println("<h3 id=\"city-temp\">" + "Wind:   " + cwd.getWindData().getSpeed() + " m/s" + "</h3>");
                                                            out.println("<h3 id=\"city-temp\">" + "Clouds:   " + cwd.getCloudData().getCloud() + " %" + "</h3>");


                                                        %>  </div>   <div class="col-sm-5" id="predictions">
                                                        <% if (temp > 5 && temp < 35) {
                                                            if (humidity > 30 && humidity < 65) {
                                                                out.println("<h3 id=\"prediction-font\">&ldquo;It's a perfect day for exercise</h3>");
                                                                    out.println("<h3 id=\"prediction-font\">What about a walk? &rdquo;</h3>");
                                                            } else {
                                                                    out.println("<h3 id=\"prediction-font\">&ldquo;Quite moist out there, better workout at home &rdquo;</h3>");

                                                                }


                                                        } else if (temp < 5) {
                                                            out.println("<h3 id=\"prediction-font\">&ldquo; It's cold outside.</h3>");
                                                                out.println("<h3 id=\"prediction-font\">It's better stay home and enjoy a hot chocolate! &rdquo;</h3>");

    }
                                                    %>
                                                </div> <%  }

                                                } else {
                                                %>
                                                <img id="weatherIMG" src="no.jpeg" alt="no" >
                                                    <div class="weatherInfo">
                                                        <% out.println("<h2 id=\"city-temp\">" + "There are no weather data, check connection" + "</h2>"); %><br>
                                                            <%
                                                                    }
    } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
                                                            %>
                                                    </div>
                                                    </div>
                                                    </div>
                                                    </div>
