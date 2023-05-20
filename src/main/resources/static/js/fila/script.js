// Variáveis globais
var fila = [];
var tamanho = 0;

$(document).ready(function () {

    getFilaAjax();
    console.log(fila);

    $('#btcriar').click(function () {
        console.log(fila);
        criarFila();
    });

    $('#btenfileirar').click(function () {
        console.log(fila);
        enfileirar();
    });

    $('#btaleatorio').click(function () {
        console.log(fila);
        enfileirarAleatorio();
    });

    $('#btdesenfileirar').click(function () {
        console.log(fila);
        desenfileirar();

    });

    $('#btlimpar').click(function () {
        limpar();
    });
});

function criarFila() {
    var novoTamanho = parseInt($('#txttamanho').val(), 10);

    if (!isNaN(novoTamanho) && novoTamanho >= 2 && novoTamanho <= 10) {
        setSize(novoTamanho);
        tamanho = novoTamanho;
        // var filaAjax = getFilaAjax();
        // console.log("== "+ filaAjax);
        // fila = filaAjax;
        // fila = [];
        // drawFila(tamanho);
        log('Fila criada com tamanho ' + tamanho);
    } else {
        log('Por favor, insira um tamanho válido (entre 2 e 10).');
    }
}

function enfileirar() {
    var valor = parseInt($('#txtvalor').val(), 10);

    if (!isNaN(valor)) {
        // if (fila.length < tamanho) {
        if (true) {
            queueAjax(valor);
            // fila.push(valor);
            // drawFila(tamanho);
            log('Valor ' + valor + ' enfileirado com sucesso.');
        } else {
            log('A fila está cheia. Não é possível enfileirar mais valores.');
        }
    } else {
        log('Por favor, insira um valor válido.');
    }
}

function enfileirarAleatorio() {
    // if (fila.length < tamanho) {
    if (true) {
        var valorAleatorio = Math.floor(Math.random() * 100);
        queueAjax(valorAleatorio);
        // fila.push(valorAleatorio);
        // drawFila(tamanho);
        log('Valor aleatório ' + valorAleatorio + ' enfileirado com sucesso.');
    } else {
        log('A fila está cheia. Não é possível enfileirar mais valores.');
    }
}

function desenfileirar() {
    // if (fila.length > 0) {
    if (true) {
        unqueueAjax();
        // var valorDesenfileirado = fila.shift();
        // drawFila(tamanho);
        log('Valor ' + valorDesenfileirado + ' desenfileirado com sucesso.');
    } else {
        log('A fila está vazia. Não é possível desenfileirar mais valores.');
    }
}

function limpar() {
    var log = document.getElementById("log").innerHTML = "";
}

function drawFila(tamanho, fila, inicio, fim) {
    var canvas = $('#canvas');
    canvas.empty();

    for (var i = 0; i < tamanho; i++) {
        var value = '';
        var classValue = 'valor';

        if (i < fila.length) {
            value = fila[i];
            if (i === inicio) {
                classValue += ' inicio';
            }
            if (i === fim) {
                classValue += ' fim';
            }
        }

        var item = $('<div></div>')
            .addClass(classValue)
            .css('top', (i * 40) + 'px')
            .text(value);

        canvas.append(item);
    }

    // Atualizar o HTML do início e fim da fila
    $('#inicio').text('Início: ' + inicio);
    $('#fim').text('Fim: ' + fim);
}

function log(message) {
    var log = $('#log');
    log.append('<p>' + message + '</p>');
    log.scrollTop(log[0].scrollHeight);
}

function getFilaAjax() {
    $.ajax({
        url: "/api/fila",
        type: 'GET',
        success: function (data, textStatus, xhr) {
            fila = data.lista;
            drawFila(data.lista.length, data.lista, data.inicio, data.fim);
        },
        error: function (error) {
            drawFila(0, [], 0, 0);
        }
    });
}

function setSize(tamanhoFila) {
    $.ajax({
        url: "/api/fila/" + tamanhoFila,
        type: 'GET',
        success: function (data, textStatus, xhr) {
            getFilaAjax();
        },
        error: function (error) {
            alert("setSize: Erro: " + error);
        }
    });
}

function queueAjax(valor) {
    $.ajax({
        url: "/api/fila/queue",
        type: 'POST',
        data: JSON.stringify({ valor }),
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            getFilaAjax();
        },
        error: function (error) {
            log("Fila cheia");
        }
    });
}

function unqueueAjax() {
    $.ajax({
        url: "/api/fila/unqueue",
        type: 'GET',
        success: function (data, textStatus, xhr) {
            getFilaAjax();
        },
        error: function (error) {
            log("Fila vazia");
        }
    });
}