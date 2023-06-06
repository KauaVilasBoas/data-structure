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

    fetch("/api/lista/addMeio", {
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

            var lista = data.lista.split(", "); // Converte a string em um array

            // Cria a tabela
            var table = document.createElement("table");
            table.classList.add("lista-table");

            // Cabeçalho da tabela
            var thead = document.createElement("thead");
            var headerRow = document.createElement("tr");
            var headerCell = document.createElement("th");
            headerCell.textContent = "Elemento";
            headerRow.appendChild(headerCell);
            thead.appendChild(headerRow);
            table.appendChild(thead);

            // Corpo da tabela
            var tbody = document.createElement("tbody");

            // Loop para criar as linhas da tabela
            for (var i = 0; i < lista.length; i++) {
                var row = document.createElement("tr");

                // Célula com o elemento da lista
                var elementCell = document.createElement("td");
                elementCell.textContent = lista[i];
                row.appendChild(elementCell);

                // Célula com a seta (se houver próximo elemento)
                if (i < lista.length - 1) {
                    var arrowCell = document.createElement("td");
                    arrowCell.innerHTML = "&#8594;"; // Seta para a direita
                    row.appendChild(arrowCell);
                }

                tbody.appendChild(row);
            }

            table.appendChild(tbody);
            listaElement.appendChild(table);
        });
}


