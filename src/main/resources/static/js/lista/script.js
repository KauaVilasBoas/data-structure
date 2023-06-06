
$(document).ready(function () {
    listar();
})

function inserirInicio() {
    var valor = document.getElementById("inserirInicioInput").value;

    fetch("/api/lista/addInicio", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            valor: valor
        })
    })
        .then(function (response) {
            if (response.ok) {
                listar();
            }
        });
}

function inserirMeio() {

    var posicao = document.getElementById("inserirMeioPosicaoInput").value;
    var elemento = document.getElementById("inserirMeioInput").value;

    console.log(posicao + " - " + elemento)

    fetch("/api/lista/addMeio", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            elemento: elemento,
            posicao: posicao
        })
    })
        .then(function (response) {
            if (response.ok) {
                listar();
            }
        });

}

function inserirFim() {
    var valor = document.getElementById("inserirFimInput").value;

    fetch("/api/lista/addFim", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            valor: valor
        })
    })
        .then(function (response) {
            if (response.ok) {
                listar();
            }
        });
}

function removerInicio() {
    fetch("/api/lista/removerInicio", {
        method: "DELETE"
    })
        .then(function (response) {
            if (response.ok) {
                listar();
            }
        });
}

function removerFim() {
    fetch("/api/lista/removerFim", {
        method: "DELETE"
    })
        .then(function (response) {
            if (response.ok) {
                listar();
            }
        });
}

function listar() {
    fetch("/api/lista/listarLista")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            var listaElement = document.getElementById("lista");
            listaElement.innerHTML = "";

            var listaArray = JSON.parse(data.lista);

            var table = document.createElement("table");
            table.classList.add("lista-table");

            var tbody = document.createElement("tbody");

            var tr = document.createElement("tr");

            var thNo = document.createElement("th");
            thNo.innerText = "No";

            var thValor = document.createElement("th");
            thValor.innerText = "Valor";

            var thProximo = document.createElement("th");
            thProximo.innerText = "Próxima";

            tr.appendChild(thNo);
            tr.appendChild(thValor);
            tr.appendChild(thProximo);

            tbody.appendChild(tr);

            for (var i = 0; i < listaArray.length; i++) {
                var tr = document.createElement("tr");

                var tdNo = document.createElement("td");
                tdNo.innerText = i;

                var tdValor = document.createElement("td");
                tdValor.innerText = listaArray[i];

                var tdProximo = document.createElement("td");
                tdProximo.innerText = i < listaArray.length - 1 ? i + 1 : "-";

                tdProximo.classList.add("arrow-cell");

                tr.appendChild(tdNo);
                tr.appendChild(tdValor);
                tr.appendChild(tdProximo);

                tbody.appendChild(tr);
            }

            table.appendChild(tbody);
            listaElement.appendChild(table);
        });
}