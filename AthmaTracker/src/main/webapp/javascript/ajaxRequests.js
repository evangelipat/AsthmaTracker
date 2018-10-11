/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function check_email() {
    var email = document.getElementById('email').value;

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('email_check')
                    .innerHTML = xhr.responseText;
        } else if (xhr.status !== 200) {
            document.getElementById('email_check')
                    .innerHTML = xhr.responseText;
        }
    };
    xhr.open('POST', 'CheckEmail');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('email=' + email);
}
function check_passwords() {
    var password = document.getElementById('password').value;
    var confirm_password = document.getElementById('confirm_password').value;

    if (password !== confirm_password) {
        document.getElementById('password_message').style.color = 'red';
        document.getElementById('password_message').innerHTML = "Passwords do not match";
    } else {
        document.getElementById('password_message').style.color = 'green';
        document.getElementById('password_message').innerHTML = "Matching";
    }
}
function val_Gender() {

    var gender;
    if (document.getElementById('male').checked) {
        gender = document.getElementById('male').value;
        return gender;
    } else if (document.getElementById('female').checked) {
        gender = document.getElementById('female').value;
        return gender;
    } else {
        gender = "other";
        return gender;
    }
}

function sendAjaxPost() {
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var bday = document.getElementById('bday').value;
    var gender = val_Gender();

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('active').innerHTML = xhr.responseText;
        } else if (xhr.status !== 200) {
            document.getElementById('ajaxContentS').innerHTML = xhr.responseText;

        }
    };
    xhr.open('POST', 'SignUpServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('firstname=' + firstname + '&lastname=' + lastname + '&password=' + password
            + '&email=' + email + '&birth_date=' + bday + '&gender=' + gender);

}

function sendAjaxPostLogin() {
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('active').innerHTML = xhr.responseText;
        } else {
            document.getElementById('ajaxContent').innerHTML = xhr.responseText;
        }

    };

    xhr.open('POST', 'LoginServlet');
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send('email=' + email + '&password=' + password);

}
