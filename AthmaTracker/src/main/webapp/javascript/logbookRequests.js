/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function logbook() {
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
    xhr.open('POST', 'LogbookServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send();

}

function logSubmit() {
    var attack = document.getElementById("attack").value;
    var duration = document.getElementById("duration").value;
    var sel1 = document.getElementById("sel1").value;
    var triggers = document.getElementById("triggers").value;
    var flow = document.getElementById("flow").value;
    var value = document.getElementById("value").value;
    var checkbox = document.getElementsByClassName("checkbox");
    var wheeze = document.getElementById("wheeze");
    var cough = document.getElementById("cough");
    var phlegm = document.getElementById("phlegm");
    var tightness = document.getElementById("tightness");
    var breathing = document.getElementById("breathing");
    var wakeup = document.getElementById("wakeup");
    var notes = document.getElementById('notes').value;

    if (wheeze.checked === true) {
        //alert("la");
        }

}