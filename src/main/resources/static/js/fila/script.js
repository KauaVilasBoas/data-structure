// Variáveis globais
var fila = [];
var tamanho = 0;

$(document).ready(function () {
    $('#btcriar').click(function () {
        criarFila();
    });

    $('#btenfileirar').click(function () {
        enfileirar();
    });

    $('#btaleatorio').click(function () {
        enfileirarAleatorio();
    });

    $('#btdesenfileirar').click(function () {
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
        if (fila.length < tamanho) {
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
    if (fila.length < tamanho) {
        var valorAleatorio = Math.floor(Math.random() * 100);
        fila.push(valorAleatorio);
        drawFila(tamanho);
        log('Valor aleatório ' + valorAleatorio + ' enfileirado com sucesso.');
    } else {
        log('A fila está cheia. Não é possível enfileirar mais valores.');
    }
}

function desenfileirar() {
    if (fila.length > 0) {
        var valorDesenfileirado = fila.shift();
        drawFila(tamanho);
        log('Valor ' + valorDesenfileirado + ' desenfileirado com sucesso.');
    } else {
        log('A fila está vazia. Não é possível desenfileirar mais valores.');
    }
}

function limpar() {
    fila = [];
    drawFila(tamanho);
    log('Fila limpa.');
}

function drawFila(tamanho, fila) {
    var canvas = $('#canvas');
    canvas.empty();

    for (var i = 0; i < tamanho; i++) {
        var value = '';
        var classValue = 'valor';

        if (i < fila.length) {
            value = fila[i];
            if (i === 0) {
                classValue += ' inicio';
            }
            if (i === fila.length - 1) {
                classValue += ' fim';
            }
        }

        var item = $('<div></div>')
            .addClass(classValue)
            .css('top', (i * 40) + 'px')
            .text(value);

        canvas.append(item);
    }
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
            drawFila(data.length, data);
            // return data;
        },
        error: function (error) {
            alert("getFilaAjax: Erro: " + error);
            // return null;
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
            alert("queueAjax: Erro: " + error);
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
            alert("unqueueAjax: Erro: " + error);
        }
    });
}