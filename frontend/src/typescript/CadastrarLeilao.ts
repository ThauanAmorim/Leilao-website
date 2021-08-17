const listaProdutosSelecionados = [];
const listaIdsProdutos = [];

document.getElementById("botao-Leiloar").addEventListener("click", async () => {
    let descricao = document.getElementById("descricao");
    let valorInicial = document.getElementById("valorInicial");
    let valorMeta = document.getElementById("valorMeta");
    let horaInicio = document.getElementById("inputHComecar");
    let datainicio = document.getElementById("inputDComecar");
    let horatermino = document.getElementById("inputHTerminar");
    let dataTermino = document.getElementById("inputDTerminar");
    let categoria = document.getElementById("categoria");

    if((valorInicial as HTMLInputElement).value === "") {
        (valorInicial as HTMLInputElement).value = "0";
    }

    for (let index = 0; index < listaProdutosSelecionados.length; index++) {
        listaIdsProdutos[index] = parseInt((listaProdutosSelecionados[index] as HTMLDivElement).className);
        
    }

    //validador
    let flag = true;
    if((descricao as HTMLInputElement).value === "") {
        descricao.style.border = "2px solid red";
        flag = false;
    } else {
        descricao.style.border = null;

    }
    if((valorInicial as HTMLInputElement).value === "") {
        valorInicial.style.border = "2px solid red";
        flag = false;
    } else {
        valorInicial.style.border = null;

    }
    if((valorMeta as HTMLInputElement).value === "") {
        valorMeta.style.border = "2px solid red";
        flag = false;
    } else {
        valorMeta.style.border = null;

    }
    if((horaInicio as HTMLInputElement).value === "") {
        horaInicio.style.border = "2px solid red";
        flag = false;
    } else {
        horaInicio.style.border = null;

    }
    if((datainicio as HTMLInputElement).value === "") {
        datainicio.style.border = "2px solid red";
        flag = false;
    } else {
        datainicio.style.border = null;

    }
    if((horatermino as HTMLInputElement).value === "") {
        horatermino.style.border = "2px solid red";
        flag = false;
    } else {
        horatermino.style.border = null;

    }
    if((dataTermino as HTMLInputElement).value === "") {
        dataTermino.style.border = "2px solid red";
        flag = false;
    } else {
        dataTermino.style.border = null;

    }
    if(listaIdsProdutos.length === 0) {
        document.getElementById("listaProdutos").style.border = "2px solid red";
        flag = false;
    } else {
        document.getElementById("listaProdutos").style.border = null;

    }

    if(flag) {
        const rawResponse = await fetch('http://localhost:8080/api/leilao', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          "Authorization": `Bearer ${window.localStorage.getItem("token")}`
        },
        body: JSON.stringify(
            {
                valorInicial: parseInt((valorInicial as HTMLInputElement).value),
                valorMeta:  parseInt((valorMeta as HTMLInputElement).value),
                descricao: (descricao as HTMLTextAreaElement).value,
                categoria:  parseInt((categoria as HTMLSelectElement).value),
                dataInicio: `${(datainicio as HTMLInputElement).value}T${(horaInicio as HTMLInputElement).value}`,
                dataTermino: `${(dataTermino as HTMLInputElement).value}T${(horatermino as HTMLInputElement).value}`,
                listaProdutos: listaIdsProdutos
            }
        )
        });
    
        if (rawResponse.status == 201) {
            window.location.href = "../pages/main.html";
        }
    }
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
            html += `<div id="produto" class="${elemento["id"]}" style="border: 1px solid black; margin-top: 5pt;">
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