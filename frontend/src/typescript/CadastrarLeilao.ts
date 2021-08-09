const listaProdutosSelecionados = [];

document.getElementById("botao-Leiloar").addEventListener("click", () => {
    let descricao = document.getElementById("descricao");
    let valorInicial = document.getElementById("valorInicial");
    let valorMeta = document.getElementById("valorMeta");
    let horaInicio = document.getElementById("inputHComecar");
    let horatermino = document.getElementById("inputHTerminar");
    let categoria = document.getElementById("categoria");

    console.log(horaInicio.value);
    console.log();
})

async function listarCategorias () {
    const rawResponse = await fetch('http://localhost:8080/api/categoria', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        "Authorization": `Bearer ${window.localStorage.getItem("token")}`
    }
    });
    if(rawResponse.ok)
        renderizarCategorias(rawResponse.json());
    else if(rawResponse.status == 403) {
        window.location.href = "../pages/login.html";
    }
}

function renderizarCategorias(json : Promise<any>) {
    let categoria = document.getElementById("categoria")
    json.then(dados => {
    let i = 0;
    let html = "";
    while(true) {
        if(dados[i] === undefined) {
        break;
        }
        let elemento = dados[i++];
        html += `<option value=${elemento["id"]}>${elemento["categoriaNome"]}</option>`;
    }
    categoria.innerHTML = html;
    })
}

async function listarProdutos () {
    const rawResponse = await fetch('http://localhost:8080/api/produtos-leiloar', {
    method: 'GET',
    headers: {
        'Content-Type': 'application/json',
        "Authorization": `Bearer ${window.localStorage.getItem("token")}`
    }
    });
    renderizarProdutosLeilao(rawResponse.json());
}

function renderizarProdutosLeilao(json : Promise<any>) {
    let listaProdutosDiv = document.getElementById("listaProdutos")
    json.then(dados => {
        let i = 0;
        let html = "";
        while(true) {
            if(dados[i] === undefined) {
                break;
            }
            let elemento = dados[i++];
            html += `<div id="produto" value=${elemento["id"]} style="border: 1px solid black; margin-top: 5pt;">
            <option>${elemento["nome"]}</option>
            </div>`;
        }
        listaProdutosDiv.innerHTML = html;
        addListenerProduto(listaProdutosDiv.querySelectorAll('[id=produto]'));
    })
}

function addListenerProduto(lista : NodeListOf<Element>) {
    lista.forEach(elementLista => {
        let element = elementLista as HTMLElement;
        element.addEventListener("click", () => {
            if(listaProdutosSelecionados.includes(element)) {
                element.style.backgroundColor = null;
                listaProdutosSelecionados[listaProdutosSelecionados.indexOf(element)] = null;
            } else {
                for(let i = 0; i <= listaProdutosSelecionados.length; i++) {
                    if(listaProdutosSelecionados[i] == null) {
                        listaProdutosSelecionados[i] = element;
                        element.style.backgroundColor = "white";
                        console.log(listaProdutosSelecionados);
                        break;
                    }
                }
                if(listaProdutosSelecionados.length == 0) {
                    listaProdutosSelecionados[0] = element;
                    element.style.backgroundColor = "white";
                    console.log(listaProdutosSelecionados);
                }
            }
        });
      });
}

listarCategorias();
listarProdutos();