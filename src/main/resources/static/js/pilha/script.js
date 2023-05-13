var topo = 0;
var tamanho = 0;

$(document).ready(function () {
    getPilha();
});

var btnEmpilhar = document.getElementById("btpush");
var btnDesempilhar = document.getElementById("btpop");
var btnTamanho = document.getElementById("btcriar");
var btnAleatorio = document.getElementById("btaleatorio");

btnTamanho.addEventListener("click", function () {
    var tamanhoPilha = document.getElementById("txttamanho").value;

    $.ajax({
        url: "/api/pilha/" + tamanhoPilha,
        type: 'GET',
        success: function (data, textStatus, xhr) {
            getPilha();
            log("Pilha de tamanho: " + data);
        },
        error: function (error) {
            alert("Erro: " + error);
        }
    });
});

btnEmpilhar.addEventListener("click", function () {
    var valor = document.getElementById("txtvalor").value;

    $.ajax({
        url: "/api/pilha/push",
        type: 'POST',
        data: JSON.stringify({ valor }),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            getPilha();
        },
        error: function (error) {
            // alert("Erro: " + error);
            log("Pilha Cheia");
        }
    });
});

btnDesempilhar.addEventListener("click", function () {
    console.log(topo);
    $.ajax({
        url: "/api/pilha/pop",
        type: 'GET',
        success: function (data, textStatus, xhr) {
            getPilha();
            log("valor desimpilhado: " + data);
        },
        error: function (error) {
            // alert("Erro: " + error);
            log("Pilha vazia");
        }
    });
});

btnAleatorio.addEventListener("click", function () {

    var valor = Math.floor(Math.random() * 100);

    $.ajax({
        url: "/api/pilha/push",
        type: 'POST',
        data: JSON.stringify({ valor }),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            getPilha();
            log("Valor aleatorio adicionado: " + valor);
        },
        error: function (error) {
            // alert("Erro: " + error);
            log("Pilha Cheia");
        }
    });
});

function getPilha() {
    $.ajax({
        url: "/api/pilha",
        type: 'GET',
        success: function (data, textStatus, xhr) {
            drawStack(data.lista.length, data.lista, data.topo);
        },
        error: function (error) {
            drawStack(0, [], 0);
            // alert("Erro: " + error);
            // log("Pilha vazia");
        }
    });
}

function drawStack(size, pilhaArray, topo) {
    $("#tpilha").find('tbody')
        .empty()
        .append($('<tr>')
            .append($('<td id="s' + size + '" class="right">')
                .text('')
            )
            .append($('<td id="i' + size + '" class="indice right">')
                .text(size)
            )
            .append($('<td id="v' + size + '" class="valor">')
                .html('&nbsp;')
            )
        );
    for (var i = size - 1; i >= 0; i--) {
        var valor = pilhaArray[i];
        $("#tpilha").find('tbody')
            .append($('<tr>')
                .append($('<td id="s' + i + '" class="right">')
                    .text('')
                )
                .append($('<td id="i' + i + '" class="indice right">')
                    .text(i)
                )
                .append($('<td id="v' + i + '" class="valor borda">')
                    .html(valor)
                )
            );
    }
    $('#s' + topo).html('TOPO →');
}

function log(msg) {
    $('#log').html(msg + "<br>" + $('#log').html());
}