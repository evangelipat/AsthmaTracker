/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict';

function showRegistrationForm() {
    document.getElementById("active").setAttribute("style", "background-color:#b1cff9;");
    document.getElementById("btn-group").style.visibility = "hidden";
    var main = document.getElementById('mainContent');

    var registration = [
        '<div class="registration">',
        '<div class="col-lg-12" id="headline" style="top:10px;">',
        '<h2>Sign Up</h2>',
        '</div><br>',
        '<br><div class="col-sm-12" id="prwto">',
        '<div class="col-xs-4"></div>',
        '<div class="col-xs-4">',
        '<label for="name">First name:</label>\n\
         <input type="text" class="form-control" id="firstname" placeholder="Enter your first name" name="firstname" pattern="[A-Za-z]{0,25}" title="Must contain 2 until 25 latin characters">\n\
         <label for="name">Last name:</label>\n\
         <input type="text" class="form-control" id="lastname" placeholder="Enter your last name" name="lastname" pattern="[A-Za-z]{0,25}" title="Must contain 2 until 25 latin characters">\n\
         <label for="email">Email:</label>\n\
         <input type="email" class="form-control" id="email" placeholder="Enter Email" onchange="check_email();" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="e.g. example@example.com" required>\n\
         <h5 id="email_check"></h5>\n\
         <label for="password">Password:</label>\n\
         <input type="password" class="form-control" id="password" placeholder="Enter Password" name="pw" onkeyup="check_passwords();" pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{3,10}" title="Must contain 3 until 10 characters, at least one letter, one number and one special character" required>\n\
         <label for="confirm_password">Confirm Password:</label>\n\
         <input type="password" class="form-control" id="confirm_password" placeholder="Confirm Password" name="psw-repeat" onkeyup="check_passwords();" pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{3,10}" title="Must contain 3 until 10 characters, at least one letter, one number and one special character" required>\n\
         <h5 id="password_message"></h5>\n\
         <label>Birthday:</label>\n\
         <input type="date" class="form-control" id="bday" name="bday" min="1940-01-01" required>\n\
         <h5>Gender:</h5><label for="male">Male</label>\n\
         <input type="radio" name="gender" id="male" value="male">&emsp;\n\
         <label for="female">Female</label>\n\
         <input type="radio" name="gender" id="female" value="female">&emsp;\n\
         <label for="other">Other</label>\n\
          <input type="radio" name="gender" id="other"  checked="checked" value="other">&emsp;',
        '</div>', //4
        '<div class="col-xs-5">',
        '<div class="col-xs-1"></div>',
        '<br><br>',
        '<div class="col-sm-12">',
        '<input type="button" id="signup_btn" value="Sign Up" class="btn btn-default btn-lg" onclick="sendAjaxPost();">',
        '</div>',
        '</div></div>',
        '<div class="col-xs-12">',
        '<div class="col-xs-4" id="ajaxContentS"></div>',
        '</div>',
        '<br><div class="col-sm-12" id="member">',
        '<div class="col-xs-4" id="not">',
        '<p>Already a member?<button type="button" class="btn btn-link" onclick="showLoginForm();">Sign In</button></p>',
        '</div>',
        '</div>',
        '</div>'
    ].join("\n"); // Create a string that holds the HTML code of the registration form
    main.innerHTML = registration;

}

function showLoginForm() {
    document.getElementById("active").setAttribute("style", "background-color:#b1cff9;");
    document.getElementById("btn-group").style.visibility = "hidden";
    var main = document.getElementById('mainContent');
    var registration = [
        '<div class="login_form" id="login_form">',
        '<div class="col-sm-12"><br></div>',
        '<div class="col-sm-12">',
        '<div class="col-xs-5" id="user">',
        '<i class="fa fa-user-circle-o" style="font-size:110px;"></i>',
        '</div>',
        '</div>', //12
        '<div class="col-sm-12" >',
        '<div class="col-xs-4"></div>',
        '</div>', //12
        '<div class="col-sm-12" id="loginform">',
        '<div class="col-xs-4"></div>',
        '<div class="col-xs-4">',
        '<label for="email">Email:</label>\n\
         <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="e.g. example@example.com" required>\n\
         <br><label for="password">Password:</label>\n\
         <input type="password" class="form-control" id="password" placeholder="Enter Password" name="pw" pattern="^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,10}" title="Must contain 8 until 10 characters, at least one letter, one number and one special character" required>',
        '</div>', //4
        '</div>', //12
        '<div class="col-sm-12" id="buttonLogin">',
        '<div class="col-xs-4"></div>',
        '<div class="col-xs-4" id="user">',
        '<input type="button" value="Login" class="btn btn-default btn-lg" onclick="sendAjaxPostLogin();">',
        '</div>', //4
        '<div class="col-xs-2" id="ajaxContent"></div>',
        '</div>', //12
        '<div class="col-sm-12" id="notAmember">',
        '<div class="col-xs-4"></div>',
        '<div class="col-xs-4" id="not">',
        '<p>Not a member?<button type="button" class="btn btn-link" onclick="showRegistrationForm();">Sign Up</button></p>',
        '</div>',
        '</div>',
        '</div>'
    ].join("\n"); // Create a string that holds the HTML code of the registration form
    main.innerHTML = registration;

}