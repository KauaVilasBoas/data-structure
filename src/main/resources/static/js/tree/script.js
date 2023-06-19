$(document).ready(function () {
    listar();
})

function listar() {
    fetch("/api/tree")
        .then(function (response) {
            return response.json();
        })
        .then(function (data) {
            console.log(data);
            root = null; // Limpa a árvore antes de adicionar os novos valores
            for (const value of data.preOrder) {
                root = addNode(root, value);
            }
            clearTree();
            traverseTree(root, 500, 50, 0, null, null);
            document.getElementById("inOrderOutput").innerHTML = ""; // Limpar a exibição em ordem
            document.getElementById("posOrderOutput").innerHTML = ""; // Limpar a exibição em pós-ordem
            inOrdem(root); // Exibir a ordem em inOrdem
            posOrdem(root); // Exibir a ordem em posOrdem
        });
}


function addAjax(valor) {
    fetch("/api/tree/add", {
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
                // listar();
            }
        });
}

function removeAjax(valor) {
    fetch("/api/tree/remove", {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            valor: valor
        })
    })
        .then(function (response) {
            if (response.ok) {
                // listar();
            }
        });
}

// Classe para representar cada nó da árvore binária
class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// Função para adicionar um novo nó à árvore binária
function addNode(root, value) {
    if (root === null) {
        return new Node(value);
    } else {
        if (value < root.value) {
            root.left = addNode(root.left, value);
        } else {
            root.right = addNode(root.right, value);
        }
        return root;
    }
}

// Função para percorrer a árvore e criar os nós e ligações no SVG
function traverseTree(root, x, y, level, parentX, parentY) {
    if (root !== null) {
        const circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        circle.setAttribute("cx", x.toString());
        circle.setAttribute("cy", y.toString());
        circle.setAttribute("r", "20");
        circle.setAttribute("class", "node");
        circle.setAttribute("id", "node-" + root.value.toString()); // Adiciona o id ao círculo
        const text = document.createElementNS("http://www.w3.org/2000/svg", "text");
        text.setAttribute("x", (x - 7).toString());
        text.setAttribute("y", (y + 5).toString());
        text.textContent = root.value.toString();
        text.setAttribute("fill", "white"); // Definindo a cor branca para os números
        document.getElementById("tree").appendChild(circle);
        document.getElementById("tree").appendChild(text);

        if (parentX !== null && parentY !== null) {
            const line = document.createElementNS("http://www.w3.org/2000/svg", "line");
            line.setAttribute("x1", parentX.toString());
            line.setAttribute("y1", parentY.toString());
            line.setAttribute("x2", x.toString());
            line.setAttribute("y2", y.toString());
            line.setAttribute("class", "link");
            document.getElementById("tree").appendChild(line);
        }

        const newLevel = level + 1;
        const deltaY = 80;
        const deltaX = 120 / Math.pow(2, newLevel);

        traverseTree(root.left, x - deltaX, y + deltaY, newLevel, x, y);
        traverseTree(root.right, x + deltaX, y + deltaY, newLevel, x, y);
    }
}

// Função para adicionar valor à árvore binária
function addValue() {
    const value = parseInt(document.getElementById("txtvalor").value);
    if (!isNaN(value)) {
        addAjax(value);
        root = addNode(root, value);
        clearTree();
        traverseTree(root, 500, 50, 0, null, null);
    }
    document.getElementById("valueInput").value = "";
}

// Função para remover valor à árvore binária
function removeValue() {
    const value = parseInt(document.getElementById("txtvalor").value);
    if (!isNaN(value)) {
        removeAjax(value);
        listar();
    }
    document.getElementById("valueInput").value = "";
}

// Função para achar valor na árvore binária
function achar() {
    const value = parseInt(document.getElementById("txtvalor").value);
    if (!isNaN(value)) {
        const node = findNode(root, value); // Encontra o nó com o valor na árvore

        if (node) {
            // Marca o nó encontrado com outra cor
            const nodeId = "node-" + node.value.toString();
            const nodeElement = document.getElementById(nodeId);
            nodeElement.setAttribute("style", "fill: red; background-color: yellow;");
        }
    }
    document.getElementById("txtvalor").value = "";
}

// Função para encontrar o nó com o valor na árvore
function findNode(root, value) {
    if (root === null || root.value === value) {
        return root;
    } else if (value < root.value) {
        return findNode(root.left, value);
    } else {
        return findNode(root.right, value);
    }
}

// Função para percorrer a árvore em ordem (in-order) e exibir os valores
function inOrdem(root) {
    if (root !== null) {
        inOrdem(root.left);
        console.log(root.value);
        // Exibir na tela
        const nodeValue = document.createElement("div");
        nodeValue.textContent = root.value.toString();
        document.getElementById("inOrderOutput").appendChild(nodeValue);
        inOrdem(root.right);
    }
}

// Função para percorrer a árvore em pós-ordem (post-order) e exibir os valores
function posOrdem(root) {
    if (root !== null) {
        posOrdem(root.left);
        posOrdem(root.right);
        console.log(root.value);
        // Exibir na tela
        const nodeValue = document.createElement("div");
        nodeValue.textContent = root.value.toString();
        document.getElementById("posOrderOutput").appendChild(nodeValue);
    }
}


// Função para limpar a árvore
function clearTree() {
    const tree = document.getElementById("tree");
    while (tree.firstChild) {
        tree.removeChild(tree.firstChild);
    }
}

let root = null;