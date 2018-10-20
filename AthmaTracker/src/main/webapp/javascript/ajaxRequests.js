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

function checkSession() {

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
        } else if (xhr.status !== 200) {
            document.getElementById('mainContent')
                    .innerHTML = xhr.responseText;
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    xhr.open('POST', 'CheckSession');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send();

}


function profileRequest() {
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;

        } else if (xhr.status !== 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    xhr.open('POST', 'ProfileServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send();

}
var count = 0;
///////////////////////////profile//////////////////////////////
function addMedicationRow() {
    count++;
    var container = document.getElementById("baseMedication");
    while (container.hasChildNodes()) {
        container.removeChild(container.lastChild);
    }

    container.appendChild(document.createElement("br"));
    container.appendChild(document.createTextNode("Name: "));
    var inputText = document.createElement("input");
    inputText.type = "text";
    inputText.id = "drugName";
    container.appendChild(inputText);

    container.appendChild(document.createTextNode('\u00a0'));
    container.appendChild(document.createTextNode('\u00a0'));
    container.appendChild(document.createTextNode('\u00a0'));
    container.appendChild(document.createTextNode('\u00a0'));

    container.appendChild(document.createTextNode("Dosage: "));
    var inputNum = document.createElement("input");
    inputNum.id = "dosage";
    inputNum.type = "number";
    inputNum.name = "quantity";
    inputNum.min = "1";
    container.appendChild(inputNum);

    container.appendChild(document.createElement("br"));
    container.appendChild(document.createElement("br"));

}






function saveChanges() {

    if (count === 0) {

        document.getElementById('saveMessage').innerHTML = "Nothing to save!";

    } else {
        var name = document.getElementById("drugName").value;
        var dosage = document.getElementById("dosage").value;

        if ((name === "") || (dosage === "")) {
            document.getElementById('saveMessage').innerHTML = "Empty fields!";

        } else {
            var action = "add";
            var id = 0;
            var xhr = new XMLHttpRequest();
            xhr.onload = function () {

                if (xhr.readyState === 4 && xhr.status === 200) {
                    document.getElementById('saveMessage')
                            .innerHTML = xhr.responseText;
                    document.getElementById('saveMessage').style.color = "green";

                } else if (xhr.status !== 200) {
                    document.getElementById('saveMessage')
                            .innerHTML = xhr.responseText;
                    alert('Request failed. Returned status of ' + xhr.status);
                }
            };
            xhr.open('POST', 'MedicationServlet');
            xhr.setRequestHeader('Content-type',
                    'application/x-www-form-urlencoded');

            xhr.send('name=' + name + '&dosage=' + dosage + '&action=' + action + '&id=' + id);

        }
    }
}

function deleteMedication(name, dosage, id) {


    var action = "delete";

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('saveMessage')
                    .innerHTML = xhr.responseText;
            document.getElementById('saveMessage').style.color = "green";


        } else if (xhr.status !== 200) {
            document.getElementById('saveMessage')
                    .innerHTML = xhr.responseText;
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    xhr.open('POST', 'MedicationServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('name=' + name + '&dosage=' + dosage + '&action=' + action + '&id=' + id);


}
////////////////////////////////////////////////////////////////////////

function logout() {

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
        } else if (xhr.status !== 200) {
            document.getElementById('active')
                    .innerHTML = xhr.responseText;
        }
    };
    xhr.open('POST', 'LogOutServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send();
}

