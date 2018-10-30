/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function logbook() {
    var action = "load";
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

    xhr.send('action=' + action);

}

function logSubmit() {
    var attackDate = document.getElementById("attack").value;
    var attackDuration = document.getElementById("duration").value;
    var unit = document.getElementById("sel1").value;
    var attackTriggers = document.getElementById("triggers").value;
    var peakFlowDate = document.getElementById("flow").value;
    var peakFlowValue = document.getElementById("value").value;
    var wheeze = document.getElementById("wheeze");
    var cough = document.getElementById("cough");
    var phlegm = document.getElementById("phlegm");
    var tightness = document.getElementById("tightness");
    var breathing = document.getElementById("breathing");
    var wakeup = document.getElementById("wakeup");
    var notes = document.getElementById('notes').value;

    var action = "add";
    if (wheeze.checked === true) {
        wheeze = 1;
    } else {
        wheeze = 0;
    }
    if (cough.checked === true) {
        cough = 1;
    } else {
        cough = 0;
    }
    if (phlegm.checked === true) {
        phlegm = 1;
    } else {
        phlegm = 0;
    }
    if (tightness.checked === true) {
        tightness = 1;
    } else {
        tightness = 0;
    }
    if (breathing.checked === true) {
        breathing = 1;
    } else {
        breathing = 0;
    }
    if (wakeup.checked === true) {
        wakeup = 1;
    } else {
        wakeup = 0;
    }

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
    xhr.open('POST', 'LogbookServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');


    xhr.send('action=' + action + '&attackDate=' + attackDate + '&attackDuration=' + attackDuration
            + '&unit=' + unit + '&attackTriggers=' + attackTriggers + '&peakFlowDate=' + peakFlowDate
            + '&peakFlowValue=' + peakFlowValue + '&wheeze=' + wheeze + '&cough=' + cough + '&phlegm=' + phlegm + '&tightness=' + tightness
            + '&breathing=' + breathing + '&wakeup=' + wakeup + '&notes=' + notes);
}

function saveChanges(id) {
    var notes = document.getElementById("notes" + id).innerHTML;


    var action = "update";

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('browseMessage')
                    .innerHTML = xhr.responseText;
            document.getElementById('browseMessage').style.color = "green";


        } else if (xhr.status !== 200) {
            document.getElementById('browseMessage')
                    .innerHTML = xhr.responseText;
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    xhr.open('POST', 'LogbookServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('action=' + action + '&id=' + id + '&notes=' + notes);




}


function deleteNote(id) {

    var action = "delete";

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('browseMessage')
                    .innerHTML = xhr.responseText;
            document.getElementById('browseMessage').style.color = "green";


        } else if (xhr.status !== 200) {
            document.getElementById('browseMessage')
                    .innerHTML = xhr.responseText;
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    xhr.open('POST', 'LogbookServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('action=' + action + '&id=' + id);


}

function exportData(type) {
    var fileType = type;

    var xhr = new XMLHttpRequest();
    xhr.onload = function () {

        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById('browseMessage')
                    .innerHTML = xhr.responseText;
            document.getElementById('browseMessage').style.color = "green";


        } else if (xhr.status !== 200) {
            document.getElementById('browseMessage')
                    .innerHTML = xhr.responseText;
            alert('Request failed. Returned status of ' + xhr.status);
        }
    };
    xhr.open('POST', 'ExportServlet');
    xhr.setRequestHeader('Content-type',
            'application/x-www-form-urlencoded');

    xhr.send('fileType=' + fileType);

}