/**
 * Created by seb on 15.08.16.
 */

function sendHttpRequest(url, result) {
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (xhttp.readyState == 4 && xhttp.status == 200) {
            result(xhttp.responseText);
        }
    };
    xhttp.open("GET", url, true);
    xhttp.send();
}
